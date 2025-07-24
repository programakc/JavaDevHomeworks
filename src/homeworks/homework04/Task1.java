package homeworks.homework04;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyboardLayout = "qwertyuiopasdfghjklzxcvbnm";

        System.out.print("Введите маленькую букву английского алфавита: ");

        String enteredLetter = scanner.next();
        int positionLetter = keyboardLayout.indexOf(enteredLetter);

        if (positionLetter == 0) {
            System.out.println(keyboardLayout.charAt(keyboardLayout.length() - 1));
        } else {
            System.out.println(keyboardLayout.charAt(positionLetter - 1));
        }
    }

}