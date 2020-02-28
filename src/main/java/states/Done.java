package states;


import scrum.Skills;

import java.util.List;
import java.util.Optional;

public class Done {
    String description;
    List<Done> subDones;
    boolean done;
    public Integer compareToSkills(List<Skills> skills) {
        Optional<Integer> optInteger = skills.stream().map((sk) -> sk.fits(this)).max((f1, f2) -> (int) (f1 - f2));
        if (optInteger.isPresent())  {
            return optInteger.get();
        }
        else {
            return 0;
        }
    }

    public boolean isDone() {
        return subDones.stream().allMatch(d-> d.isDone() == true);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Done{" +
                "description='" + description + '\'' +
                '}';
    }

    public void ubdate(Done idea) {
        String[] descriptionSplits = description.split(" ");
        for (int i = 0; i < descriptionSplits.length; i++) {
            if (idea.description.contains(descriptionSplits[i])) {
                this.subDones.add(idea);
            }
        }
    }
    public void update(List<Done> ideas) {
        ideas.stream().forEach(idea -> this.ubdate(idea));
    }

}
