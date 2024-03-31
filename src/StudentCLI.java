import java.io.PrintStream;

public class StudentCLI {
    private Student<Integer> student;
    private PrintStream sout;

    public StudentCLI(PrintStream sout) {
        this.sout = sout;
    }

    public void executeCommand(String command) {
        if (command.startsWith("create")) {
            create(command.split(" ")[1]);
            return;
        } else if (command.startsWith("add")) {
            add(Integer.parseInt(command.split(" ")[1]));
            return;
        } else if (command.startsWith("pop")) {
            remove(Integer.parseInt(command.split(" ")[1]));
            return;
        } else if (command.startsWith("get")) {
            get();
            return;
        }
        onError("command not found");
    }

    private void create(String name) {
        try {
            student = new Student<>(name);
            onSuccess("student created/refreshed");
        } catch (StudentException e) {
            onError("invalid name");
        }
    }

    private void remove(Integer grade) {
        int index = student.getGrades().lastIndexOf(grade);
        if (index != -1) {
            student.removeGrade(index);
            onSuccess("grade popped");
        } else {
            onSuccess("grade not found");
        }
    }

    private void add(Integer grade) {
        try {
            student.addGrade(grade);
            onSuccess("grade added");
        } catch (StudentException e) {
            onError("adding grade failed");
        }
    }

    private void get() {
        sout.println(student);
    }

    private void onError(String errorMessage) {
        sout.println(errorMessage);
    }

    private void onSuccess(String message) {
        sout.println(message);
    }
}
