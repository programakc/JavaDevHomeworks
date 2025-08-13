package homeworks.homework07;

import java.util.Objects;

public class DiscountProduct extends Product {

    private int discount;
    private boolean isOn = true;

    public DiscountProduct(String title, Double cost) {
        super(title, cost);
    }

    public int getDiscount() {
        return discount;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setDiscount(int discount) {
        if (this.isOn) {
            setCost(getCost() - discount * getCost() / 100);
        }
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return discount == that.discount && isOn == that.isOn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, isOn);
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
