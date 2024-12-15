import java.time.LocalDate;

public class Event {
    

    private String title;
    private LocalDate date;
    private final int totalSeats;
    private int bookedSeats = 0; //initially evry event will always have 0 booked seats

    public Event(String title, int year, int month, int dayOfMonth, int totalSeats){
        this.title = title;
        this.date = LocalDate.of(year, month, dayOfMonth);
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

    public void setDate(int year, int month, int dayOfMonth){
        this.date = LocalDate.of(year, month, dayOfMonth);
    }
    public int getTotalSeats(){
        return this.totalSeats;
    }

    public int getBookedSeats(){
        return this.bookedSeats;
    }

}
