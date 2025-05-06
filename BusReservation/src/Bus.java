import java.sql.*;

public class Bus {
    public void showBuses() {
        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM buses");
            System.out.println("Available Buses:");
            while (rs.next()) {
                System.out.println("Bus ID: " + rs.getInt("bus_id") +
                        " | From: " + rs.getString("source") +
                        " | To: " + rs.getString("destination") +
                        " | Seats: " + rs.getInt("available_seats"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

