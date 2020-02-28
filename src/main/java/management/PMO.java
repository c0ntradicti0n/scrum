package management;

import java.util.List;

public class PMO {
    List<Portfolio> portfolios;

    public void manage() {
        for (Portfolio p : portfolios) {
            p.change();
        }
    }
}
