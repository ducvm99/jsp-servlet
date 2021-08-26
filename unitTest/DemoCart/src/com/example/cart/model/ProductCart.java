package com.example.cart.model;

import java.io.Serializable;

public class ProductCart implements Serializable {
    protected Product product;
    protected int quantity;

    public ProductCart() {
    }

    public ProductCart(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
