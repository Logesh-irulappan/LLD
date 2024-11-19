package VendingMachine;

public class Product {

    private String product;
    private double price;

    public Product(String product, double price) {
        this.product = product;
        this.price = price;
    }

    public String getName() {
        return product;
    }

    public double getPrice() {
        return price;
    }

}
