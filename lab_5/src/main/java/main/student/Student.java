package main.student;

//Zapytać się o komparator
public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private StudentCondition condition;
    private String birthDay;
    private double points;
    private int index;
    private String email;

    public Student(
            String firstName,
            String lastName,
            StudentCondition condition,
            String birthDay,
            int points,
            int index,
            String email
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.condition = condition;
        this.birthDay = birthDay;
        this.points = points;
        this.index = index;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudentCondition getCondition() {
        return condition;
    }

    public void setCondition(StudentCondition condition) {
        this.condition = condition;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public double getPoints() {
        return points;
    }

    public void addPoints(double Points) {
        this.points += Points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] __toArray() {
        return new String[] {this.firstName, this.lastName, String.valueOf(this.index), this.condition.toString() };
    }

    public void print() {
        System.out.printf("\n---- Student ----"+
                "\n \033[33m>\033[0m Imię: %s" +
                "\n \033[33m>\033[0m Nazwisko: %s" +
                "\n \033[33m>\033[0m Stan: %s" +
                "\n \033[33m>\033[0m Rok urodzenia: %s" +
                "\n \033[33m>\033[0m Ilość punktów: %s" +
                "\n \033[33m>\033[0m Indeks: %d" +
                "\n \033[33m>\033[0m Email: %s\n",
                this.firstName, this.lastName, this.condition.toString(), this.birthDay,
                this.points, this.index, this.email);
    }


    @Override
    public int compareTo(Student o) {
        return this.lastName.compareTo(o.lastName);
    }

}
