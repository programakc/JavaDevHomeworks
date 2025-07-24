package homeworks.homework02;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOne, numberTwo;

        System.out.print("Введите 1-е целое число: ");
        numberOne = scanner.nextInt();
        System.out.print("Введите второе целое число: ");
        numberTwo = scanner.nextInt();

        System.out.println("Сумма двух целых чисел: " + (numberOne + numberTwo));
        System.out.println("Разница двух целых чисел: " + (numberOne - numberTwo));
        System.out.println("Произведение из двух целых чисел: " + (numberOne *
                numberTwo));
        System.out.println("Среднее из двух целых чисел: " + ((numberOne +
                numberTwo) / 2.0));
        System.out.println("Расстояние двух целых чисел: " + Math.abs(numberOne -
                numberTwo));
        System.out.println("Максимальное целое число: " + Math.max(numberOne,
                numberTwo));
        System.out.println("Минимальное целое число: " + Math.min(numberOne,
                numberTwo));
    }

}
