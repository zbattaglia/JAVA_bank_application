import java.util.Scanner;

public class ScannerTest {
    
    public static void main(String[] args) {

        // Opens a "Scanner" to get input from user
        // scanner.close() is required to prevent resources from being used up by the scanner staying open
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number.");
        // int a = scanner.nextInt();
        // System.out.println("value = " + a);
        // above gets an integer from the user, below gets the first character input
        char c = scanner.next().charAt(0);
        System.out.println("character = " + c);
        scanner.close();

    }
}