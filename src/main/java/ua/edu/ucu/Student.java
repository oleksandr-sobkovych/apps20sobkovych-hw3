package ua.edu.ucu;


import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter @EqualsAndHashCode
class Student {
    private final double GPA;
    private final int year;
    private final String name;
    private final String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname="
                + surname + ", " + "GPA=" + GPA + ", year=" + year + '}';
    }
}
