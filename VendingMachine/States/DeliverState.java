package VendingMachine.States;

import VendingMachine.Cash;
import VendingMachine.Coin;
import VendingMachine.Product;
import VendingMachine.VendingMachine;

public class DeliverState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public DeliverState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product Selection is Done, Collect your Product");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment Already Done, Collect your Product");
    }

    @Override
    public void insertCash(Cash cash) {
        System.out.println("Payment Already Done, Collect your Product");
    }

    @Override
    public void deliverProduct() {
        vendingMachine.setState(vendingMachine.getReadyState());

        Product product = vendingMachine.getSelectedProduct();
        vendingMachine.inventory.updateQuantity(product, vendingMachine.inventory.getQuantity(product)-1);
        System.out.println("Product Delivered: "+ product.getName());
        vendingMachine.setState(vendingMachine.getReturnBalanceState());
    }

    @Override
    public void returnBalance() {
        System.out.println("Collect your Product first");
    }
}
