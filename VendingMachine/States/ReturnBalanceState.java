package VendingMachine.States;

import VendingMachine.VendingMachine;
import VendingMachine.Cash;
import VendingMachine.Coin;
import VendingMachine.Product;

public class ReturnBalanceState implements VendingMachineState {

    private VendingMachine vendingMachine;

    public ReturnBalanceState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Please Collect the Change First.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please Collect the Change First");
    }

    @Override
    public void insertCash(Cash cash) {
        System.out.println("Please Collect the Change First.");
    }

    @Override
    public void deliverProduct() {
        System.out.println("Product already delivered, Please collect the change");
    }

    @Override
    public void returnBalance() {
        double change = vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().getPrice();
        if (change > 0)
            System.out.println("Balance: Rs." + change);
        else
            System.out.println("No change to return");
        vendingMachine.resetPayment();
        vendingMachine.resetSelectedProduct();
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}
