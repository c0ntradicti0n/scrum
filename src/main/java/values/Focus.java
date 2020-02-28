package values;

import formalopportunities.AbstractFormalOpportunity;
import formalopportunities.Sprint;

public class Focus extends Value {
    @Override
    public void checkIncorporation(AbstractFormalOpportunity meeting, Sprint sprint) {
        if (meeting.getTimebox() != 0.) {
            incorporationValue += 1;
        }
        if (null != sprint.sprintGoal) {
            incorporationValue += 1;
        }
    }
}
