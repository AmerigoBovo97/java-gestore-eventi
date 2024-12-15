public class Event {
    

    private String title;
    private String date;
    private int totalSeats;
    private int bookedSeats = 0; //initially evry event will always have 0 booked seats

    public void Event(String title, String date, int totalSeats){
        this.title = title;
        this.date = date;
        this.totalSeats = totalSeats;
    }


}
