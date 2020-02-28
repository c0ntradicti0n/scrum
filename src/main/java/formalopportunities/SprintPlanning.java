package formalopportunities;

import states.Work;
import team.ScrumTeam;

import java.util.List;
import java.util.stream.Collectors;

public class SprintPlanning extends AbstractFormalOpportunity {
    @Override
    public void ease() {

    }

    public void estimate (ScrumTeam scrumTeam) {
        scrumTeam.developmentTeam.stream().forEach(developer -> developer.estimateBlacklogItems(scrumTeam.po.myBacklog));
    }
    public Sprint selectMaxValue (ScrumTeam scrumTeam) {
        List<Work> newWork = scrumTeam.developmentTeam.stream().map(
                developer -> developer.selectItem(scrumTeam.po.myBacklog)).collect(Collectors.toList());
        return new Sprint (newWork);
    }

    @Override
    public void takePlace(ScrumTeam scrumTeam) {
        estimate(scrumTeam);
        scrumTeam.sprint = selectMaxValue(scrumTeam);

    }
}
