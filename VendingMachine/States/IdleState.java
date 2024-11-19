package VendingMachine.States;

import VendingMachine.Cash;
import VendingMachine.Coin;
import VendingMachine.Product;
import VendingMachine.VendingMachine;

public class IdleState implements VendingMachineState {

    public final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if (vendingMachine.inventory.isAvailable(product)) {
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setState(vendingMachine.getReadyState());
            System.out.println("Product Selected: "+ product.getName());
        }
        else {
            System.out.println(product.getName()+" is Not Available");
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select a product first");
    }

    @Override
    public void insertCash(Cash cash) {
        System.out.println("Please select a product first");
    }

    @Override
    public void deliverProduct() {
        System.out.println("Select a product and make payment.");
    }

    @Override
    public void returnBalance() {
        System.out.println("No Change to return");
    }
}
