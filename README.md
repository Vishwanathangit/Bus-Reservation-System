# Bus-Reservation-System

A console-based Java application that allows users to register, log in, view available buses, book tickets, and track bookings. The application connects to a MySQL database using JDBC for data storage and management.

## 📌 Features

- User registration and login authentication
- View available buses with source and destination
- Book tickets with seat availability update
- View user booking history
- MySQL database integration using JDBC

## 🛠️ Tech Stack

- **Java** (Core Java, Console I/O)
- **MySQL** (Database)
- **JDBC** (Java Database Connectivity)

---

## 🗂️ Project Structure

<pre>
  ```
  BusReservationSystem/
│
├── DBConnection.java # Handles database connectivity
├── User.java # User model class
├── UserService.java # Handles user registration and login
├── Bus.java # Bus model class
├── BusService.java # Shows available buses
├── Booking.java # Booking model class
├── BookingService.java # Handles ticket booking and viewing
├── Main.java # Entry point with main menu
├── README.md # Project documentation (this file)
  ```
</pre>

## 🚀 How to Run

1. Make sure MySQL server is running.
2. Add the MySQL JDBC driver (`mysql-connector-j-x.x.x.jar`) to your project classpath.
3. Compile and run `Main.java`.
4. Use the menu to register, login, view buses, and book tickets.
