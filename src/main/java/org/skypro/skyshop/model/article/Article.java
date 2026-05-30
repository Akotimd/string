package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private final String articleTitle;
    private final String text;
    private final UUID id;

    public Article(String articleTitle, String text, UUID id) {
        this.articleTitle = articleTitle;
        this.text = text;
        this.id = id;
    }

    @Override
    public String getName() {
        return articleTitle;
    }

    @JsonIgnore
    @Override
    public String getSearchTerms() {
        return articleTitle + " " + text;
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return Objects.equals(articleTitle, article.articleTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleTitle);
    }

    @Override
    public String toString() {
        return "Название статьи " + articleTitle + '\'' +
                " Текст статьи: " + text + '\'';
    }

    @Override
    public UUID getId() {
        return this.id;
    }
}
