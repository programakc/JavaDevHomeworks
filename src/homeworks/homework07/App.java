package homeworks.homework07;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class App {
    public static void main(String[] args) {

        int indexNormal = 0;
        int indexDiscount = 0;

        Scanner scanner = new Scanner(System.in);
        Pattern findDiscount = Pattern.compile(", ");

        Product[] product = new Product[0];
        DiscountProduct[] discountProduct = new DiscountProduct[0];

        while (true) {
            String str = scanner.nextLine();
            Matcher matcher = findDiscount.matcher(str);

            if (str.equals("END")) {
                break;
            } else {
                if (!matcher.find()) {
                    product = Arrays.copyOf(product, product.length + 1);
                    product[indexNormal] = new Product("", (double) 0);
                    product[indexNormal].setTitle(str.split("=")[0]);
                    product[indexNormal].setCost(Double.parseDouble(str.
                            split("=")[1]));

                    indexNormal++;
                } else {
                    discountProduct = Arrays.copyOf(discountProduct,
                            discountProduct.length + 1);
                    discountProduct[indexDiscount] = new DiscountProduct("",
                            (double) 0);

                    discountProduct[indexDiscount].setTitle(str.split("=")[0]);
                    discountProduct[indexDiscount].setCost(Double.parseDouble
                            (str.split("=")[1].split(", ")[0]));
                    discountProduct[indexDiscount].setDiscount(Integer.parseInt
                            (str.split("=")[1].split(", ")[1].replace("%", "")));

                    indexDiscount++;
                }
            }
        }

        String resultString = "";

        for (Product p : product) {
            if (p.getAllIsGood()) {
                resultString = resultString + p.getTitle() + ", ";
            }
        }

        if (!resultString.equals("")) {
            System.out.print("Обычные продукты: " + resultString.substring(0,
                    resultString.length() - 2));
        }

        resultString = "";

        for (DiscountProduct dp : discountProduct) {
            if (dp.getAllIsGood()) {
                resultString = resultString + dp.getTitle() + ", ";
            }
        }

        if (!resultString.equals("")) {
            System.out.print("\nАкционные продукты: " + resultString.substring(0,
                    resultString.length() - 2));
        }
    }
}
