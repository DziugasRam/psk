package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public class CheapNumberGenerator implements NumberGenerator {
    @Override
    public Integer generateNumber() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        return 3;
    }
}
