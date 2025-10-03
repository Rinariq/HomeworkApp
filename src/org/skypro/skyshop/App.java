package org.skypro.skyshop;

import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.SearchEngine;

import java.lang.reflect.Array;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(new SimpleProduct("Хлеб", 50));
        searchEngine.add(new DiscountedProduct("Молоко", 70, 10));
        searchEngine.add(new FixPriceProduct("Шоколад"));
        searchEngine.add(new SimpleProduct("Мясо", 500));
        searchEngine.add(new DiscountedProduct("Колбаса", 110, 10));
        searchEngine.add(new FixPriceProduct("Булочка"));
        searchEngine.add(new Article("ЗОЖ", "ЗОЖ - здоровый образ жизни"));
        searchEngine.add(new Article("НГУЭУ", "Новосибирский Государственный Университет Экономики и Управления"));
        searchEngine.add(new Article("БАД", "Биологически-активная добавка"));
        searchEngine.add(new Article("РТ", "Республика Татарстан"));

        System.out.println("Поиск по ключевому слолву: БАД");
        Searchable[] results1 = searchEngine.search("БАД");
        searchEngine.printSearchResults(results1);

        System.out.println("Поиск по ключевому слолву: Шоколад");
        Searchable [] results2 = searchEngine.search("Шоколад");
        searchEngine.printSearchResults(results2);

        System.out.println("Поиск по ключевому слолву: Мясо");
        Searchable [] results3 = searchEngine.search("Мясо");
        searchEngine.printSearchResults(results3);

    }
}