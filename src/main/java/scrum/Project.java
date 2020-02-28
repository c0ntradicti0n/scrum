package scrum;

import artifacts.ProductBacklog;
import formalopportunities.Sprint;
import states.Done;
import states.Increment;
import team.ScrumTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Project {
    public List<ScrumTeam> scrumTeams = new ArrayList<>();
    public ProductBacklog productBacklog;
    public Stack<Done> DoDs;
    public Stack<Sprint> sprints;
    public Stack<Sprint> doneSprints;
    public Stack<Increment> increments;
}
