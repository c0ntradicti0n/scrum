package values;

import formalopportunities.AbstractFormalOpportunity;
import formalopportunities.Sprint;

abstract class Value {
    int incorporationValue = 0;

    abstract public void checkIncorporation(AbstractFormalOpportunity meeting, Sprint sprint);

    ;
}
