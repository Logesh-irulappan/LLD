package VendingMachine;

import VendingMachine.States.*;

public class VendingMachine {

    public Inventory inventory;
    private static VendingMachine instance;

    private Product selectedProduct;
    private double totalPayment;

    private VendingMachineState currentState;
    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState deliverState;
    private final VendingMachineState returnBalanceState;

    private VendingMachine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        returnBalanceState = new ReturnBalanceState(this);
        deliverState = new DeliverState(this);
        currentState = idleState;
        selectedProduct = null;
        totalPayment = 0.0;
    }

    public static VendingMachine getInstance() {
        if (instance == null)
            instance = new VendingMachine();
        return instance;
    }

    public void setState(VendingMachineState state) {
        currentState = state;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getReadyState() {
        return readyState;
    }

    public VendingMachineState getDeliverState() {
        return deliverState;
    }

    public VendingMachineState getReturnBalanceState() {
        return returnBalanceState;
    }

    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void resetSelectedProduct() {
        selectedProduct = null;
    }

    public void deliverProduct() {
        currentState.deliverProduct();
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertCash(Cash cash) {
        currentState.insertCash(cash);
    }

    public void returnBalance() {
        currentState.returnBalance();
    }

    public void setSelectedProduct(Product product) {
        selectedProduct = product;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }

    public void addCash(Cash cash) {
        totalPayment += cash.getValue();
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void resetPayment() {
        totalPayment = 0.0;
    }

}
