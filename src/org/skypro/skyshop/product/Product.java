package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Searchable;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return this.name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
    @Override
    public String getName() {
        return this.name;
    }

}
