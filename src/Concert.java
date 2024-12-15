import java.time.LocalTime;  

public class Concert extends Event{
    
    private LocalTime time;
    private float price;

    public Concert(String title, int year, int month, int dayOfMonth, int totalSeats, LocalTime time, float price){
        super(title, year, month, dayOfMonth, totalSeats);
        this.time = time;
        this.price = price;
    }

    public LocalTime getTime(){
        return this.time;
    }

    public void setTime(LocalTime time){
        this.time = time;
    }

    public float getPrice(){
        return this.price;
    }

    public void setPrice(float price){
        this.price = price;
    }
}
