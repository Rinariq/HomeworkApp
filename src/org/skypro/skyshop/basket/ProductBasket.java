package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;

    public ProductBasket() {
        this.products = new Product[5];
    }

    public void addProduct(Product newProduct) {
        boolean added = true;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = newProduct;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int totalPriceBasket() {
        int totalPrice = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                totalPrice += products[i].getPrice();
            }
        }
        return totalPrice;
    }

    public void print() {
        boolean empty = false;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice() + " руб.");
                empty = true;
            }
        }
        if (empty) {
            System.out.println("Итого: "+totalPriceBasket()+" руб.");
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean checkProductInBasket(String checkProduct) {;
        for (Product product : products) {
            if (product != null && product.getName().equals(checkProduct)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        System.out.println("\nКорзина отчищена");
    }

}
