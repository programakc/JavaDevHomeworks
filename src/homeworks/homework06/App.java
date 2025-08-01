package homeworks.homework06;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] buyers = scanner.nextLine().split(";");
        Person[] person = new Person[buyers.length];

        for (int i = 0; i < buyers.length; i++) {
            person[i] = new Person("", (double)0);
            person[i].setName(buyers[i].split("=")[0].trim());
            person[i].setMoney(Double.parseDouble(buyers[i].split("=")[1].trim()));
        }
        String[] productCost = scanner.nextLine().split(";");
        Product[] product = new Product[productCost.length];

        for (int i = 0; i < productCost.length; i++) {
            product[i] = new Product("", (double)0);
            product[i].setTitle(productCost[i].split("=")[0].trim());
            product[i].setCost(Double.parseDouble(productCost[i].split("=")[1].trim()));
        }

        while (true) {
            String str = scanner.nextLine();

            if (str.equals("END")) {
                break;
            } else {
                for (Person a: person) {
                    if (str.split("-")[0].trim().equals(a.getName())) {
                        for (Product b: product) {
                            if (str.split("-")[1].trim().equals(b.getTitle())) {
                                a.addProducts(b);
                            }
                        }
                    }
                }
            }
        }

        for (Person p: person) {
            System.out.println(p.toString().replace("[", "").replace("]", ""));
        }

    }
}
