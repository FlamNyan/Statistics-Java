import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DataProcessor {

    private Dataset dataset;
    private List<Double> numbers;
    private List<String> categories;
    private List<String> quartileCats;

    public DataProcessor(List<Double> numbers) {

        this.numbers = numbers;
        this.dataset = new Dataset(this.numbers);
        this.categories = new ArrayList<>(Arrays.asList("Mean (1)", "Median (2)", "Mode (3)", "Range (4)", "Quartiles (5)", "End (0)"));
        this.quartileCats = new ArrayList<>(Arrays.asList("First (1)", "Second (2)", "Third (3)"));

    }

    public List<Double> processUserList(Scanner scanner) {

        int amount = Input.getUserList(scanner);

        if (amount > 1) {

            System.out.println("\nWhat are your " + amount + " numbers?\n" + "(Press \"Enter\" after each number)");

            for (int items = 0; items < amount; items++) {
                if (scanner.hasNextDouble()) {

                    this.numbers.add(scanner.nextDouble());

                } else {

                    System.out.println("\nPlease input a valid number.");
                    scanner.next();  // Consume invalid input to avoid an infinite loop
                    items--;
                
                }

            }

        }

        Set<Double> uniqueNumbers = new HashSet<>(this.numbers);

        if (uniqueNumbers.size() == 1) {

            System.out.println("\nAll the numbers in your list are the same. Add more variety!");
            System.exit(0);
            
        }

        Collections.sort(this.numbers);

        System.out.println("\nWhat category would you like to find with your list:\n" + this.numbers);
        return this.numbers;

    }

    public void processUserCategory(Scanner scanner) {

        while (!categories.isEmpty()) {

            int choice = Input.getUserCategory(scanner, this.categories);

            switch (choice) {

                case 0:

                    System.out.println("\nAlright, see you again!");
                    return;

                case 1:

                    categories.remove("Mean (1)");
                    Output.printMean(dataset.getMean());
                    break;

                case 2:

                    categories.remove("Median (2)");
                    Output.printMedian(dataset.getMedian());
                    break;

                case 3:

                    categories.remove("Mode (3)");
                    Output.printMode(dataset.getMode(), this.numbers);
                    break;

                case 4:

                    categories.remove("Range (4)");
                    Output.printRange(dataset.getRange());
                    break;

                case 5:

                    Input.getQuartileCategory(scanner, this.quartileCats);
                    break;

                default:

                    Output.printErrorMessage();

            }

            if (!categories.isEmpty()) {

                System.out.println("\nWhat else would you like, or would you like to leave? (End \"(0)\")\n" + categories);
            }

        }

        if (categories.isEmpty()) {

            System.out.println("\nThat's all. See you again with another list of values!");

         }

    }

}
