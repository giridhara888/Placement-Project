
public class Booking {
    int bookingId;
    Customer customer;
    Vehicle vehicle;
    int days;
    double totalRent;

    public Booking(int bookingId, Customer customer, Vehicle vehicle, int days) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
        this.totalRent = vehicle.price * days;
    }

    public void display() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Customer: " + customer.name);
        System.out.println("Vehicle: " + vehicle.brand + " " + vehicle.model);
        System.out.println("Rental Days: " + days);
        System.out.println("Total Rent: Rs." + totalRent);
        System.out.println("----------------------");
    }
}
