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
        if (added) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int totalPriceBasket() {
        int totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void print() {
        int empty = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                empty += 1;
            }
        }
        if (empty > 0) {
            for (Product product : products) {
                System.out.println(product.getName() + ": " + product.getPrice() + " руб.");
            }
        } else {
            System.out.println("В корзине пусто");
        }
        if (empty > 0) {
            System.out.println("Итого: " + totalPriceBasket() + " руб.");
        }
    }

    public boolean checkProductInBasket(String checkProduct) {
        boolean check = true;
        for (Product product : products) {
            if (product == null) {
                check = false;
                break;
            } else if (product.getName().equals(checkProduct)){
                check = true;
            } else {
                check = false;
            }
        }
        if (check == true) {
            System.out.println(checkProduct + " есть в корзине");
        } else {
            System.out.println(checkProduct + " нет в корзине");
        }
        return true;
    }

    public void cleanBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        System.out.println("\nКорзина отчищена");
    }

}
