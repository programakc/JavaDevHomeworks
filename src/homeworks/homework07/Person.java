package homeworks.homework07;

import java.util.Arrays;
import java.util.Objects;

public class Person {
    private String name;
    private Double money;
    private Product[] products = new Product[0];

    public Person(String name, Double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public Double getMoney() {
        return money;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Имя не может быть пустым");
        }
    }

    public void setMoney(Double money) {
        if (money < 0) {
            System.out.println("Деньги не могут быть отрицательными");
        } else {
            this.money = money;
        }
    }

    public void addProducts(Product product) {
        if (this.money >= product.getCost()) {
            products = Arrays.copyOf(products, products.length + 1);
            products[products.length - 1] = product;
            this.money = this.money - product.getCost();
            System.out.println(this.name + " купил(-а) " + product.getTitle());
        } else {
            System.out.println(this.name + " не может позолить себе " +
                    product.getTitle());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(money,
                person.money) && Objects.deepEquals(products, person.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, Arrays.hashCode(products));
    }

    @Override
    public String toString() {
        if (products.length == 0) {
            return name + " - Ничего не куплено";
        } else {
            return name + " - " + Arrays.toString(products);
        }
    }
}
