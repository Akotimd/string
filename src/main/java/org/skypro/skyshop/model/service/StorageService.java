package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>();
        this.articles = new HashMap<>();
        InitializeTestData();
    }

    public Map<UUID, Article> getArticles() {
        return articles;
    }

    public Map<UUID, Product> getProducts() {
        return products;
    }

    private void InitializeTestData() {
        Product product = new SimpleProduct(UUID.randomUUID(), "Продукт 1", 100);
        Article article = new Article("Статья 1", "Текст статьи", UUID.randomUUID());

        products.put(product.getId(), product);
        articles.put(product.getId(), article);
    }

    public Collection<Searchable> getAllSearchables() {
        Collection<Searchable> result = new ArrayList<>();
        result.addAll(products.values());
        result.addAll(articles.values());
        return result;
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(products.get(id));
    }
}
