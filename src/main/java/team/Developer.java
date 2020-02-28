package team;

import artifacts.AbstractBacklog;
import artifacts.ProductBacklog;
import scrum.Person;
import states.Done;
import states.Work;


public class Developer extends Person {
    public Work selectItem(AbstractBacklog backlog) {
        return backlog.giveItem(this);
    }

    public void makeNewDoD(Done done)  {
        myWork.dones.add(done);
    }
    public void estimateBlacklogItems(ProductBacklog productBacklog) {
        for (Work item : productBacklog.items) {
            item.estimate = guessScope(item);
        }
    }

    private int guessScope(Work item) {
        return item.description.length() + item.compareToSkills(this.skills);
    }
}
