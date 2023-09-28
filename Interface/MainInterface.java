package Interface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import Classes.Toy;

public class MainInterface {
    public static void mainMenu(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue,
            String prizeQueueFilePath)
            throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("MENU");
        System.out.println();
        System.out.println("1 - Drawing a prize");
        System.out.println("2 - Show the prize list");
        System.out.println("3 - Get a prize toy");
        System.out.println("4 - Add new toy");
        System.out.println("5 - Change frequency");
        System.out.println("else key - exit program");
        System.out.println();
        System.out.println("Select the number: ");
        try {
            int menuChoise = Integer.parseInt(scanner.nextLine());
            switch (menuChoise) {
                case 1:
                    Prize.prizeDrawing(toyList, scanner, prizeQueue, prizeQueueFilePath);
                    break;
                case 2:
                    Prize.showPrizeList(toyList, scanner, prizeQueue, prizeQueueFilePath);
                    break;
                case 3:
                    Prize.getPrizeToy(toyList, scanner, prizeQueue, prizeQueueFilePath);
                    break;
                case 4:
                    NewToy.addNewToy(toyList, scanner, prizeQueue, prizeQueueFilePath);
                    break;
                case 5:
                    Edit.changeFrequency(toyList, scanner, prizeQueue, prizeQueueFilePath);
                    break;
                default:
                    System.out.println("\nHave a good day!\n");
                    System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("\nHave a good day!\n");
            System.exit(0);
        }
        scanner.close();
    }
}
