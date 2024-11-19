package VendingMachine;

public enum Cash {

    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);

    private final int value;

    Cash(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
