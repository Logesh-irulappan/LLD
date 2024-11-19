package VendingMachine.States;

import VendingMachine.Cash;
import VendingMachine.Coin;
import VendingMachine.Product;
import VendingMachine.VendingMachine;

public class ReadyState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Already a Product is Selected, You can select another product after this product delivery.");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Coin inserted Value: "+ coin.getValue());
        checkPaymentStatus();
    }

    @Override
    public void insertCash(Cash cash) {
        vendingMachine.addCash(cash);
        System.out.println("Cash Inserted Value: "+ cash.getValue());
        checkPaymentStatus();
    }

    @Override
    public void deliverProduct() {
        System.out.println("Make your Payment first");
    }

    @Override
    public void returnBalance() {
        System.out.println("Insufficient Balance, add sufficient money first.");
    }

    private void checkPaymentStatus() {
        if (vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice())
            vendingMachine.setState(vendingMachine.getDeliverState());
    }
}
