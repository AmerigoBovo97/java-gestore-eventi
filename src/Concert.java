import java.time.LocalTime;  

public class Concert extends Event{
    
    private LocalTime time;
    private double price;

    public Concert(String title, int year, int month, int dayOfMonth, int totalSeats, String time, double price){
        super(title, year, month, dayOfMonth, totalSeats);
        this.time = LocalTime.parse(time);
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
