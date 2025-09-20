package homeworks.homework12;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String enteredString = scanner.nextLine();

        try {
            Person person = new Person(enteredString);

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                    "src/homeworks/homework12/" + person.getLastName() + ".txt"))) {

                bufferedWriter.write(enteredString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
