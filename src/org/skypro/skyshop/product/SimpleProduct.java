package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
        validatePrice(price);
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + ": " + price + " руб.";
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    public static void validatePrice(double price) throws IllegalArgumentException {
        if (price <= 0) {
            throw new IllegalArgumentException("Цена не может быть меньше или равна 0");
        }
    }
}

