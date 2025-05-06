import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        Bus bus = new Bus();
        Booking booking = new Booking();

        System.out.println("1. Register\n2. Login");
        int option = sc.nextInt();
        sc.nextLine();

        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        int userId = -1;
        if (option == 1) {
            user.register(username, password);
        } else {
            userId = user.login(username, password);
            if (userId != -1) {
                System.out.println("Login Successful!");

                while (true) {
                    System.out.println("\n1. View Buses\n2. Book Ticket\n3. My Bookings\n4. Exit");
                    int choice = sc.nextInt();
                    if (choice == 1) bus.showBuses();
                    else if (choice == 2) booking.bookTicket(userId);
                    else if (choice == 3) booking.viewMyBookings(userId);
                    else break;
                }
            } else {
                System.out.println("Login Failed.");
            }
        }
    }
}
