package artifacts;

import scrum.Person;
import states.Work;

import java.util.List;

public class AbstractBacklog {
    public List<Work> items;

    public Work giveItem(Person person) {
        return person.select(this);
    }
}
