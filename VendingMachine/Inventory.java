package VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final Map<Product, Integer> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void addQuantity(Product product, int quantity) {
        products.put(product, products.getOrDefault(product, 0)+quantity);
    }

    public void updateQuantity(Product product, int quantity) {
        products.put(product, quantity);
    }

    public int getQuantity(Product product) {
        return products.getOrDefault(product, 0);
    }

    public boolean isAvailable(Product product) {
        return products.containsKey(product) && products.get(product) > 0;
    }

    public void menu() {
        for (Map.Entry<Product, Integer> set: products.entrySet())
            System.out.println(set.getKey().getName()+": "+set.getValue());
    }

}
