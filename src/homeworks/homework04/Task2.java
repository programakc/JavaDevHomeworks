package homeworks.homework04;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task2 {

    public static void main(String[] args) {
        int result = 0;

        Scanner scanner = new Scanner(System.in);
        String enteredString = scanner.next();

        Pattern arrowRight = Pattern.compile(">>-->");
        Pattern arrowLeft = Pattern.compile("<--<<");

        Matcher matcherArrowRight = arrowRight.matcher(enteredString);
        Matcher matcherArrowLeft = arrowLeft.matcher(enteredString);

        if (enteredString.length() > 106) {
            System.out.println("Строка должна содержать до 106 символов.");
        } else {
            while (matcherArrowRight.find() || matcherArrowLeft.find()) {
                result++;
            }

            System.out.println(result);
        }
    }

}