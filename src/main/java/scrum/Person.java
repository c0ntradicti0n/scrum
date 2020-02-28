package scrum;

import artifacts.AbstractBacklog;
import formalopportunities.Sprint;
import states.Work;

import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

public class Person {
    private static Logger logger;

    public Person() {
        logger = Logger.getLogger(this.getClass().getName());
    }

    public String name;
    public String job;

    public List<Skills> skills;
    public Stack<Work> work;
    public Stack<Work> todo;
    public Work myWork;

    public void present() {
        logger.info(this.name + " makes presentation");
        if (work != null) {
            for (Work d : work) {
                logger.info(work.toString());
                logger.info(this.name + " " + d.toString());
            }
        } else {
            logger.info("but has nothing to say");

        }
    }

    public void do___() {
        work.push(myWork);
    }

    public Work select(AbstractBacklog _todo) {
        myWork = _todo.items.stream().max(
                (d1, d2) -> (int)
                        (d1.compareToSkills(skills) - d2.compareToSkills(skills))).get();
        return myWork;
    }

    public void critizize(Person other)  {
        if (myWork.compareToSkills(other.skills) > other.myWork.compareToSkills(this.skills))  {
            logger.info(this.name + "(" + this.job + ") to " + other.name + "Why did'nt you do my work?");
        }
    }

    public void critizize(Sprint sprint)  {
        if (sprint.sprintBacklog.items.stream().allMatch(work ->work.isDone()))  {
            logger.info("Oh, we may have to move some items back to the Product backlog... ");
        }
    }

}





