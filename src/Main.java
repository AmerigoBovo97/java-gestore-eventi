import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
        
        String title = Utility.askEventName();
        LocalDate date = Utility.askDate();
        int totalSeats = Utility.askTotalSeats();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Questo evento è un concerto? y = si, n = no.");
        String isConcert = scanner.nextLine();

        Event event;
        if (isConcert.equals("y")) {
            LocalTime hour = Utility.askHours();
            double price = Utility.askPrice();
            event = new Concert(title, date, totalSeats, hour, price);
        }else{
            event = new Event(title, date, totalSeats);
        }

        Utility.askToBook(event);
        event.printSeats();
        Utility.askToUnbook(event);
        event.printSeats();
        System.out.println(event);
        
    }
}
