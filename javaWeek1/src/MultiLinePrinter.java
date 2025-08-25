import java.util.Scanner;

public class MultiLinePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        for (int i = 0; i < num; i++) {
            System.out.println(str);
        }

        scanner.close();
    }
}