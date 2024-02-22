import java.util.List;
import java.util.Scanner;

public final class Input {

    private Input() {
        
    }

    public static int getUserList(Scanner scanner) {

        System.out.println("\nHow many numbers do you want in your list of values?\n" + "(Press \"Enter\" after you're done)");

        while(!scanner.hasNextInt()) {
            System.out.println("\nPlease input a valid number.");
            scanner.next();
        }

        return scanner.nextInt();

    }
    
    public static int getUserCategory(Scanner scanner, List<String> categories) {

        System.out.println("\nType in the number of category you want to view: " + categories);

        return scanner.nextInt();

    }

    public static int getQuartileCategory(Scanner scanner, List<String> quartileCats) {

        System.out.println("\nType in the number of quartile you want to view: " + quartileCats + " or \"End (0)\" if you are done.");

        return scanner.nextInt();

    }

}