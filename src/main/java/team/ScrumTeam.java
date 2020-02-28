package team;

import artifacts.AbstractBacklog;
import formalopportunities.*;
import scrum.DailyScedules;
import scrum.Project;
import team.Developer;
import team.ProductOwner;
import team.ScrumMaster;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.logging.Logger;

public class ScrumTeam extends DailyScedules {
    private static Logger logger;

    public ScrumTeam() {
        logger = Logger.getLogger(this.getClass().getName());
    }

    public Sprint sprint;
    public ProductOwner po;
    public ScrumMaster sm;
    public List<Developer> developmentTeam;
    public Stack<AbstractFormalOpportunity> schedule = new Stack<AbstractFormalOpportunity>();
    public Project project;

    public void addSprintSchedule () {
        schedule.push(new SprintPlanning());
        schedule.push(new DailyScrum());
        schedule.push(new DailyScrum());
        schedule.push(new DailyScrum());
        schedule.push(new DailyScrum());
        schedule.push(new DailyScrum());
        schedule.push(new DailyScrum());
        schedule.push(new SprintReview());
        schedule.push(new Retrospective());
        schedule.push(new SprintPlanning());

    }

    public void nextMeeting () {
        AbstractFormalOpportunity meeting = schedule.pop();
        meeting.takePlace(this);
    }
    public void present() {
        po.present();
        sm.present();
        for (Developer d : developmentTeam) {
            d.present();
        }
    }

    public void determineSprint (AbstractBacklog backlog) {
        developmentTeam.forEach(developer -> developer.selectItem(backlog));
    }

    @Override
    public void sceduleDay(LocalDate day) {
        sprint.sceduleDay(day);
    }

    @Override
    protected void measurePerformance() {
        logger.info("Scrumteam measures performance");

    }

    public void seeValuesInSprint ()  {

    }

    public void discuss ()  {
        Random rand = new Random();
        switch(rand.nextInt() % 3) {
            case 0: {
                po.critizize(sprint);
                break;
            }
            case 1: {
                sm.critizize(po);
                developmentTeam.forEach(developer -> sm.critizize(developer));
                sm.critizize(sm);
                break;
            }
            case 2: {
                developmentTeam.forEach(developer -> developer.critizize(po));
                break;
            }

            default: {
                logger.info("nothing was discussed");
                break;
            }
        }
    }
}
