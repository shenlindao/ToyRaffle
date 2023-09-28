package Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import Classes.Toy;

public class Frequency {
    public static void mainMenu(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue,
            String prizeQueueFilePath)
            throws IOException, InterruptedException {
        emptyFrequency(toyList, scanner, prizeQueue, prizeQueueFilePath);
    }

    public static int emptyFrequency(ArrayList<Toy> toyList, Scanner scanner, Queue<Toy> prizeQueue,
            String prizeQueueFilePath)
            throws IOException, InterruptedException {
        int count = 0;
        for (Toy toy : toyList) {
            count = count + toy.getFrequency();
        }
        int emptyFrequency = 100 - count;
        return emptyFrequency;
    }
}