package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {
    private final List<Runner> competitors;
    private boolean isReady = false;
    private boolean countOk = false;

    public Race(int distance, Runner... runners) {
        competitors = new ArrayList<>();
        competitors.addAll(Arrays.asList(runners));
    }


    public void countStart() {
        try {
            System.out.println("Ready");
            Thread.sleep(300);
            System.out.println("Steady");
            Thread.sleep(300);
            System.out.println("Go!!!");
            countOk = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startRace() {
        while (!isReady) {
            isReady();
        }
        while (!countOk) {
            if (isReady) {
                countStart();
            }
        }

        for (Runner runner : competitors) {
            Thread thread = new Thread(() -> {
                runner.run(100);
            });
            thread.start();
        }
    }

    public void isReady() {
        try {
            for (Runner runner : competitors) {
                Thread thread = new Thread(runner::setReady);
                thread.start();
                while (thread.isAlive()) {
                    isReady = false;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        isReady = true;
    }
}
