package Interface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Classes.Toy;

public class PartOfMenu {
    public static void mainMenu(ArrayList<Toy> toyList, Scanner scanner)
            throws IOException, InterruptedException {
        showPart(toyList, scanner);
    }

    public static void showPart(ArrayList<Toy> toyList, Scanner scanner)
            throws IOException, InterruptedException {
        System.out.println("\nPress any to return to main menu");
        System.out.println();
        String entry = scanner.nextLine();
        if (!"".equals(entry) || "".equals(entry)) {
            mainMenu(toyList, scanner);
        }
        scanner.close();
    }
}
