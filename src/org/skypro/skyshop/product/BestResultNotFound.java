package org.skypro.skyshop.product;

public class BestResultNotFound extends Exception{
    public BestResultNotFound(String searchQuery) {
        super("Не найден подходящий результат для поискового запроса: '" + searchQuery + "'");
    }
}