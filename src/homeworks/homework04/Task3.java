package homeworks.homework04;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        String[] inputStringArray = inputString.toLowerCase().split(" ");

        char[][] words = {inputStringArray[0].toCharArray(),
                inputStringArray[1].toCharArray()};

        Arrays.sort(words[0]);
        Arrays.sort(words[1]);

        for (char[] word: words) {
            for (char letter: word) {
                System.out.print(letter);
            }
            System.out.print(" ");
        }
    }

}