package Taxi;

public class Booking {
    int bookingId, customerID, pickupTime, dropTime, amount;
    char from, to;

    public Booking(int bookingId, int customerID, int pickupTime, char from, char to, int amount, int dropTime) {
        this.amount = amount;
        this.bookingId = bookingId;
        this.customerID = customerID;
        this.dropTime = dropTime;
        this.from = from;
        this.pickupTime = pickupTime;
        this.to = to;
    }
}
