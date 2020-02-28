package team;

import formalopportunities.AbstractFormalOpportunity;
import scrum.Person;

public class ScrumMaster extends Person implements AbstractTeamRole {
    void facilitate(AbstractFormalOpportunity formalOpportunity) {
        formalOpportunity.ease();

    };
}
