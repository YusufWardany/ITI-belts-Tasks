import java.util.Scanner;

public class InputCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter something: ");
        String input = scanner.nextLine();
        System.out.println("You entered: " + input);
        scanner.close();
    }
}