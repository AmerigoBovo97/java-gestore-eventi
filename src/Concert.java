import java.time.LocalDate;
import java.time.LocalTime;  

public class Concert extends Event{
    
    private LocalTime time;
    private double price;

    public Concert(String title, LocalDate date, int totalSeats, LocalTime time, double price){
        super(title, date, totalSeats);
        this.time = time;
        this.price = price;
    }

    public LocalTime getTime(){
        return this.time;
    }

    public void setTime(LocalTime time){
        this.time = time;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(float price){
        this.price = price;
    }
}
