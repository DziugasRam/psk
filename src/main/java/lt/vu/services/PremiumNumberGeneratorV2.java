package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;

@ApplicationScoped
@Specializes
public class PremiumNumberGeneratorV2 extends PremiumNumberGenerator {
    @Override
    public Integer generateNumber() {
        try {
            Thread.sleep(1000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        return 15;
    }
}
