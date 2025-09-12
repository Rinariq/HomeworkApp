package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 100;
    private String name;

    public FixPriceProduct(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public String toString() {
        return this.name + ": Фиксированная цена " + FIXED_PRICE + " руб.";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
