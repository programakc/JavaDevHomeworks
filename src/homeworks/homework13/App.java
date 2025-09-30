package homeworks.homework13;

import homeworks.homework13.utils.DataProcessing;

public class App {

    public static void main(String[] args) {

        Integer test1 = DataProcessing.parseCount("123");

        System.out.println(test1);

        Integer test2 = DataProcessing.validateCount("Проверка");

        System.out.println(test2);
    }
}