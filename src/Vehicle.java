
public class Vehicle {
    int id;
    String brand;
    String model;
    double price;
    boolean available;

    public Vehicle(int id, String brand, String model, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.available = true;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Daily Rent: Rs." + price);
        System.out.println("Available: " + available);
        System.out.println("----------------------");
    }
}
