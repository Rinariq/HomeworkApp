package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int price;
    private int sale;


    public DiscountedProduct(String name, int price, int sale) {
        super(name);
        validatePrice(price);
        validateSale(sale);
        this.price = price;
        this.sale = sale;
    }

    @Override
    public int getPrice() {
        return price - price * sale / 100;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " руб." + " (" + this.sale + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public static void validatePrice(double price) throws IllegalArgumentException {
        if (price <= 0) {
            throw new IllegalArgumentException("Цена не может быть меньше или равна 0");
        }
    }

    public static void validateSale(double sale) throws IllegalArgumentException {
        if (sale < 0 || sale > 100) {
            throw new IllegalArgumentException("Скидка не может быть меньше 0 и быть больше 100");
        }
    }
}
