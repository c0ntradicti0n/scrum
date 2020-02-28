package scrum;

import formalopportunities.Sprint;

import java.time.LocalDate;

public abstract class DailyScedules {
    public abstract void sceduleDay(LocalDate day);

    protected abstract void measurePerformance();

}
