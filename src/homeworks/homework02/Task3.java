package homeworks.homework02;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String originalStr;
        int countOfIterations;

        System.out.print("Исходная строка: ");
        originalStr = scanner.nextLine();
        System.out.print("Сколько раз вывести строку? ");
        countOfIterations = scanner.nextInt();
        System.out.print("После повторения " + countOfIterations + " раз: ");
        System.out.println(originalStr.repeat(countOfIterations));
    }

}