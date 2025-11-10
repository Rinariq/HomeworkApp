package org.skypro.skyshop;

import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.product.BestResultNotFound;

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

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.trim().isEmpty()) {
            throw new BestResultNotFound(search);
        }

        if (currentSize == 0) {
            throw new BestResultNotFound(search);
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        for (int i = 0; i < currentSize; i++) {
            Searchable item = searchableItems[i];
            String searchTerm = item.getSearchTerm();
            if (searchTerm != null) {
                int count = countOccurrences(searchTerm, search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }

        private int countOccurrences(String text, String substring) {
        if (text == null || substring == null || substring.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        String lowerText = text.toLowerCase();
        String lowerSubstring = substring.toLowerCase();

        while ((index = lowerText.indexOf(lowerSubstring, index)) != -1) {
            count++;
            index += lowerSubstring.length();
        }

        return count;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public int getCapacity() {
        return searchableItems.length;
    }
}
