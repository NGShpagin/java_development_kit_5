package task3;

import java.util.Random;

public class Runner {
    private boolean ready = false;
    private String name;
    private int runDistance = 0;

    public Runner(String name) {
        this.name = name;
    }

    public void setReady() {
        try {
            Random rnd = new Random();
            Thread.sleep(rnd.nextInt(1000));
            ready = true;
            System.out.println(name + " is ready: " + ready);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isReady() {
        return ready;
    }

    public void run(int distance) {
        Random rnd = new Random();
        try {
            while (runDistance < distance) {
                runDistance += (new Random()).nextInt(10);
                System.out.println(name + ": " + runDistance);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Runner " + name + " finished!");

    }
}
