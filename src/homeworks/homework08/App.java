package homeworks.homework08;

import java.io.*;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        String[] buyers;
        String[] productCost;
        String[] initialData = new String[0];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "\\JavaProject\\JavaDevHomeworks\\src\\homeworks\\homework08" +
                        "\\input.txt"))) {

            buyers = bufferedReader.readLine().split(";");
            productCost = bufferedReader.readLine().split(";");

            int index = 0;
            String str = "";

            while (str != null) {
                str = bufferedReader.readLine();
                initialData = Arrays.copyOf(initialData, initialData.length + 1);
                initialData[index] = str;
                index++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Person[] person = new Person[buyers.length];

        for (int i = 0; i < buyers.length; i++) {
            person[i] = new Person("", (double) 0);
            person[i].setName(buyers[i].split("=")[0].trim());
            person[i].setMoney(Double.parseDouble(buyers[i].split("=")[1].trim()));
        }

        Product[] product = new Product[productCost.length];

        for (int i = 0; i < productCost.length; i++) {
            product[i] = new Product("", (double) 0);
            product[i].setTitle(productCost[i].split("=")[0].trim());
            product[i].setCost(Double.parseDouble(productCost[i].split("=")[1].trim()));
        }

        int index = 0;

        while (true) {

            if (initialData[index].equals("END")) {
                break;
            } else {
                for (Person a : person) {
                    if (initialData[index].split("-")[0].trim().equals(a.getName())) {
                        for (Product b : product) {
                            if (initialData[index].split("-")[1].trim().
                                    equals(b.getTitle())) {

                                a.addProducts(b);
                            }
                        }
                    }
                }
            }
            index++;
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "\\JavaProject\\JavaDevHomeworks\\src\\homeworks\\homework08" +
                        "\\output.txt"))) {

            for (Person p : person) {
                for (int i = 0; i < p.getPurchaseResult().length; i++) {
                    bufferedWriter.write(p.getPurchaseResult()[i] + "\n");
                }
            }

            bufferedWriter.write("\n");

            for (Person p : person) {
                bufferedWriter.write(p.toString().replace("[", "").replace(
                        "]", "") + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
