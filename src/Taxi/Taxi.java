package Taxi;

import java.util.*;

public class Taxi {
    int id;
    char currentPoint = 'A';
    int totalEarning = 0;
    List<Booking> bookings = new ArrayList<>();

    public Taxi(int id) {
        this.id = id;
    }

    public boolean isAvail(int requestTime) {
        if (bookings.isEmpty()) return true;
        Booking lastBooking = bookings.getLast();
        return lastBooking.dropTime <= requestTime;
    }

    public int calculateEarning(char from, char to) {
        int distance = Math.abs((to - from) * 15);
        return 100 + (distance - 5) * 10;
    }

    public void addBookings(Booking booking) {
        bookings.add(booking);
        this.totalEarning += booking.amount;
        this.currentPoint = booking.to;
    }
}
