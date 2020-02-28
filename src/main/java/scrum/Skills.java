package scrum;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import states.Done;

public class Skills {
    String value = "Nothing";


    public int fits(Done done) {
        return (int) FuzzySearch.ratio(done.getDescription(), value);
    }
}
