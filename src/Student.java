import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Student<Grade>  {
    private String name;
    private final ArrayList<Grade> grades;

    private Predicate<Grade> isGradeValid;

    private final LinkedList<Runnable> cancelActions = new LinkedList<>();

    public Student(String name) throws StudentException {
        if (!name.matches("[A-Z][a-zA-Z]*")) {
            throw new StudentException("Incorrect name");
        }
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public Student(String name, Predicate<Grade> isGradeValid) throws StudentException {
        this(name);
        this.isGradeValid = isGradeValid;
    }

    public Student(String name, ArrayList<Grade> grades) throws StudentException {
        if (!name.matches("[A-Z][a-zA-Z]*")) {
            throw new StudentException("Incorrect name");
        }
        this.name = name;
        this.grades = grades;
    }

    public Student(String name, ArrayList<Grade> grades, Predicate<Grade> isGradeValid) throws StudentException  {
        this(name, grades);
        this.isGradeValid = isGradeValid;
        if (grades.stream().anyMatch((grade) -> !isGradeValid.test(grade))) {
            throw new StudentException("Incorrect grades upon construction");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws StudentException {
        if (!name.matches("[A-Z][a-zA-Z]*")) {
            throw new StudentException("Incorrect name");
        }
        String oldName = getName();
        this.name = name;
        cancelActions.add(() -> {try { setName(oldName); } catch (Exception ignored) {}});
    }

    public void addGrade(Grade grade) throws StudentException {
        if (isGradeValid != null && !isGradeValid.test(grade)) {
            throw new StudentException("Incorrect grade");
        }
        grades.add(grade);
        cancelActions.add(() -> grades.remove(grades.size() - 1));
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void removeGrade(int index) {
        Grade removedGrade = grades.remove(index);
        cancelActions.add(() -> { grades.add(index, removedGrade);});
    }

    public void undo() {
        cancelActions.pop().run();
    }

    @Override
    public String toString() {
        return name + ": [" +
                grades.stream().map(Object::toString)
                        .collect(Collectors.joining(", ")) +
                ']';
    }
}
