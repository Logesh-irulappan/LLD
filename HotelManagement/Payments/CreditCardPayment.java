package HotelManagement.Payments;

public class CreditCardPayment implements Payment {
    @Override
    public boolean processPayment(double amount) {
        // Process cash payment
        return true;
    }
}
