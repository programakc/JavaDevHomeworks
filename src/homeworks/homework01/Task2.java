package homeworks.homework01;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int boy1, boy2;

        System.out.println("\nкамень-0, ножницы-1, бумага-2\n");

        while (true) {
            boy1 = rnd.nextInt(3);
            boy2 = rnd.nextInt(3);

            System.out.println("Вася выбрал " + boy1);
            System.out.println("Петя выбрал " + boy2);

            if (boy1 == boy2) {
                System.out.println("Ничья. Ребята играют дальше.\n");
            } else if ((boy1 == 0 && boy2 == 1) || (boy1 == 1 && boy2 == 2) ||
                    (boy1 == 2 && boy2 == 0)) {
                System.out.println("Выиграл Вася.");
                break;
            } else {
                System.out.println("Выиграл Петя.");
                break;
            }
        }
    }
}