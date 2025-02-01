import java.util.ArrayList;
import java.util.List;

public class EventPlan {
    
    private String title;
    private List<Event> evnets;

    public EventPlan(String title){
        this.title = title;
        this.evnets = new ArrayList<>();
    }
}
