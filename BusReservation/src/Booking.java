import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Booking {
    Scanner sc = new Scanner(System.in);

    public void bookTicket(int userId) {
        System.out.print("Enter Bus ID to book: ");
        int busId = sc.nextInt();
        System.out.print("Enter number of seats: ");
        int seats = sc.nextInt();

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement check = con.prepareStatement(
                    "SELECT available_seats FROM buses WHERE bus_id=?");
            check.setInt(1, busId);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                int available = rs.getInt("available_seats");
                if (seats <= available) {
                    PreparedStatement book = con.prepareStatement(
                            "INSERT INTO bookings(user_id, bus_id, seats_booked, booking_date) VALUES (?, ?, ?, ?)");
                    book.setInt(1, userId);
                    book.setInt(2, busId);
                    book.setInt(3, seats);
                    book.setDate(4, Date.valueOf(LocalDate.now()));
                    book.executeUpdate();

                    PreparedStatement update = con.prepareStatement(
                            "UPDATE buses SET available_seats=? WHERE bus_id=?");
                    update.setInt(1, available - seats);
                    update.setInt(2, busId);
                    update.executeUpdate();

                    System.out.println("Booking successful.");
                } else {
                    System.out.println("Not enough seats.");
                }
            } else {
                System.out.println("Bus not found.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewMyBookings(int userId) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM bookings WHERE user_id=?");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Booking ID: " + rs.getInt("booking_id") +
                        " | Bus ID: " + rs.getInt("bus_id") +
                        " | Seats: " + rs.getInt("seats_booked") +
                        " | Date: " + rs.getDate("booking_date"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

