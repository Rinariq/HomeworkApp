package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int price;
    private int sale;

    public DiscountedProduct(String name, int price, int sale) {
        super(name);
        this.price = price;
        this.sale = sale;
    }

    @Override
    public int getPrice() {
        return price-price*sale/100;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " руб." + " (" + this.sale + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
