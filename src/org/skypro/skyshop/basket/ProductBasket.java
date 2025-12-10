package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    LinkedList<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int totalPriceBasket() {
        int totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void print() {
        boolean empty = false;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                empty = true;
            }
        }
        if (empty) {
            System.out.println("\nИтого: " + totalPriceBasket() + " руб.");
            System.out.println("Специальных товаров: " + countSpecialProducts() + "шт.");
        } else {
            System.out.println("В корзине пусто");
        }
    }

    public boolean checkProductInBasket(String checkProduct) {
        ;
        for (Product product : products) {
            if (product != null && product.getName().equals(checkProduct)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        for (Product product : products) {
            product = null;
        }
        System.out.println("\nКорзина отчищена");
    }

    public int countSpecialProducts() {
        int specialCount = 0;
        for (Product product : products) {
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        return specialCount;
    }

    public List<Product> deletProduct(String name) {
        Iterator<Product> iterator = products.listIterator();
        List<Product> removedProducts = new ArrayList<>();

        while (iterator.hasNext()) {
            Product deletProduct = iterator.next();
            if (deletProduct.getName().equals(name)) {
                removedProducts.add(deletProduct);
                iterator.remove();
            }
        }
        for (Product product : removedProducts) {
            System.out.println(product);
        }
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }

        return removedProducts;
    }
}
