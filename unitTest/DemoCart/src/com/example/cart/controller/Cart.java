package com.example.cart.controller;

import com.example.cart.model.Product;
import com.example.cart.model.ProductCart;

import java.util.HashMap;

public class Cart extends HashMap {
    public Cart() {

    }

    public void addProduct(ProductCart productCart) {
        // lay key
        String key = productCart.getProduct().getCode();
        // ney da ton tai ma san pham thi cong so luong san pham + them 1
        if (this.containsKey(key)) {
            int oldQuantity = ((ProductCart) this.get(key)).getQuantity();
            ((ProductCart) this.get(key)).setQuantity(oldQuantity + 1);
        }
        else
        {
            // Neu chua ton tai ma hang dua vao gio hang = put(k, v)
            this.put(key, productCart);
        }
    }

    public boolean removeProduct(String code) {
        if (this.containsKey(code)) {
            this.remove(code);
            return true;
        }
        return false;
    }
}
