package org.skypro.skyshop;

import org.skypro.skyshop.article.Searchable;

public class SearchEngine {
    private Searchable[] searchableItems;
    private int currentSize;

    public SearchEngine(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер массива должен быть положительным числом");
        }
        this.searchableItems = new Searchable[size];
        this.currentSize = 0;
    }

    public void add(Searchable item) {
        if (currentSize >= searchableItems.length) {
            throw new IllegalStateException("Search engine is full. Capacity: " + searchableItems.length);
        }
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        searchableItems[currentSize] = item;
        currentSize++;
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];

        if (query == null || query.trim().isEmpty() || currentSize == 0) {
            return results;
        }

        String lowerQuery = query.toLowerCase();
        int resultCount = 0;

        for (int i = 0; i < currentSize && resultCount < 5; i++) {
            Searchable item = searchableItems[i];
            if (item.getSearchTerm().toLowerCase().contains(lowerQuery)) {
                results[resultCount] = item;
                resultCount++;
            }
        }
        return results;
    }

    public void printSearchResults(Searchable[] results) {
        boolean found = false;
        for (int i = 0; i < results.length; i++) {
            if (results[i] != null) {
                System.out.println(results[i].getStringRepresentation());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Ничего не найдено");
        }
    }
}
