package org.skypro.skyshop.article;

public final class Article implements Searchable {
    private final String titleOfArticle;
    private final String textOfArticle;

    public Article (String titleOfArticle, String textOfArticle){
       this.titleOfArticle = titleOfArticle;
       this.textOfArticle = textOfArticle;
    }

    public String getTitleOfArticle() {
        return titleOfArticle;
    }

    public String getTextOfArticle() {
        return textOfArticle;
    }

    @Override
    public String toString() {
        return titleOfArticle + "\n"+ textOfArticle;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }
    @Override
    public String getName() {
        return this.titleOfArticle;
    }
}
