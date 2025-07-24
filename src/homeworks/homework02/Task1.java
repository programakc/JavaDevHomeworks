package homeworks.homework02;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double degree;

        System.out.print("Введите степень в градусах Фаренгейта: ");
        degree = scanner.nextDouble();
        System.out.println(degree + " градусов по Фаренгейту равны " +
                ((degree - 32) * 5 / 9) + " по Цельсию");
    }

}
