package team;

import artifacts.SprintBacklog;

import java.util.List;

public class DevelopmentTeam implements AbstractTeamRole {
    List<Developer> members;
    SprintBacklog sprintBacklog;

    public void work()  {
        for (Developer developer : members) {
            developer.selectItem(sprintBacklog);

        }
    }

}
