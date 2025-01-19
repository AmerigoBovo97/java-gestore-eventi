import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Event {
    

    private String title;
    private LocalDate date;
    private final int totalSeats;
    private int bookedSeats = 0; //initially evry event will always have 0 booked seats

    public Event(String title, int year, int month, int dayOfMonth, int totalSeats) throws IllegalArgumentException{
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        if (isPast(date)){
            throw new IllegalArgumentException("The specified date is in the past");
        }
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

    public void setDate(int year, int month, int dayOfMonth) throws IllegalArgumentException{
        if (isPast(date)){
            throw new IllegalArgumentException("The specified date is in the past");
        }
        this.date = LocalDate.of(year, month, dayOfMonth);
    }
    public int getTotalSeats(){
        return this.totalSeats;
    }

    public int getBookedSeats(){
        return this.bookedSeats;
    }

    public void book(int seatsToBook)throws IllegalArgumentException{
        int totalBokkedSeats = this.bookedSeats + seatsToBook;
        if (totalBokkedSeats > this.totalSeats || seatsToBook <= 0){
            throw new IllegalArgumentException("You can not book that amount fo seats");
        }
        this.bookedSeats = totalBokkedSeats;
    }

    public void unbook(int seatsToUnbook)throws IllegalArgumentException{
        int totalBokkedSeats = this.bookedSeats - seatsToUnbook;
        if (totalBokkedSeats < 0  || seatsToUnbook <= 0){
            throw new IllegalArgumentException("You can not book that amount fo seats");
        }
        this.bookedSeats -= seatsToUnbook;
    }

    //return the formatted date and the title
    @Override
    public String toString(){
        return this.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) + " - " + this.title;
    }

    public static boolean isPast (LocalDate date){
        LocalDate today = LocalDate.now();
        return today.isAfter(date);
    }
}
