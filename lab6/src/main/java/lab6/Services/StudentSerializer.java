package lab6.Services;

import lab6.Student.CSV;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class StudentSerializer
{
    private static String[] readObject(Object object) throws IllegalAccessException {

        Field[] fields = object.getClass().getDeclaredFields();

        List<String> fields_s = new ArrayList<>();

        if(object.getClass().getGenericSuperclass() == Number.class || object.getClass() == String.class) {
            fields_s.add(object.toString());
            return fields_s.toArray(new String[0]);
        }

        for (Field field : fields) {
            if (field.isAnnotationPresent(CSV.class)) {
                field.setAccessible(true);

                if(field.getType().isPrimitive() || field.getType() == String.class) {
                    fields_s.add(field.get(object).toString());

                } else {
                    Object object_tmp = field.get(object);

                    if(object_tmp instanceof HashMap) {
                        Object[] data =  ((HashMap<?, ?>) object_tmp).values().toArray();
                        Object[] keys =  ((HashMap<?, ?>) object_tmp).keySet().toArray();

                        try {
                            int c = 0;
                            for (int i = 0; i < data.length; i++) {
                                serializeCsv(new Object[]{data[i]}, new Object[]{keys[i], object});
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else if (object_tmp instanceof List) {

                        try {
                            serializeCsv(((List<?>) object_tmp).toArray(), new Object[]{object});
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {
                        fields_s.add(field.get(object).toString());
                    }
                }
            }
        }


        return fields_s.toArray(new String[0]);
    }

    private static String[] readHeaders(Class object) {
        Field[] fields = object.getDeclaredFields();

        List<String> fields_s = new ArrayList<>();

        if(object.getGenericSuperclass() == Number.class || object.getDeclaringClass() == String.class) {
            fields_s.add("_value_");
            return fields_s.toArray(new String[0]);
        }

        for (Field field : fields) {
            if (field.isAnnotationPresent(CSV.class)) {
                if(field.getType().isPrimitive() || field.getType() == String.class) {
                    fields_s.add(field.getName().toLowerCase());
                } else if (field.getType() != ArrayList.class
                        && field.getType() != Map.class ) {
                    fields_s.add(field.getName().toLowerCase());
                }
            }
        }

        return fields_s.toArray(new String[0]);
    }


    private static String[][] createArray(Object[] objects, Object[] parents, boolean _new) throws IllegalAccessException {
        if(objects.length == 0) {
            return new String[][]{};
        }

        List<String[]> rows = new ArrayList<>();
        List<String> list = new ArrayList<>(List.of(readHeaders(objects[0].getClass())));

        if(parents != null) {

            for(int i = 0; i < parents.length; i++) {
                list.add(parents[i].getClass() == String.class ? "key_parent_" + i :
                        parents[i].getClass().getSimpleName().toLowerCase() + "_parent_" + i);
            }

        }

        if(_new) {
            rows.add(list.toArray(new String[0]));
        }

        for (Object object: objects) {
            List<String> row = new ArrayList<>(List.of(readObject(object)));

            if(parents != null) {
                for(int i = 0; i < parents.length; i++) {
                    row.add(parents[i].toString());
                }
            }

            rows.add(row.toArray(new String[0]));
        }

        return rows.toArray(new String[0][0]);

    }

    public static void serializeCsv(Object[] objects, Object[] parents) throws IllegalAccessException, IOException {
        if(objects.length == 0) {
            return;
        }

        File file = new File("./csv/" + objects[0].getClass().getSimpleName() + ".csv");

        if (parents == null) {
            File f_tmp = new File("./csv/");
            if(f_tmp.exists() && f_tmp.isDirectory()) {
                Arrays.stream(f_tmp.listFiles()).forEach(File::delete);
                f_tmp.delete();
            }

            f_tmp.mkdir();

        }

        String[][] list = createArray(objects, parents, !file.exists());
        if(list.length == 0) {
            return;
        }

        if(!file.exists()) {
            file.createNewFile();
        }

        file = new File("./csv/" + objects[0].getClass().getSimpleName() + ".csv");
        FileWriter fWriter = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter writer = new BufferedWriter(fWriter);

        for(String[] row: list) {
            for(String col: row) {
                writer.write(col + ";");
            }

            writer.newLine();
        }

        writer.close();
        fWriter.close();
    }



    public static <T> T[] importCSV(Class<T> _class, Object parent) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        String path = "./csv/" + _class.getSimpleName() + ".csv";
        File file = new File(path);

        List<T> list = new ArrayList<>();
        List<String> headers = new ArrayList<>();

        if(!file.exists()) {
            throw new IOException("Plik: " + path + "; nie istnieje");
        }

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        headers.addAll(List.of(reader.readLine().split(";")));

        String line;
        while((line=reader.readLine())!=null)
        {
            String[] values = line.split(";");

            T object = _class.getConstructor().newInstance();
            Field[] fields = _class.getDeclaredFields();

            int count = 0;
            for(Field field: fields) {
                if(!field.isAnnotationPresent(CSV.class)){
                    continue;
                }

                field.setAccessible(true);
                if(field.getType().isPrimitive() || field.getType() == String.class) {
                    for (String head: headers.toArray(new String[0])) {
                        if(field.getName().toLowerCase().equals(head)) {


                            try{
                                field.set(object, Double.valueOf(values[count]));
                            } catch (Exception e) {
                                try{
                                    field.set(object, Integer.valueOf(values[count]));
                                } catch (Exception e1) {
                                    field.set(object, values[count]);
                                }
                            } finally {
                                break;
                            }


                        }
                    }
                } else {
                    if(field.getType() == Map.class) {
                        ParameterizedType type = (ParameterizedType) field.getGenericType();
                        field.set(object, importCSVMap(
                                type.getActualTypeArguments()[0], type.getActualTypeArguments()[1],
                                object));
                    } else if(field.getType() == List.class) {
                        field.set(object, List.of(importCSV(field.getType(), object)));
                    } else {
//                        field.set(object, importCSV(field.getType(), object));
                        throw new IOException("Zerknij");
                    }
                }

                count++;
            }

            list.add(object);
        }

        T[] list_t = (T[]) Array.newInstance(_class, list.size());

        return list.toArray(list_t);
    }

    public static Map<Object, Object> importCSVMap(Type key, Type value, Object parent) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class _key = Class.forName(key.getTypeName());
        Class _value = Class.forName(value.getTypeName());

        String path = "./csv/" + _value.getSimpleName() + ".csv";
        File file = new File(path);

        Map<Object, Object> map = new HashMap<>();

        List<String> headers = new ArrayList<>();

        if(!file.exists()) {
            throw new IOException("Plik: " + path + "; nie istnieje");
        }

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        headers.addAll(List.of(reader.readLine().split(";")));

        String line;
        while((line=reader.readLine())!=null)
        {
            String[] values = line.split(";");

            if(parent == null || !values[values.length - 1].equals(parent.toString())) {
                continue;
            }

            if(headers.toArray()[0].equals("value")) {
                if(_value == Double.class) {
                    map.put(values[values.length - 2], Double.valueOf(values[0]));
                } else {
                    map.put(values[values.length - 2], values[0]);
                }
                continue;
            }

            Constructor c = _value.getConstructors()[0];

            Type [] ts = c.getGenericParameterTypes();
            Object object;
            if(ts.length > 0) {
                if(_value.getGenericSuperclass() == Number.class) {
                    object = c.newInstance(0);
                } else if(_value.getDeclaringClass() == Character.class) {
                    object = c.newInstance('c');
                } else {
                    object = c.newInstance("");
                }

            } else {
                object = c.newInstance();
            }

            Field[] fields = _value.getDeclaredFields();

            if(ts.length > 0) {
                System.out.println(123);
            }

            int count = 0;
            for(Field field: fields) {
                if(!field.isAnnotationPresent(CSV.class)){
                    continue;
                }

                field.setAccessible(true);
                if(field.getType().isPrimitive() || field.getType() == String.class) {
                    for (String head: headers.toArray(new String[0])) {
                        if(field.getName().toLowerCase().equals(head)) {

                            try{
                                field.set(object, Double.valueOf(values[count]));
                            } catch (Exception e) {
                                try{
                                    field.set(object, Integer.valueOf(values[count]));
                                } catch (Exception e1) {
                                    field.set(object, values[count]);
                                }
                            }

//                        field.set(object, field.getType().cast(values[count]) );
                        }
                    }
                } else {
                    if(field.getType() == Map.class) {
                        ParameterizedType type = (ParameterizedType) field.getGenericType();
                        field.set(object, importCSVMap(
                                type.getActualTypeArguments()[0], type.getActualTypeArguments()[1],
                                object));
                    } else if(field.getType() == List.class) {
                        ParameterizedType type = (ParameterizedType) field.getGenericType();

                        Type t = type.getActualTypeArguments()[0];

                        field.set(object, List.of(importCSV(Class.forName(t.getTypeName()), object)));
                    } else {
//                        field.set(object, importCSV(field.getType(), object));
                        throw new IOException("Zerknij");
                    }
                }

                count++;

            }

            map.put(values[values.length - 2], object);
        }

        return map;
    }
}
