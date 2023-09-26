package Interface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import Classes.Toy;

public class NewToy {
    public static void mainMenu(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue,
            String prizeQueueFilePath)
            throws IOException, InterruptedException {
        addNewToy(toyList, scanner, prizeQueue, prizeQueueFilePath);
    }

    public static void addNewToy(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue,
            String prizeQueueFilePath)
            throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        int quantity = 0;
        int frequency = 0;
        System.out.println("ADDING NEW TOY\n");
        System.out.println("Input toy's name: ");
        String name = scanner.nextLine();
        System.out.println("Input quantity: ");
        try {
            int temp1 = Integer.parseInt(scanner.nextLine());
            if (temp1 < 1) {
                System.out.println("\nThis quantity out of range");
                PartOfMenu.showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
            } else {
                quantity = temp1;
            }
            quantity = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("\nYou need to input an integer");
            PartOfMenu.showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
        }
        System.out.println("Input frequency dropout (1-100): ");
        try {
            int temp2 = Integer.parseInt(scanner.nextLine());
            if (temp2 < 1 || temp2 > 100) {
                System.out.println("\nThis frequency out of range");
                PartOfMenu.showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
            } else {
                frequency = temp2;
            }
        } catch (Exception e) {
            System.out.println("\nYou need to input an integer");
            PartOfMenu.showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
        }
        int id = toyList.get(toyList.size() - 1).getId();
        id += 1;
        Toy newToy = new Toy(id, name, quantity, frequency);
        toyList.add(newToy);
        System.out.println("\nThe toy has been successfully added");
        PartOfMenu.showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
    }
}