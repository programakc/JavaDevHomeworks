package homeworks.homework10;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        int[] array = {25, 2, 34, 13, 53, 343};
        System.out.println("\nЗадан массив: " + Arrays.toString(array));

        ByCondition condition = (n) -> n % 2 == 0;

        int[] result = Sequence.filter(array, condition);
        System.out.println("Чётные элементы массива: " + Arrays.toString(result));

        ByCondition condition2 = (n) -> sumElement(n) % 2 == 0;

        int[] result2 = Sequence.filter(array, condition2);
        System.out.println("Элементы массива, сумма цифр которых " +
                "чётная: " + Arrays.toString(result2));
    }

    static int sumElement(int number) {
        if (number > 9) {
            int sum = 0;

            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            return sum;
        } else return 1;
    }
}
