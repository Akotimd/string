package org.skypro.skyshop.model.controller;


import org.skypro.skyshop.model.exepctions.NoSuchProductException;
import org.skypro.skyshop.model.exepctions.ShopError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {
    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> NoSuchProductException(NoSuchProductException ex){
        return ResponseEntity.status(404).body(new ShopError("PRODUCT_NOT_FOUND", ex.getMessage()));
    }
}
