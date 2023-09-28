package Interface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import Classes.Toy;
import Service.Frequency;

public class NewToy {
    public static void main(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue,
            String prizeQueueFilePath)
            throws IOException, InterruptedException {
        addNewToy(toyList, scanner, prizeQueue, prizeQueueFilePath);
    }

    public static void addNewToy(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue,
            String prizeQueueFilePath)
            throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        String name = null;
        int quantity = 0;
        int frequency = 0;
        System.out.println("ADDING NEW TOY\n");

        int emptyFrequency = Frequency.emptyFrequency(toyList, scanner, prizeQueue, prizeQueueFilePath);
        if (emptyFrequency == 0) {
            System.out.println("All slots are occupied, please change frequency in the list and try again");
            PartOfMenu.showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
        }
        System.out.println("Input toy's name: ");
        try {
            String temp = scanner.nextLine();
            if (temp == "") {
                System.out.println("\nName can't be empty");
                PartOfMenu.showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
            } else {
                name = temp;
            }
        } catch (Exception e) {
            System.out.println("\nSomthing wrong");
            PartOfMenu.showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
        }
        System.out.println("Input quantity: ");
        try {
            int temp1 = Integer.parseInt(scanner.nextLine());
            if (temp1 < 1) {
                System.out.println("\nThis quantity out of range");
                PartOfMenu.showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
            } else {
                quantity = temp1;
            }
        } catch (Exception e) {
            System.out.println("\nYou need to input an integer");
            PartOfMenu.showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
        }
        System.out.println("Input frequency dropout (1-" + emptyFrequency + "): ");
        try {
            int temp2 = Integer.parseInt(scanner.nextLine());
            if (temp2 < 1 || temp2 > emptyFrequency) {
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