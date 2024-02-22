import java.util.List;
import java.util.HashSet;

public final class Output {

    private Output() {
        
    }
    
    public static void printMean(double[] mean) {

        if (mean[0] % 1 == 0.0) {

            System.out.println("\nThe mean of your data set is: " + mean[0]);

        } else {

            double roundedMean = Math.round(mean[0]);
            double diff = Math.abs(mean[0] - roundedMean);

            if (diff < 0.1) {
                
                System.out.println("\nThe mean of your data set is about: " + mean[0] + " or " + Math.round(mean[0]));

            } else {

                System.out.println("\nThe mean of your data set is about: " + mean[1] + " or " + mean[0]);

            }

        }

    }

    public static void printMedian(double median) {

        System.out.println("\nThe median of your data set is: " + median);

    }

    public static void printMode(List<Double> mode, List<Double> numbers) {

        HashSet<Double> uniqueNumbers = new HashSet<>(numbers);

        if (mode.size() == uniqueNumbers.size()) {

            System.out.println("\nYou have no specfic mode(s) from this data set.");

        } else if (mode.size() > 1) {

            System.out.println("\nThe modes of your data set are: " + mode);

        } else {

            System.out.println("\nThe mode of your data set is: " + mode);

        }

    }

    public static void printRange(double range) {

        System.out.println("\nThe range of your data set is: " + range);

    }

    public static void printQuartiles(double quartiles) {

        System.out.println("The first quartile of your data set is: " + quartiles);
    }

    public static void printErrorMessage() {

        System.out.println("\nERROR: INCORRECT INPUT! Please type in a valid category or \"End\" if you would like to leave.");

    }
    
}
