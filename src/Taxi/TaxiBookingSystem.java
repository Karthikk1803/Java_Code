package Taxi;

import java.util.*;

public class TaxiBookingSystem {
    static List<Taxi> taxis = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int customerCount = 1;

    public static void main(String[] args) {
        System.out.print("Enter number of Taxis: ");
        int numTaxis = sc.nextInt();
        initialiseTaxis(numTaxis);

        while (true) {
            System.out.println("\n1. Book\n2. Details\n3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bookTaxi();
                    break;
                case 2:
                    displayDetails();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Enter valid choice.");
            }
        }
    }

    public static void initialiseTaxis(int n) {
        for (int i = 0; i < n; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public static void bookTaxi() {
        int customerID = customerCount++;
        System.out.print("Enter Pickup Point: ");
        char pickup = sc.next().toUpperCase().charAt(0);
        System.out.print("Enter Drop Point: ");
        char drop = sc.next().toUpperCase().charAt(0);
        System.out.print("Enter Pickup Time: ");
        int pickupTime = sc.nextInt();

        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;
        for (Taxi taxi : taxis) {
            if (taxi.isAvail(pickupTime)) {
                int distance = Math.abs(taxi.currentPoint - pickup);
                if (distance < minDistance || distance == minDistance && taxi.totalEarning < selectedTaxi.totalEarning) {
                    minDistance = distance;
                    selectedTaxi = taxi;
                }
            }
        }

        if (selectedTaxi == null) {
            System.out.println("No Taxis Found");
            return;
        }

        int dropTime = pickupTime + Math.abs(drop - pickup);
        int amount = selectedTaxi.calculateEarning(pickup, drop);
        int bookingID = selectedTaxi.bookings.size() + 1;
        //selectedTaxi.totalEarning += amount;

        Booking booking = new Booking(bookingID, customerID, pickupTime, pickup, drop, amount, dropTime);
        selectedTaxi.addBookings(booking);
        System.out.println("Taxi-" + selectedTaxi.id + "is Allocated");
    }

    public static void displayDetails() {
        for (Taxi taxi : taxis) {
            if (taxi.bookings != null) {
                System.out.println("Taxi-" + taxi.id + " Total Earnings: " + taxi.totalEarning);
                System.out.printf("%-8s %-10s %-4s %-2s %-10s %-8s %-6s%n",
                        "BookingID", "CustomerID", "From", "To", "PickupTime", "DropTime", "Amount");

                for (Booking bookings : taxi.bookings) {
                    System.out.printf("%-9d  %-10d %-4s %-2s %-10d %-8d %-6d%n",
                            bookings.bookingId, bookings.customerID,
                            bookings.from, bookings.to, bookings.pickupTime,
                            bookings.dropTime, bookings.amount);
                }
            }
        }

    }
}
