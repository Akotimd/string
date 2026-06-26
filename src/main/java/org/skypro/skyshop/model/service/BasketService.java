package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.exepctions.NoSuchProductException;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public String addProduct(UUID id) {
        Product product = storageService.getProductById(id)
                        .orElseThrow(() -> new NoSuchProductException(id));
        productBasket.addProduct(id);
        return "Product dobavlen";
    }

    public UserBasket getBasket() {
        return new UserBasket(
                productBasket.getProductBasket().entrySet().stream()
                        .map(k -> {
                            Product product = storageService.getProductById(k.getKey())
                                    .orElseThrow();
                                    return new BasketItem(product, k.getValue());
                        })
                        .collect(Collectors.toList()));
    }

}
