
import java.util.ArrayList;
import java.util.Scanner;

public class RentalManager {

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    // Add vehicle with duplicate ID validation
    public void addVehicle(Vehicle vehicle) {

        for (Vehicle v : vehicles) {
            if (v.getId() == vehicle.getId()) {
                System.out.println("Vehicle ID already exists!");
                return;
            }
        }

        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully!");
    }

    // Display available vehicles
    public void displayVehicles() {

        boolean found = false;

        for (Vehicle v : vehicles) {
            if (v.isAvailable()) {
                v.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available cars!");
        }
    }

    // Register customer
    public void addCustomer(Customer customer) {

        for (Customer c : customers) {
            if (c.id == customer.id) {
                System.out.println("Customer ID already exists!");
                return;
            }
        }

        customers.add(customer);
        System.out.println("Customer registered successfully!");
    }

    // Book vehicle
    public void bookVehicle(Booking booking)
            throws VehicleNotAvailableException, InvalidBookingException {

        for (Booking b : bookings) {
            if (b.bookingId == booking.bookingId) {
                throw new InvalidBookingException(
                    "Booking ID already exists!");
            }
        }

        if (booking.days <= 0) {
            throw new InvalidBookingException(
                "Rental days must be greater than zero!");
        }

        if (!customers.contains(booking.customer)) {
            throw new InvalidBookingException(
                "Customer is not registered!");
        }

        if (!vehicles.contains(booking.vehicle)) {
            throw new InvalidBookingException(
                "Vehicle does not exist!");
        }

        if (!booking.vehicle.isAvailable()) {
            throw new VehicleNotAvailableException(
                "Vehicle is not available for booking!");
        }

        bookings.add(booking);
        booking.vehicle.setAvailable(false);

        System.out.println("Vehicle booked successfully!");
    }

    // Return vehicle and calculate late fee
    public void returnVehicle(int bookingId) {

        for (Booking b : bookings) {

            if (b.bookingId == bookingId) {

                if (b.vehicle.isAvailable()) {
                    System.out.println("This car has already been returned!");
                    return;
                }

                Scanner sc = new Scanner(System.in);

                System.out.print("Enter extra days (0 if on time): ");
                int extraDays = sc.nextInt();

                if (extraDays < 0) {
                    System.out.println("Invalid number of days!");
                    return;
                }

                double lateFee = b.calculateLateFee(extraDays);
                double totalAmount = b.totalRent + lateFee;

                b.vehicle.setAvailable(true);

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

    // Search vehicle using Linear Search
    public void searchVehicle(int id) {

        boolean found = false;

        for (Vehicle v : vehicles) {

            if (v.getId() == id) {
                System.out.println("\nCar Found!");
                v.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Car not found!");
        }
    }
}
