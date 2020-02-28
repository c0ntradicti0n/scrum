package formalopportunities;

import artifacts.SprintBacklog;
import artifacts.SprintGoal;
import scrum.DailyScedules;
import states.Work;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

public class Sprint extends DailyScedules {
    public SprintBacklog sprintBacklog;
    public SprintGoal sprintGoal;

    private static Logger logger;

    public Sprint() {
        logger = Logger.getLogger(this.getClass().getName());
    }

    public Sprint(List<Work> work) {
        sprintBacklog.items = work;
    }


    @Override
    public void sceduleDay(LocalDate day) {
         this.measurePerformance();
    }

    @Override
    protected void measurePerformance() {
         logger.info("measure performance of sprint...");
    }
}
