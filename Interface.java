import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
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
                    partOfMenu(toyList, scanner);
                    break;
                case 2:
                    // showPrizeList(toyList, scanner);
                    System.out.println("developing\n");
                    System.out.println("please try later...\n");
                    partOfMenu(toyList, scanner);
                    break;
                case 3:
                    // getPrizeToy(toyList, scanner);
                    System.out.println("developing\n");
                    System.out.println("please try later...\n");
                    partOfMenu(toyList, scanner);
                    break;
                case 4:
                    addNewToy(toyList, scanner);
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

    private static void addNewToy(ArrayList<Toy> toyList, Scanner scanner)
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
            partOfMenu(toyList, scanner);
        }
        System.out.println("Input frequency dropout: ");
        try {
            frequency = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("\nYou need to input an integer");
            partOfMenu(toyList, scanner);
        }
        int id = toyList.get(toyList.size() - 1).getId();
        id += 1;
        Toy newToy = new Toy(id, name, quantity, frequency);
        toyList.add(newToy);
        System.out.println("\nThe toy has been successfully added");
        partOfMenu(toyList, scanner);
    }

    private static void partOfMenu(ArrayList<Toy> toyList, Scanner scanner)
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
