package org.skypro.skyshop.model.exepctions;

import java.util.UUID;

public class NoSuchProductException extends RuntimeException {
    public NoSuchProductException(UUID id) {
        super("Не найден продукт с идентификатором " + id + " !");
    }
}
