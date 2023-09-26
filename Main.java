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
        Toy toy1 = new Toy(1, "Car", 5, 30);
        Toy toy2 = new Toy(2, "Doll", 7, 20);
        Toy toy3 = new Toy(3, "Frog", 50, 60);
        Toy toy4 = new Toy(4, "SoftBear", 20, 15);
        Toy toy5 = new Toy(5, "Robot", 15, 5);

        ArrayList<Toy> toyList = new ArrayList<>();
        toyList.add(toy1);
        toyList.add(toy2);
        toyList.add(toy3);
        toyList.add(toy4);
        toyList.add(toy5);

        Queue<Toy> prizeQueue = new LinkedList<Toy>();

        try {
            Interface.MainInterface.mainMenu(toyList, scanner, prizeQueue);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}