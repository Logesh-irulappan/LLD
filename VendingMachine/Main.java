package VendingMachine;

public class Main {
    public static void main(String[] args) {

        VendingMachine vendingMachine = VendingMachine.getInstance();

        Product water = new Product("Water", 20);
        Product coke = new Product("Coca cola", 20);
        Product pepsi = new Product("Pepsi", 20);

        vendingMachine.inventory.addProduct(coke, 10);
        vendingMachine.inventory.addProduct(pepsi, 10);
        vendingMachine.inventory.addProduct(water, 10);

        vendingMachine.selectProduct(water);
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.deliverProduct();
        vendingMachine.returnBalance();

        System.out.println();
        vendingMachine.selectProduct(coke);
        vendingMachine.insertCash(Cash.FIFTY);
        vendingMachine.deliverProduct();
        vendingMachine.returnBalance();

    }
}
