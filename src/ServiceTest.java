import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ServiceTest {

    public void should_handle_heavy_load() throws InterruptedException {
        ScheduledExecutorService workers = Executors.newSingleThreadScheduledExecutor();

        // Submit work

        workers.shutdown();
        workers.awaitTermination(10, TimeUnit.SECONDS);
    }

}
