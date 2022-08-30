package Students;

//Zapytać się o komparator
public class Student implements Comparable<Student>{
    private String imie;
    private String nazwisko;
    private StudentCondition stan;
    private int rokUrodzenia;
    private double iloscPunktow;
    private String PESEL;
    private String email;

    public Student(
            String imie,
            String nazwisko,
            StudentCondition stan,
            int rokUrodzenia,
            int iloscPunktow,
            String PESEL,
            String email
    ) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stan = stan;
        this.rokUrodzenia = rokUrodzenia;
        this.iloscPunktow = iloscPunktow;
        this.PESEL = PESEL;
        this.email = email;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public StudentCondition getStan() {
        return stan;
    }

    public void setStan(StudentCondition stan) {
        this.stan = stan;
    }

    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    public void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }

    public double getIloscPunktow() {
        return iloscPunktow;
    }

    public void dodajPunkty(double Points) {
        this.iloscPunktow += Points;
    }

    public void setIloscPunktow(double iloscPunktow) {
        this.iloscPunktow = iloscPunktow;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void print() {
        System.out.printf("\n---- Student ----"+
                "\n \033[33m>\033[0m Imię: %s" +
                "\n \033[33m>\033[0m Nazwisko: %s" +
                "\n \033[33m>\033[0m Stan: %s" +
                "\n \033[33m>\033[0m Rok urodzenia: %s" +
                "\n \033[33m>\033[0m Ilość punktów: %s" +
                "\n \033[33m>\033[0m PESEL: %s" +
                "\n \033[33m>\033[0m Email: %s\n",
                this.imie, this.nazwisko, this.stan.toString(), this.rokUrodzenia,
                this.iloscPunktow, this.PESEL, this.email);
    }


    @Override
    public int compareTo(Student o) {
        return this.nazwisko.compareTo(o.nazwisko);
    }

}
