
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
                b.vehicle.available = true;
                System.out.println("Vehicle returned successfully!");
                System.out.println("Total Rent: Rs." + b.totalRent);
                return;
            }
        }

        System.out.println("Booking not found!");
    }
}
