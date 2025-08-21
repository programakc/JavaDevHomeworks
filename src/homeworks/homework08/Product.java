package homeworks.homework08;

import java.util.Objects;

public class Product {
    private String title;
    private Double cost;

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

    public void setTitle(String title) {
        if (!title.isEmpty()) {
            this.title = title;
        }
    }

    public void setCost(Double cost) {
        if (cost > 0) {
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
