package states;

import java.util.List;

public class Increment {
    List<Work> doneWork;
    public void checkComplete () {
        assert(doneWork.stream().map(doD -> doD.isDone()).allMatch(b -> b) == true);
    }
}
