package Interface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import Classes.Toy;

public class PartOfMenu {
    public static void partMenu(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue,
            String prizeQueueFilePath)
            throws IOException, InterruptedException {
        showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
    }

    public static void showPart(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue,
            String prizeQueueFilePath)
            throws IOException, InterruptedException {
        System.out.println("\nPress any to return to main menu");
        System.out.println();
        String entry = scanner.nextLine();
        if (!"".equals(entry) || "".equals(entry)) {
            Interface.MainInterface.mainMenu(toyList, scanner, prizeQueue, prizeQueueFilePath);
        }
        scanner.close();
    }
}
