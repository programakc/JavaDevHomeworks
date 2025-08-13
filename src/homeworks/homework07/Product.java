package homeworks.homework07;

import java.util.Objects;

public class Product {
    private String title;
    private Double cost;
    private Boolean allIsGood = true;

    public Product(String title, Double cost) {
        this.title = title;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public Double getCost() {
        return cost;
    }

    public Boolean getAllIsGood() {
        return allIsGood;
    }

    public void setAllIsGood(Boolean allIsGood) {
        this.allIsGood = allIsGood;
    }

    public void setTitle(String title) {
        if (title.isEmpty() || title.length() <= 3 || title.matches("\\d+")) {
            System.out.println("Недопустимое имя продукта!");
            setAllIsGood(false);
        } else {
            this.title = title;
        }
    }

    public void setCost(Double cost) {
        if (cost <= 0) {
            System.out.println("Недопустимая стоимость продукта!");
            setAllIsGood(false);
        } else {
            this.cost = cost;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(cost, product.cost) == 0 && Objects.equals(title,
                product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, cost);
    }

    @Override
    public String toString() {
        return title;
    }
}
