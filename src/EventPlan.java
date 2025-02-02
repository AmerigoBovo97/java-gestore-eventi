import java.util.ArrayList;
import java.util.List;

public class EventPlan {
    
    private String title;
    private List<Event> events;

    public EventPlan(String title){
        this.title = title;
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public int getHowManyEvents(){
        return this.events.size();
    }

    public void emptyEventList(){
        this.events.clear();
    }

    
    
}
