package homeworks.homework02;

import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countColumnsRows;
        String repeatElement;

        System.out.print("Введите число строк и столбцов сетки: ");
        countColumnsRows = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите повторяемый элемент сетки: ");
        repeatElement = scanner.nextLine();

        System.out.println("Сетка по запросу " + countColumnsRows + " на " +
                countColumnsRows);

        for (int i = 0; i < countColumnsRows; i++) {
            System.out.println(repeatElement.repeat(countColumnsRows));
        }

        /*for (int i = 0; i < countColumnsRows; i++) {
            for (int j = 0; j < countColumnsRows; j++) {
                System.out.print(repeatElement);
            }
            System.out.println();
        }*/
    }

}
