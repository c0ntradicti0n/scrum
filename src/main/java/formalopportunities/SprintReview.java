package formalopportunities;

import team.ScrumTeam;

public class SprintReview extends AbstractFormalOpportunity {
    @Override
    public void ease() {

    }

    public void estimate (ScrumTeam scrumTeam) {
        scrumTeam.developmentTeam.stream().forEach(developer -> developer.estimateBlacklogItems(scrumTeam.po.myBacklog));
    }
    public void selectMaxValue (ScrumTeam scrumTeam) {
        scrumTeam.developmentTeam.stream().forEach(developer -> developer.selectItem(scrumTeam.po.myBacklog));
    }

    @Override
    public void takePlace(ScrumTeam scrumTeam) {
        scrumTeam.developmentTeam.stream().forEach(developer -> developer.present());
        scrumTeam.seeValuesInSprint();
        scrumTeam.discuss();
    }
}
