import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws StudentException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        StudentCLI cli = new StudentCLI(System.out);
        String command;
        while (!Objects.equals(command = scanner.nextLine(), "quit")) {
            try {
                cli.executeCommand(command);
            } catch (Exception e) {
                System.out.println("error occured:" + e.getMessage());
            }

        }
    }
}