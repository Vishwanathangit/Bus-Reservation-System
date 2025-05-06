import java.sql.*;

public class User {
    public void register(String username, String password) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO users(username, password) VALUES (?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            System.out.println("Registered successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int login(String username, String password) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT user_id FROM users WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("user_id");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
