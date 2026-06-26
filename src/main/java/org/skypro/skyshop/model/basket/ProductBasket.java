package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@SessionScope
public class ProductBasket {
   private final Map<UUID, Integer> productBasket;

    public ProductBasket() {
        this.productBasket = new HashMap<>();
    }

    public void addProduct (UUID id) {
        productBasket.computeIfAbsent(id, k -> 0);
        productBasket.compute(id, (k, v) -> v + 1);
    }

    public  Map<UUID, Integer> getProductBasket() {
        return Collections.unmodifiableMap(productBasket);
    }
}
