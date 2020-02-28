package team;

import artifacts.ProductBacklog;
import scrum.Person;
import scrum.Project;
import states.Done;
import states.Work;

import java.util.List;

public class ProductOwner extends Person implements AbstractTeamRole {
    // Not comparable to a project manager!
    // Does not select items from the Product Backlog!
    public ProductBacklog myBacklog = new ProductBacklog();

    public void sortBacklog ()  {
        myBacklog.items.sort((work1, work2) -> work2.estimate - work2.estimate);
    }

    public void refine(List<Done> ideas)  {
        myBacklog.items.stream().forEach(item -> item.update(ideas));

    }

    public void setUpProject(List<Work> work, Project project, ScrumTeam scrumTeam) {
        myBacklog.items = work;
        project.productBacklog = myBacklog;
        project.scrumTeams.add(scrumTeam);

    }
}
