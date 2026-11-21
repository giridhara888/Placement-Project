# Car Rental Management System

## 1. Project Overview

The **Car Rental Management System** is a console-based Java application developed to manage basic car rental operations.

It allows users to view available cars, add new cars, register customers, book cars, return rented cars, and calculate rental charges.

The project demonstrates the core concepts of Object-Oriented Programming (OOP), Java Collections, exception handling, and searching algorithms.

## 2. Technologies Used

- **Programming Language:** Java
- **IDE:** Visual Studio Code
- **Data Structure:** ArrayList
- **Algorithm:** Linear Search
- **Interface:** Console-based application

## 3. Features

1. **View Available Cars** – Displays all cars currently available for rent.
2. **Add New Car** – Allows users to add cars with details such as ID, brand, model, and daily rental price.
3. **Register Customer** – Stores customer details, including customer ID, name, and phone number.
4. **Book a Car** – Allows registered customers to book available cars.
5. **Return a Car** – Allows customers to return rented cars and calculates the final rental amount.
6. **Late Fee Calculation** – Charges ₹500 for each additional day beyond the rental period.
7. **Search Car** – Searches for a car using its ID.
8. **Validation** – Prevents duplicate IDs, invalid bookings, and booking of unavailable cars.

## 4. Object-Oriented Programming Concepts

The project implements all four pillars of OOP:

### Encapsulation
- Vehicle data members are declared private.
- Getters and setters provide controlled access to vehicle information.

### Inheritance
- The `Car` class inherits properties and methods from the `Vehicle` class using `extends`.

### Polymorphism
- The `Car` class overrides the `display()` method of the `Vehicle` class using `@Override`.

### Abstraction
- The `Vehicle` class is declared as an abstract class.
- Objects of the abstract `Vehicle` class cannot be created directly.

## 5. Data Structures and Algorithms

### ArrayList
The project uses Java's `ArrayList` to store:

- Vehicle objects
- Customer objects
- Booking objects

ArrayList is dynamically resizable, so its size changes as elements are added or removed.

### Linear Search
Linear Search is implemented to find a vehicle using its ID.

The algorithm checks each vehicle one by one until the required vehicle is found.

**Time Complexity:** O(n)

## 6. Exception Handling

The project implements two custom exceptions:

- `VehicleNotAvailableException` – Thrown when someone tries to book a vehicle that is already rented.
- `InvalidBookingException` – Handles invalid booking details, duplicate booking IDs, unregistered customers, and invalid rental days.

These exceptions help handle errors without abruptly terminating the application.

## 7. Project Structure

```text
CarRentalSystem/
│
├── src/
│   ├── Vehicle.java
│   ├── Car.java
│   ├── Customer.java
│   ├── Booking.java
│   ├── RentalManager.java
│   ├── Main.java
│   ├── VehicleNotAvailableException.java
│   └── InvalidBookingException.java
│
└── README.md
```

## 8. How to Run the Project

### Prerequisites
- Java Development Kit (JDK) installed.
- Visual Studio Code or any Java-supported IDE.

### Step 1: Open the project folder

Open the project in Visual Studio Code.

### Step 2: Open the terminal

Navigate to the source folder:

```powershell
cd D:\CarRentalSystem\src
```

### Step 3: Compile the Java files

```powershell
javac *.java
```

### Step 4: Run the application

```powershell
java Main
```

## 9. Sample Menu

```text
===== CAR RENTAL SYSTEM =====
1. View Available Cars
2. Add New Car
3. Register Customer
4. Book a Car
5. Return a Car
6. Search Car By ID
7. Exit

Enter your choice:
```

## 10. Future Enhancements

- Add a database to permanently store vehicle, customer, and booking details.
- Implement a graphical user interface.
- Add booking dates and rental duration tracking.
- Generate rental receipts.
- Add admin and customer login functionality.

## 11. Conclusion

The Car Rental Management System demonstrates how Java and Object-Oriented Programming concepts can be used to develop a simple real-world application.

It provides practical experience with classes, objects, inheritance, encapsulation, polymorphism, abstraction, ArrayList, custom exceptions, and Linear Search.

---

**Project:** Car Rental Management System  
**Language:** Java  
**Application Type:** Console-Based  
