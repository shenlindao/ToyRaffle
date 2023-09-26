package Interface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import Classes.Toy;

public class Prize {
    public static void mainMenu(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue)
            throws IOException, InterruptedException {
        prizeDrawing(toyList, scanner, prizeQueue);
    }

    public static void prizeDrawing(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue)
            throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("PRIZE DRAWING");
        System.out.println();
        System.out.println("1 - Start");
        System.out.println("2 - Get a prize toy");
        System.out.println("3 - Return to main menu");
        System.out.println("else key - exit program");
        System.out.println();
        System.out.println("Select the number: ");
        try {
            int menuChoise = Integer.parseInt(scanner.nextLine());
            switch (menuChoise) {
                case 1:
                    startDrawing(toyList, scanner, prizeQueue);
                    break;
                case 2:
                    getPrizeToy(toyList, scanner, prizeQueue);
                    break;
                case 3:
                    Interface.MainInterface.mainMenu(toyList, scanner, prizeQueue);
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

    public static void startDrawing(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue)
            throws IOException, InterruptedException {
        // взять тойлист
        // выбрать рандомную игрушку
        // показать её
        // добавить в очередь на выдачу
        // удалить из основого списка
        // вернуться
        Toy prizeToy = anyToy(toyList);
        System.out.println(prizeToy);
        prizeQueue.add(prizeToy);
        PartOfMenu.showPart(toyList, scanner);
    }

    public static void getPrizeToy(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue)
            throws IOException, InterruptedException {
        //  взять очередь    
        //  выдать игрушку (показать)
        //  удалить из очереди
        //  вернуться

        Object firstToy = prizeQueue.element();
        System.out.println(firstToy);
        prizeQueue.remove(firstToy);
        PartOfMenu.showPart(toyList, scanner);

    }

    public static Toy anyToy(ArrayList<Toy> toyList)
    {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(toyList.size());
        Toy prizeToy = toyList.get(index);
        return prizeToy;
    }

    public static void showPrizeList(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue)
            throws IOException, InterruptedException {
        System.out.println(prizeQueue);
        PartOfMenu.showPart(toyList, scanner);
    }
}
