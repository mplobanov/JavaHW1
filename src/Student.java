import java.util.ArrayList;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private ArrayList<Integer> grades;


    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public Student(String name, ArrayList<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGrade(Integer grade) {
        grades.add(grade);
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void removeGrade(int index) {
        grades.remove(index);
    }

    @Override
    public String toString() {
        return name + ": [" +
                grades.stream().map(Object::toString)
                        .collect(Collectors.joining(", ")) +
                ']';
    }
}
