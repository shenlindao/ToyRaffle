package Interface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Classes.Toy;

public class MainInterface {
    public static void mainMenu(ArrayList<Toy> toyList, Scanner scanner)
            throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("MENU");
        System.out.println();
        System.out.println("1 - Drawing a prize");
        System.out.println("2 - Show the prize list");
        System.out.println("3 - Get a prize toy");
        System.out.println("4 - Add new toy");
        System.out.println("else key - exit program");
        System.out.println();
        System.out.println("Select the number: ");
        try {
            int menuChoise = Integer.parseInt(scanner.nextLine());
            switch (menuChoise) {
                case 1:
                    // prizeDrawing(toyList, scanner);
                    System.out.println("developing\n");
                    System.out.println("please try later...\n");
                    PartOfMenu.showPart(toyList, scanner);
                    break;
                case 2:
                    // showPrizeList(toyList, scanner);
                    System.out.println("developing\n");
                    System.out.println("please try later...\n");
                    PartOfMenu.showPart(toyList, scanner);
                    break;
                case 3:
                    // getPrizeToy(toyList, scanner);
                    System.out.println("developing\n");
                    System.out.println("please try later...\n");
                    PartOfMenu.showPart(toyList, scanner);
                    break;
                case 4:
                    NewToy.addNewToy(toyList, scanner);
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
