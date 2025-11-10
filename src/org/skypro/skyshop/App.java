package org.skypro.skyshop;

import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.SearchEngine;

import java.lang.reflect.Array;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(10);

        try {
            searchEngine.add(new SimpleProduct(" ", 0));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            searchEngine.add(new DiscountedProduct("", 70, 101));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        searchEngine.add(new SimpleProduct("Maco", 500));
        searchEngine.add(new DiscountedProduct("Koлбaca", 100, 10));

        searchEngine.add(new SimpleProduct("Apple iPhone", 1000));
        searchEngine.add(new SimpleProduct("Samsung Galaxy", 800));
        searchEngine.add(new DiscountedProduct("Apple MacBook", 2000, 15));
        searchEngine.add(new SimpleProduct("Google Pixel", 700));
        searchEngine.add(new SimpleProduct("Apple Watch", 400));

        System.out.println("Поиск существующего объекта:");
        try {
            Searchable bestMatch = searchEngine.findBestMatch("Apple");
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
            System.out.println("Тип контента: " + bestMatch.getContentType());
            if (bestMatch instanceof Product) {
                Product product = (Product) bestMatch;
                System.out.println("Цена: " + product.getPrice() + " руб.");
                System.out.println("Специальный: " + product.isSpecial());
            }
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("Поиск объекта 'Samsung':");
        try {
            Searchable bestMatch = searchEngine.findBestMatch("Samsung");
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("Поиск несуществующего объекта:");
        try {
            Searchable bestMatch = searchEngine.findBestMatch("Xiaomi");
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Исключение обработано: " + e.getMessage());
        }

        System.out.println("Поиск с пустым запросом:");
        try {
            Searchable bestMatch = searchEngine.findBestMatch("");
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Исключение обработано: " + e.getMessage());
        }

        System.out.println("Поиск с null запросом:");
        try {
            Searchable bestMatch = searchEngine.findBestMatch(null);
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Исключение обработано: " + e.getMessage());
        }

        System.out.println("Поиск по части слова 'Gaca':");
        try {
            Searchable bestMatch = searchEngine.findBestMatch("Gaca");
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
}


