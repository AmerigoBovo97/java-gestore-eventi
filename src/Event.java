import java.time.DateTimeException;
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
        if (isPast(date) || totalSeats <= 0){
            throw new IllegalArgumentException("please insert valid values");
        }
        try{
            this.title = title;
            this.date = date;
            this.totalSeats = totalSeats;
        }catch(java.time.DateTimeException e){
            throw new DateTimeException("please inser valid date");
        }
        
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
        if (isPast(this.date)) {
            throw new IllegalArgumentException("You can not book seats for a past event");
        }
        if (this.bookedSeats > seatsToBook || this.totalSeats <= 0){
            throw new IllegalArgumentException("You can not book that amount fo seats");
        }
        this.bookedSeats += seatsToBook;
    }

    public void unbook(int seatsToUnbook)throws IllegalArgumentException{
        if (isPast(this.date)) {
            throw new IllegalArgumentException("You can not unbook seats for a past event.");
        }
        if (this.bookedSeats - seatsToUnbook < 0 || seatsToUnbook <= 0){
            throw new IllegalArgumentException("You can not unbook that amount fo seats");
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
