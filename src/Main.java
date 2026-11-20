
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RentalManager manager = new RentalManager();

        // Add sample cars
        manager.addVehicle(new Car(101, "Maruti", "Swift", 1200));
        manager.addVehicle(new Car(102, "Hyundai", "i20", 1500));
        manager.addVehicle(new Car(103, "Honda", "City", 2000));

        int choice;

        do {
            System.out.println("\n===== CAR RENTAL SYSTEM =====");
            System.out.println("1. View Available Cars");
            System.out.println("2. Add New Car");
            System.out.println("3. Register Customer");
            System.out.println("4. Book a Car");
            System.out.println("5. Return a Car");
            System.out.println("6. Search Car By ID");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    manager.displayVehicles();
                    break;

                case 2:
                    System.out.print("Enter Car ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Brand: ");
                    String brand = sc.nextLine();

                    System.out.print("Enter Model: ");
                    String model = sc.nextLine();

                    System.out.print("Enter Daily Rent: ");
                    double price = Double.parseDouble(sc.nextLine());

                    if (price <= 0) {
                        System.out.println("Invalid rental price!");
                    } else {
                        manager.addVehicle(
                            new Car(id, brand, model, price)
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    int cid = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    manager.addCustomer(
                        new Customer(cid, name, phone)
                    );
                    break;

                case 4:
                    System.out.print("Enter Booking ID: ");
                    int bid = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Customer ID: ");
                    int customerId = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Car ID: ");
                    int carId = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Rental Days: ");
                    int days = Integer.parseInt(sc.nextLine());

                    Customer customer = null;
                    Vehicle vehicle = null;

                    for (Customer c : manager.customers) {
                        if (c.id == customerId) {
                            customer = c;
                            break;
                        }
                    }

                    for (Vehicle v : manager.vehicles) {
                        if (v.getId() == carId) {
                            vehicle = v;
                            break;
                        }
                    }

                    if (customer == null || vehicle == null) {
                        System.out.println(
                            "Invalid customer ID or car ID!"
                        );
                    } else {
                        try {
                            Booking booking = new Booking(
                                bid, customer, vehicle, days
                            );

                            manager.bookVehicle(booking);

                        } catch (VehicleNotAvailableException |
                                 InvalidBookingException e) {

                            System.out.println(
                                "Error: " + e.getMessage()
                            );
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter Booking ID: ");
                    int returnId = Integer.parseInt(sc.nextLine());

                    manager.returnVehicle(returnId);
                    break;

                case 6:
                    System.out.print("Enter Car ID to search: ");
                    int searchId = Integer.parseInt(sc.nextLine());

                    manager.searchVehicle(searchId);
                    break;

                case 7:
                    System.out.println(
                        "Thank you for using our system!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
