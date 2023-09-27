import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import Classes.Toy;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner scanner = new Scanner(System.in);

        Toy toy1 = new Toy(1, "Car", 5, 9);
        Toy toy2 = new Toy(2, "Doll", 7, 10);
        Toy toy3 = new Toy(3, "Frog", 50, 26);
        Toy toy4 = new Toy(4, "SoftBear", 20, 15);
        Toy toy5 = new Toy(5, "Robot", 15, 5);

        ArrayList<Toy> toyList = new ArrayList<>();
        toyList.add(toy1);
        toyList.add(toy2);
        toyList.add(toy3);
        toyList.add(toy4);
        toyList.add(toy5);

        Queue<Toy> prizeQueue = new LinkedList<Toy>();

        String pathProject = System.getProperty("user.dir");
        String prizeQueueFilePath = pathProject.concat("\\prizeQueue.txt");

        try {
            Interface.MainInterface.mainMenu(toyList, scanner, prizeQueue, prizeQueueFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}