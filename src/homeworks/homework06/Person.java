package homeworks.homework06;

import java.util.Arrays;
import java.util.Objects;

public class Person {
    private String name;
    private Long money;
    private Product[] products = new Product[10];

    public Person(String name, Long money, Product[] products) {
        this.name = name;
        this.money = money;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public Long getMoney() {
        return money;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public void setProducts(Product[] products) {
        this.products = products;
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
        return "Person{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", products=" + Arrays.toString(products) +
                '}';
    }
}
