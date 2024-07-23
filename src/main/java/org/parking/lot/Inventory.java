package org.parking.lot;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private final Map<Product, Integer> products;

    public Inventory() {
        this.products = new ConcurrentHashMap<>();
    }

    public Integer getQuantity(Product product) {
        return products.get(product);
    }

    public void addProduct(Product product, Integer quantity) {
        products.put(product, quantity);
    }

    public void removeProduct(Product product, Integer quantity) {
        products.remove(product);
    }

    public void updateProductQuantity(Product product, Integer newQuantity) {
        products.put(product, newQuantity);
    }

    public boolean isAvailable(Product product) {
        return products.containsKey(product) && products.get(product) > 0;
    }
}
