package VendingMachine.States;

import VendingMachine.Cash;
import VendingMachine.Coin;
import VendingMachine.Product;

public interface VendingMachineState {
    void selectProduct(Product product);
    void insertCoin(Coin coin);
    void insertCash(Cash cash);
    void deliverProduct();
    void returnBalance();
}
