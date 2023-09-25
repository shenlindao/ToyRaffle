package Interface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Classes.Toy;

public class NewToy {
    public static void mainMenu(ArrayList<Toy> toyList, Scanner scanner)
            throws IOException, InterruptedException {
        addNewToy(toyList, scanner);
    }

    public static void addNewToy(ArrayList<Toy> toyList, Scanner scanner)
            throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        int quantity = 0;
        int frequency = 0;
        System.out.println("ADDING NEW TOY\n");
        System.out.println("Input toy's name: ");
        String name = scanner.nextLine();
        System.out.println("Input quantity: ");
        try {
            quantity = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("\nYou need to input an integer");
            PartOfMenu.showPart(toyList, scanner);
        }
        System.out.println("Input frequency dropout: ");
        try {
            frequency = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("\nYou need to input an integer");
            PartOfMenu.showPart(toyList, scanner);
        }
        int id = toyList.get(toyList.size() - 1).getId();
        id += 1;
        Toy newToy = new Toy(id, name, quantity, frequency);
        toyList.add(newToy);
        System.out.println("\nThe toy has been successfully added");
        PartOfMenu.showPart(toyList, scanner);
    }
}