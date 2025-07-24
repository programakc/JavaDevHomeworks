package homeworks.homework03;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        TV tv = new TV("LG", "65UT91006LA", 40, "3840x2160", "QLED/NEO");
        TV samsungTV = new TV("QN90D", 65, "3840x2160", "Neo QLED");
        TV defaultTV = new TV();
        TV userTV = new TV();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + tv + "\n");

        tv.turnOnTV();
        tv.turnOffTV();

        System.out.println("\n" + samsungTV + "\n");
        System.out.println(defaultTV + "\n");

        System.out.print("Введите производителя ТВ: ");
        userTV.setManufacturerTV(scanner.next());

        System.out.print("Введите модель ТВ: ");
        userTV.setModelTV(scanner.next());

        System.out.print("Введите диагональ экрана: ");
        userTV.setDiagonalScreen(scanner.nextInt());

        System.out.print("Введите разрешение экрана: ");
        userTV.setResolutionScreen(scanner.next());

        System.out.print("Введите тип матрицы: ");
        userTV.setTypeMatrix(scanner.next());

        System.out.println("\n\u001B[31m" + "Вы выбрали:" + "\u001B[0m");
        System.out.println(userTV);
    }

}