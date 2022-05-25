package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public class PremiumNumberGenerator implements NumberGenerator {
    @Override
    public Integer generateNumber() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }
        return 4;
    }
}
