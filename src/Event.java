import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Event {
    
    private String title;
    private LocalDate date;
    private final int totalSeats;
    private int bookedSeats = 0; //initially evry event will always have 0 booked seats

    public Event(String title, LocalDate date, int totalSeats){
        this.date = date;
        this.title = title;
        this.date = date;
        this.totalSeats = totalSeats;        
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public void setDate(LocalDate date){
        this.date = date;
        }
    public int getTotalSeats(){
        return this.totalSeats;
    }

    public int getBookedSeats(){
        return this.bookedSeats;
    }

    public int getAvailableSeats(){
        return this.totalSeats - this.bookedSeats;
    }

    public void book(int seatsToBook){
        this.bookedSeats += seatsToBook;
    }

    public void unbook(int seatsToUnbook){
        this.bookedSeats -= seatsToUnbook;
    }

    public void printSeats(){
        System.out.println("I posti prenotati sono: " + this.getBookedSeats());
        System.out.println("i posti disponibili sono: " + this.getAvailableSeats());
    }

    //return the formatted date and the title
    @Override
    public String toString(){
        return this.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) + " - " + this.title;
    }
}
