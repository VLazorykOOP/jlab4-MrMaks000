import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(" Lab4 Java ");
	// write your code here

        System.out.println(" Task1 ");
        String inputFileName = "Task_1_in.txt";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter output file name: ");
        String outputFileName = scanner.nextLine();  //Task_1_out.txt
        try {
            StringCleaner.cleanAndSort(inputFileName, outputFileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println(" Task2 ");
        System.out.print("Enter input file 1 name: ");
        String file1 = scanner.nextLine();  //Task_2_in_1.txt
        System.out.print("Enter input file 2 name: ");
        String file2 = scanner.nextLine();  //Task_2_in_2.txt
        System.out.print("Enter output file name: ");
        String outputFile = scanner.nextLine();  //Task_2_out.txt
        try {
            WordMatcher.matchWords(file1, file2, outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



