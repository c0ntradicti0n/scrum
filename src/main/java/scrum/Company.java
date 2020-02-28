package scrum;

import states.Work;
import team.ScrumTeam;

import java.time.LocalDate;
import java.util.List;

public class Company extends DailyScedules{
    public static List<Project> projects;
    Person boss;
    ScrumTeam scrumTeam;
    List<Work> work;

    public void run() {
        boss.present();
        scrumTeam.po.setUpProject(work, new Project(), scrumTeam);
        scrumTeam.present();
        scrumTeam.nextMeeting();
        scrumTeam.nextMeeting();
        scrumTeam.nextMeeting();
        scrumTeam.nextMeeting();
        scrumTeam.nextMeeting();
        scrumTeam.nextMeeting();
        scrumTeam.nextMeeting();
    }

    @Override
    public void sceduleDay(LocalDate day) {
        scrumTeam.sceduleDay(day);
    }

    @Override
    protected void measurePerformance() {

    }
}
