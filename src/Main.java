import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Student st1 = new Student("Mike");
        Student st2 = new Student("Alex", new ArrayList<>(List.of(2, 3, 3)));

        System.out.println(st1);
        System.out.println(st2);
    }
}