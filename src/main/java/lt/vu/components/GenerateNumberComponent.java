package lt.vu.components;

import lt.vu.services.NumberGenerator;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateNumberComponent implements Serializable {
    @Inject
    private NumberGenerator numberGenerator;
    private CompletableFuture<Integer> numberGenerationTask = null;

    public void generateNumber() {
        numberGenerationTask = CompletableFuture.supplyAsync(() -> numberGenerator.generateNumber());
    }

    public String getGeneratedNumber() throws ExecutionException, InterruptedException {
        if (numberGenerationTask == null) {
            return null;
        } else if (!numberGenerationTask.isDone()) {
            return "Generating...";
        }
        return numberGenerationTask.get().toString();
    }
}
