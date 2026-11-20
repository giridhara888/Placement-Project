
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

    

    public double calculateLateFee(int extraDays) {
        return extraDays * 500;
    }
}
