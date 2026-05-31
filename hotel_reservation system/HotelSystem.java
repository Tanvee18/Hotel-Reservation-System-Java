import java.util.ArrayList;

class HotelSystem {

    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    HotelSystem() {

        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));
    }

    void showRooms() {

        System.out.println("\n===== ROOM DETAILS =====");

        for (Room r : rooms) {

            System.out.println("Room Number : " + r.roomNumber);
            System.out.println("Category    : " + r.category);
            System.out.println("Available   : " + (!r.isBooked));
            System.out.println("--------------------------");
        }
    }

    void bookRoom(String customerName, int roomNumber) {

        for (Room r : rooms) {

            if (r.roomNumber == roomNumber && !r.isBooked) {

                r.isBooked = true;
                bookings.add(new Booking(customerName, roomNumber));

                System.out.println("Room Booked Successfully!");
                return;
            }
        }

        System.out.println("Room not available.");
    }

    void cancelBooking(int roomNumber) {

        for (Room r : rooms) {

            if (r.roomNumber == roomNumber && r.isBooked) {

                r.isBooked = false;

                for (Booking b : bookings) {

                    if (b.roomNumber == roomNumber) {
                        bookings.remove(b);
                        break;
                    }
                }

                System.out.println("Booking Cancelled.");
                return;
            }
        }

        System.out.println("Booking not found.");
    }

    void displayBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        System.out.println("\n===== BOOKING DETAILS =====");

        for (Booking b : bookings) {

            System.out.println("Customer Name : " + b.customerName);
            System.out.println("Room Number   : " + b.roomNumber);
            System.out.println("---------------------------");
        }
    }
}