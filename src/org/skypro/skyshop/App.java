package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.DiscountedProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket1 = new ProductBasket();
        Product product1 = new SimpleProduct("Хлеб", 80);
        Product product2 = new DiscountedProduct("Молоко", 70, 10);
        Product product3 = new SimpleProduct("Гречка", 50);
        Product product4 = new SimpleProduct("Мясо", 200);
        Product product5 = new FixPriceProduct("Шоколад");
        Product product6 = new SimpleProduct("Чипсы", 100);

        // добавление товаров в корзину
        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product4);
        basket1.addProduct(product5);
        // печать списка товаров в корзине и общей стоимости
        basket1.print();



    }
}