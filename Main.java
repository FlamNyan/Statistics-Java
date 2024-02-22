import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        System.out.println("This is a program that takes a set amount of numbers (that you set) and allows you to input that many numbers in, in order to find the mean, median, mode, and/or range of that data set.\n");

        Scanner listScanner = new Scanner(System.in);
        Scanner categoryScanner = new Scanner(System.in);

        List<Double> listItems = new ArrayList<>();
        DataProcessor dataProcessor = new DataProcessor(listItems);

        dataProcessor.processUserList(listScanner);
        dataProcessor.processUserCategory(categoryScanner);

        listScanner.close();
        categoryScanner.close();


    }

}
