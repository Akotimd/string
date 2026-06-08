package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> itemList;
    private final int total;

    public UserBasket(List<BasketItem> itemList) {
        this.itemList = itemList;
        this.total = itemList.stream()
                .mapToInt(k ->
                        (int) (k.getProduct().getPrice() * k.getAmount()))
                        .sum();
    }

    public List<BasketItem> getItemList() {
        return itemList;
    }

    public int getTotal() {
        return total;
    }
}
