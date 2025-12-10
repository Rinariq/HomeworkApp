package org.skypro.skyshop;

import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.SearchEngine;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket basket1 = new ProductBasket();
        Product product1 = new SimpleProduct("Мясо", 180);
        Product product2 = new DiscountedProduct("Молоко", 70, 10);
        Product product3 = new SimpleProduct("Гречка", 50);
        Product product4 = new SimpleProduct("Мясо", 200);
        Product product5 = new FixPriceProduct("Шоколад");
        Product product6 = new SimpleProduct("Чипсы", 100);

        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product4);
        basket1.addProduct(product5);
        basket1.addProduct(product6);

        System.out.println("Удаленные товары:");
        basket1.deletProduct("Мясо");


        System.out.println("\nКорзина:");
        basket1.print();

        System.out.println("\nУдаленные товары:");
        basket1.deletProduct("Рыба");

        System.out.println("\nКорзина:");
        basket1.print();
    }
}


