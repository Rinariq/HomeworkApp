package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket basket1 = new ProductBasket();
        Product product1 = new Product("Хлеб", 12);
        Product product2 = new Product("Молоко", 14);
        Product product3 = new Product("Гречка", 17);
        Product product4 = new Product("Мясо", 2);
        Product product5 = new Product("Шоколад", 8);
        Product product6 = new Product("Чипсы", 10);

        // добавление товаров в корзину
        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product4);
        basket1.addProduct(product5);

        // добавление лишнего товара в корзину
        basket1.addProduct(product6);

        // печать списка товаров в корзине и общей стоимости
        basket1.print();
        System.out.println("");

        //проверка наличия товаров в корзине
        basket1.checkProductInBasket("Шоколад");
        basket1.checkProductInBasket("Чипсы");

        // отчистка корзины
        basket1.cleanBasket();

        // печать содержимого пустой корзины
        basket1.print();

        // поиск товаров в пустой корзине
        basket1.checkProductInBasket("Шоколад");
        basket1.checkProductInBasket("Чипсы");
    }
}