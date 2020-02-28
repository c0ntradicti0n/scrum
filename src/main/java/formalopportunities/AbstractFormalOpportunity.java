package formalopportunities;

import team.ScrumTeam;

import java.util.logging.Logger;

public abstract class AbstractFormalOpportunity {
    private static Logger logger;

    public AbstractFormalOpportunity() {
        logger = Logger.getLogger(this.getClass().getName());
    }

    double timeBox;

    public double getTimebox()  {
        switch (this.getClass().getName()) {
            case "formalopportunities.DailyScrum": {timeBox=0.25; break;}
            case "formalopportunities.Retrospective": {timeBox=3.0; break;}
            case "formalopportunities.SprintPlanning": {timeBox=8.0; break;}
            case "formalopportunities.SprintReview": {timeBox=0.25; break;}
        }
        return timeBox;
    }

    public abstract void ease();

    public void takePlace(ScrumTeam sT) {
        logger.warning(this.getClass().getName() + " takes place! lasts " + getTimebox() + "h");
        sT.present();
    }

}
