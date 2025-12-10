package org.skypro.skyshop;

import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.product.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchableItems = new ArrayList<>();

    public SearchEngine() {
        this.searchableItems = new ArrayList<>();
    }

    public void add(Searchable item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        searchableItems.add(item);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();

        if (query == null || query.trim().isEmpty() || searchableItems.isEmpty()) {
            return results;
        }

        String lowerQuery = query.toLowerCase().trim();

        for (Searchable item : searchableItems) {
            if (item.getSearchTerm().toLowerCase().contains(lowerQuery)) {
                results.add(item);
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
        if (searchableItems.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : searchableItems) {
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
        return searchableItems.size();
    }

    public int getCapacity() {
        return Integer.MAX_VALUE;
    }
}
