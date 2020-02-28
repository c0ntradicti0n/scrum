package states;

import scrum.Skills;
import states.testing.State;

import java.util.Arrays;
import java.util.List;

public class Work {
    public int estimate;
    public String description;
    public List<Done> dones;
    public State readyFor;
    public boolean functional = true;

    public boolean isDone() {
        boolean descriptionOk = Arrays.stream(description.split(" ")).allMatch(word -> dones.toString().contains(word));
        boolean allDone =  dones.stream().allMatch(d -> isDone());
        return descriptionOk && allDone;
    }

    public Integer compareToSkills(List<Skills> skills) {
        return dones.stream().map((d)-> d.compareToSkills(skills)).reduce(
                0, Integer::sum
        );
    }

    @Override
    public String toString() {
        return "Work{" +
                "estimate=" + estimate +
                ", description='" + description + '\'' +
                ", dones=" + dones +
                ", readyFor=" + readyFor +
                '}';
    }

    public void update(List<Done> ideas) {
        dones.stream().forEach(done -> done.update(ideas));
    }
}
