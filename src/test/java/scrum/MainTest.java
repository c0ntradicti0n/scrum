package scrum;

import com.google.gson.Gson;
import team.Developer;
import team.ProductOwner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void main() {
        Main m = new Main();
        try {
            m.main();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void testScaling ()  {
        /*  When there are n teams in a project, there are:
            1 Product Backlog
            n Sprint Backlogs each Sprint
            one or more Definitions of Done, as long as they are compatible with each other
            1 integrated Increment each Sprint
            1 Product Owner
            n Scrum Master roles which can be occupied by 1 or more Scrum Masters
        */
        Gson gson = new Gson();

        String filePath = "murcs_gmbh.json";
        String json = null;
        try {
            json = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        } catch (IOException e) {
            e.printStackTrace();
        }
        Company murcs =  gson.fromJson(json, Company.class);

        murcs.projects.stream().forEach(project -> assertNotNull((project).productBacklog));
        murcs.projects.stream().forEach(project -> project.scrumTeams.stream().forEach(scrumTeam -> assertNotNull(scrumTeam)));

        // one product backlog, but multiple definitions of done!
        murcs.projects.stream().forEach(project -> assertTrue(
                project.DoDs.size() >=1));
        murcs.projects.stream().forEach(project -> assertTrue(
                project.increments.size() >= project.sprints.size() ));

        this.obj = null;
        murcs.projects.stream().forEach(project ->
                project.scrumTeams.stream().allMatch(scrumTeam -> allTheSame(scrumTeam.po)));
        murcs.projects.stream().forEach(
                project -> project.scrumTeams.stream().forEach(
                    scrumTeam -> assertNotNull(scrumTeam.sm)));

        // teamsize 3 to 9
        murcs.projects.stream().forEach(
                project -> project.scrumTeams.stream().forEach(
                scrumTeam -> assertTrue(scrumTeam.developmentTeam.size()>=3 && scrumTeam.developmentTeam.size()<=9)));

        // no developer can be part of multiple teams
        List<Developer> allDevelopers = murcs.projects.stream().flatMap(
                project -> project.scrumTeams.stream().flatMap(
                        scrumTeam -> scrumTeam.developmentTeam.stream())).collect(Collectors.toList());
        assertTrue(allDevelopers.size() == allDevelopers.stream().distinct().count());

    }

    public static Object obj;
    private boolean allTheSame(Object obj) {
        if (this.obj == null) {
            this.obj = obj;
            return true;
        }
        else {
            return obj.equals(this.obj);
        }

    }
}