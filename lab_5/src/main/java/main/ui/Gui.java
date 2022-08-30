package main.ui;

import main.JStudent.JUniversityTable;
import main.JStudent.UniversityTableModel;
import main.student.Class;
import main.student.ClassContainer;
import main.student.Student;
import main.student.StudentCondition;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public class Gui extends JFrame {
    static JFrame frame;
    static JPanel panel;
    static Class _group = null;
    static ClassContainer _container = null;
    static Student _student = null;

    static UniversityTableModel modelStudents;
    static UniversityTableModel modelGroups;

    static JUniversityTable studentsTable;
    static JUniversityTable groupsTable;


    static JButton studentsAddButtons;
    static JButton studentsDelButtons;
    static JButton studentsViewButtons;
    static JButton studentsEditButtons;
    static JButton studentsSortButtons;

    static JButton groupsAddButtons;
    static JButton groupsDelButtons;
    static JButton groupsEditButtons;
    static JTextField filterText = new JTextField("");
    static TableRowSorter<UniversityTableModel> sorter;

    public static void prepareSite() {
        frame = new JFrame("Dziennik");
        panel = new JPanel(new GridLayout(2, 2, 10, 10));

        Dimension d = new Dimension();
        d.width = 1280;
        d.height = 720;

        frame.add(panel);
        frame.setSize(d);
        panel.setSize(d);


        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        frame.setBackground(Color.gray);
    }

    public static void tableStudentsSite(ClassContainer container) {
        prepareSite();
        _container = container;
        modelStudents = new UniversityTableModel(new String[]{"Imie", "Nazwisko", "Indeks", "Stan"});
        modelGroups = new UniversityTableModel(new String[]{"Nazwa", "Ilośc studentów", "Maksymalna ilośc studentów"});

        JPanel tableButtons = createTableButtons();
        JPanel listButtons = createListButtons();

        JScrollPane groupList = createGroupsList();
        JScrollPane studentsList = createStudentsList();

        Listeners.studentsListener();
        Listeners.groupsListener();
        Listeners.studentsButtonsListListeners();
        Listeners.groupsButtonsListListeners();


        panel.add(groupList);
        panel.add(studentsList);
        panel.add(listButtons);
        panel.add(tableButtons);
        frame.setVisible(true);
    }

    private static JPanel createListButtons() {
        JPanel panel1 = new JPanel();
        groupsAddButtons = new JButton("+ Dodaj");
        groupsEditButtons = new JButton("Edytuj");
        groupsDelButtons = new JButton("- Usuń");

        panel1.add(groupsAddButtons);
        panel1.add(groupsDelButtons);
        panel1.add(groupsEditButtons);

        return panel1;
    }

    private static JScrollPane createGroupsList() {
        groupsTable = new JUniversityTable();
        groupsTable.doLayout();

        Listeners.fillGroups();
        return new JScrollPane(groupsTable);
    }

    private static JScrollPane createStudentsList() {
        studentsTable = new JUniversityTable();
        studentsTable.setRowSorter(sorter);
        studentsTable.doLayout();

        studentsTable.setModel(modelStudents);
        return new JScrollPane(studentsTable);
    }


    private static JPanel createTableButtons() {
        JPanel panel1 = new JPanel(new GridLayout(5, 2, 10, 10));
        studentsAddButtons = new JButton("+ Dodaj");
        studentsDelButtons = new JButton("- Usuń");
        studentsViewButtons = new JButton("Zobacz");
        studentsEditButtons = new JButton("Edytuj");
        studentsSortButtons = new JButton("Sortuj");

        filterText.setSize(300, 100);
        panel1.add(studentsAddButtons);
        panel1.add(studentsDelButtons);
        panel1.add(studentsViewButtons);
        panel1.add(studentsEditButtons);
        panel1.add(studentsSortButtons);
        panel1.add(filterText);

        return panel1;
    }

    public static void studentView() {
        JFrame frame_tmp = new JFrame("Student");
        JPanel panel_tmp = new JPanel(new GridLayout(7, 2, 0, 10));
        frame_tmp.add(panel_tmp);

        Dimension d = new Dimension();
        d.width = 300;
        d.height = 300;

        EmptyBorder b = new EmptyBorder(10, 40, 10, 40);

        frame_tmp.setSize(d);
        panel_tmp.setSize(220, 280);
        panel_tmp.setBackground(Color.gray);
        panel_tmp.setBorder(b);

        panel_tmp.add(new JLabel("Imie:"));
        panel_tmp.add(new JLabel(Gui._student.getFirstName()));

        panel_tmp.add(new JLabel("Nazwisko:"));
        panel_tmp.add(new JLabel(Gui._student.getLastName()));

        panel_tmp.add(new JLabel("Indeks:"));
        panel_tmp.add(new JLabel(String.valueOf(Gui._student.getIndex())));

        panel_tmp.add(new JLabel("Punkty:"));
        panel_tmp.add(new JLabel(String.valueOf(Gui._student.getPoints())));

        panel_tmp.add(new JLabel("Stan:"));
        panel_tmp.add(new JLabel(Gui._student.getCondition().toString()));

        panel_tmp.add(new JLabel("Email:"));
        panel_tmp.add(new JLabel(Gui._student.getEmail()));

        panel_tmp.add(new JLabel("Urodziny:"));
        panel_tmp.add(new JLabel(Gui._student.getBirthDay()));

        frame_tmp.setVisible(true);
    }

    public static void studentAdd(int indeks) {
        JFrame frame_tmp = new JFrame("Student");
        JButton zapisz = new JButton("Zapisz");
        JPanel panel_tmp = new JPanel(new GridLayout(5, 2, 0, 10));
        JTextField imie = new JTextField();
        JTextField nazwisko = new JTextField();
        JTextField punkty = new JTextField();
        JTextField stan = new JTextField();
        JTextField urodziny = new JTextField();
        JTextField email = new JTextField();

        frame_tmp.add(panel_tmp);

        Dimension d = new Dimension();
        d.width = 400;
        d.height = 400;

        EmptyBorder b = new EmptyBorder(10, 40, 10, 40);

        frame_tmp.setSize(d);
        panel_tmp.setSize(320, 380);
        panel_tmp.setBackground(Color.gray);
        panel_tmp.setBorder(b);

        panel_tmp.add(new JLabel("Imie:"));
        panel_tmp.add(imie);

        panel_tmp.add(new JLabel("Nazwisko:"));
        panel_tmp.add(nazwisko);

        panel_tmp.add(new JLabel("Data urodzin:"));
        panel_tmp.add(urodziny);

        panel_tmp.add(new JLabel("Email:"));
        panel_tmp.add(email);

        panel_tmp.add(new JLabel());
        panel_tmp.add(zapisz);

        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Student s = new Student(
                        imie.getText(),
                        nazwisko.getText(),
                        StudentCondition.OBECNY,
                        urodziny.getText(),
                        0,
                        indeks,
                        email.getText()
                );

                Gui._group.addStudent(s);
                Listeners.fillStudents();
                Listeners.fillGroups();

                frame_tmp.dispose();
            }
        });
        frame_tmp.setVisible(true);
    }

    public static void editStudent() {
        JFrame frame_tmp = new JFrame("Student");
        JButton zapisz = new JButton("Zapisz");
        JPanel panel_tmp = new JPanel(new GridLayout(7, 2, 0, 10));
        JTextField imie = new JTextField(Gui._student.getFirstName());
        JTextField nazwisko = new JTextField(Gui._student.getLastName());
        JTextField punkty = new JTextField(String.valueOf(Gui._student.getPoints()));

        StudentCondition[] stans = StudentCondition.values();

        JList stan = new JList(stans);
        stan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        stan.setSelectedIndex(Arrays.asList(stans).indexOf(Gui._student.getCondition()));
        stan.setVisibleRowCount(3);

        JScrollPane jScrollPane = new JScrollPane(stan);

        JTextField urodziny = new JTextField(Gui._student.getBirthDay());
        JTextField email = new JTextField(Gui._student.getEmail());
        frame_tmp.add(panel_tmp);

        Dimension d = new Dimension();
        d.width = 600;
        d.height = 600;

        EmptyBorder b = new EmptyBorder(10, 40, 10, 40);

        frame_tmp.setSize(d);
        panel_tmp.setSize(520, 580);
        panel_tmp.setBackground(Color.gray);
        panel_tmp.setBorder(b);

        panel_tmp.add(new JLabel("Imie:"));
        panel_tmp.add(imie);

        panel_tmp.add(new JLabel("Nazwisko:"));
        panel_tmp.add(nazwisko);

        panel_tmp.add(new JLabel("Punkty:"));
        panel_tmp.add(punkty);

        panel_tmp.add(new JLabel("Stan:"));
        panel_tmp.add(jScrollPane);

        panel_tmp.add(new JLabel("Email:"));
        panel_tmp.add(email);

        panel_tmp.add(new JLabel("Urodziny:"));
        panel_tmp.add(urodziny);

        panel_tmp.add(new JLabel());
        panel_tmp.add(zapisz);

        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Gui._student.setBirthDay(urodziny.getText());
                Gui._student.setFirstName(imie.getText());
                Gui._student.setLastName(nazwisko.getText());
                Gui._student.setEmail(email.getText());
                Gui._student.setPoints(Double.parseDouble(punkty.getText()));
                Gui._student.setBirthDay(urodziny.getText());

                Listeners.fillStudents();

                frame_tmp.dispose();
            }
        });

        frame_tmp.setVisible(true);
    }

    public static void editGroup() {
        JFrame frame_tmp = new JFrame("Grupy");
        JButton zapisz = new JButton("Zapisz");
        JPanel panel_tmp = new JPanel(new GridLayout(3, 2, 0, 10));


        JTextField grupa = new JTextField(Gui._group.getGroupName());
        JTextField count = new JTextField(String.valueOf(Gui._group.getMaxStudentsCount()));

        Dimension d = new Dimension();
        d.width = 600;
        d.height = 600;

        EmptyBorder b = new EmptyBorder(10, 40, 10, 40);

        frame_tmp.setSize(d);
        panel_tmp.setSize(520, 580);
        panel_tmp.setBackground(Color.gray);
        panel_tmp.setBorder(b);

        panel_tmp.add(new JLabel("Nazwa:"));
        panel_tmp.add(grupa);

        panel_tmp.add(new JLabel("Studenci:"));
        panel_tmp.add(count);

        panel_tmp.add(new JLabel());
        panel_tmp.add(zapisz);

        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Class grupa_tmp = Gui._group;
                Gui._group = null;

                Gui._container.removeClass(grupa_tmp.getGroupName());
                grupa_tmp.setGroupName(grupa.getText());
                grupa_tmp.setMaxStudentsCount(Double.parseDouble(count.getText()));

                Gui._container.addClass(grupa_tmp);
                Gui._group = grupa_tmp;

                Gui.groupsTable.doLayout();

                Listeners.fillGroups();
                Listeners.fillStudents();


                frame_tmp.dispose();
            }
        });

        frame_tmp.add(panel_tmp);
        frame_tmp.setVisible(true);

    }

    public static void addGroup() {
        JFrame frame_tmp = new JFrame("Grupy");
        JButton zapisz = new JButton("Zapisz");
        JPanel panel_tmp = new JPanel(new GridLayout(3, 2, 0, 10));


        JTextField grupa = new JTextField();
        JTextField count = new JTextField();

        Dimension d = new Dimension();
        d.width = 600;
        d.height = 600;

        EmptyBorder b = new EmptyBorder(10, 40, 10, 40);

        frame_tmp.setSize(d);
        panel_tmp.setSize(520, 580);
        panel_tmp.setBackground(Color.gray);
        panel_tmp.setBorder(b);

        panel_tmp.add(new JLabel("Nazwa:"));
        panel_tmp.add(grupa);

        panel_tmp.add(new JLabel("Studenci:"));
        panel_tmp.add(count);

        panel_tmp.add(new JLabel());
        panel_tmp.add(zapisz);

        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Gui._container.addClass(grupa.getText(), Double.parseDouble(count.getText()));
                Gui._group = Gui._container.getClass(grupa.getText());

                Gui.groupsTable.doLayout();

                Listeners.fillGroups();
                Listeners.fillStudents();


                frame_tmp.dispose();
            }
        });

        frame_tmp.add(panel_tmp);
        frame_tmp.setVisible(true);

    }

    public static void delGroup() {
        Gui._container.removeClass(Gui._group.getGroupName());
        Gui._group = null;

        Gui.groupsTable.doLayout();

        Listeners.fillGroups();
        Listeners.fillStudents();
    }

    public static void sortStudent() {
        Gui._group.sortByName();
        Listeners.fillStudents();
    }
}
