
import java.util.ArrayList;

public class RentalManager {

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    // Add a vehicle
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully!");
    }

    // Display available vehicles
    public void displayVehicles() {
        for (Vehicle v : vehicles) {
            if (v.available) {
                v.display();
            }
        }
    }

    // Register a customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer registered successfully!");
    }

    // Book a vehicle
    public void bookVehicle(Booking booking) {
        if (booking.vehicle.available) {
            bookings.add(booking);
            booking.vehicle.available = false;
            System.out.println("Vehicle booked successfully!");
        } else {
            System.out.println("Vehicle is not available!");
        }
    }

    // Return a vehicle

public void returnVehicle(int bookingId) {
    for (Booking b : bookings) {
        if (b.bookingId == bookingId) {

            if (b.vehicle.available) {
                System.out.println("This car has already been returned!");
                return;
            }

            System.out.print("Enter extra days (0 if on time): ");
            Scanner sc = new Scanner(System.in);
            int extraDays = sc.nextInt();

            if (extraDays < 0) {
                System.out.println("Invalid number of days!");
                return;
            }

            double lateFee = b.calculateLateFee(extraDays);
            double totalAmount = b.totalRent + lateFee;

            b.vehicle.available = true;

            System.out.println("\n===== RETURN DETAILS =====");
            System.out.println("Normal Rent: Rs." + b.totalRent);
            System.out.println("Late Fee: Rs." + lateFee);
            System.out.println("Total Amount: Rs." + totalAmount);
            System.out.println("Vehicle returned successfully!");

            return;
        }
    }

    System.out.println("Booking not found!");
}

}
