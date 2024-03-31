import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws StudentException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Student st2 = new Student<Integer>("Alex", new ArrayList<>(List.of(2, 4)) ,(grade) -> grade % 2 == 0);
        System.out.println(st2);
        st2.removeGrade(0);
        System.out.println(st2);
        st2.undo();
        System.out.println(st2);
    }
}