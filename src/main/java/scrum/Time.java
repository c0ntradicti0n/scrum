package scrum;

import java.time.LocalDate;
import java.util.List;
import java.util.Stack;

public class Time {
    Stack<LocalDate> lifeTime;

    public void Time ()    {
        String s = "2014-05-01";
        String e = "2014-05-10";
        LocalDate start = LocalDate.parse(s);
        LocalDate end = LocalDate.parse(e);
        while (!start.isAfter(end)) {
            lifeTime.push(start);
            start = start.plusDays(1);
        }
    }

    public void sceduleDay(Company company) {
        for (LocalDate day: lifeTime) {
            company.sceduleDay(day);
        }

    }
}
