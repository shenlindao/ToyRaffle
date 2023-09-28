package Interface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ListIterator;
import Classes.Toy;
import Service.Frequency;

public class Edit {
    public static void mainMenu(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue,
            String prizeQueueFilePath)
            throws IOException, InterruptedException {
        changeFrequency(toyList, scanner, prizeQueue, prizeQueueFilePath);
    }

    public static void changeFrequency(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue,
            String prizeQueueFilePath)
            throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("CHANGE FREQUENCY\n");
        System.out.println(toyList);
        System.out.println("\nInput toy's id: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (id < 1 || id > toyList.get(toyList.size() - 1).getId()) {
            System.out.println("\nToy with this id was not found");
            PartOfMenu.showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
        }
        Toy changeToy = null;
        ListIterator<Toy> iterator = toyList.listIterator();
        while (iterator.hasNext()) {
            changeToy = iterator.next();
            if (id == changeToy.getId()) {
                break;
            }
        }
        int empty = Frequency.emptyFrequency(toyList, scanner, prizeQueue, prizeQueueFilePath)
                + changeToy.getFrequency();
        System.out.println("\nYou whant to change");
        System.out.println(changeToy);
        System.out.println("\nPlease set new frequency for this toy (1 - " + empty + "): ");
        int frequency = 0;
        try {
            int newFrequency = Integer.parseInt(scanner.nextLine());
            if (newFrequency < 1 || newFrequency > empty) {
                System.out.println("\nThis frequency out of range");
                PartOfMenu.showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
            } else {
                frequency = newFrequency;
                toyList.get(changeToy.getId() - 1).setFrequency(frequency);
                System.out.println("\nThe toy's frequency has been successfully changed");
                PartOfMenu.showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
            }
        } catch (Exception e) {
            System.out.println("\nYou need to input an integer");
            PartOfMenu.showPart(toyList, scanner, prizeQueue, prizeQueueFilePath);
        }
    }
}