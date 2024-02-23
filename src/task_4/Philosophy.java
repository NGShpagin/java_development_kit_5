package task_4;

public class Philosophy {
    private String name;
    private boolean hungry = false;

    private int countEatings = 0;

    public Philosophy(String name) {
        this.name = name;
    }

    public void eat() {
        try {
            Thread.sleep(500);
            hungry = true;
            countEatings++;
            System.out.println(name + ": прием пищи завершен - " + countEatings);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void think() {
        try {
            Thread.sleep(2000);
            hungry = false;
            System.out.println(name + ": поразмышлял");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void live(Kitchen kitchen) {
        while (countEatings < 3) {
            if (!hungry && kitchen.isFree) {
                kitchen.isFree = false;
                eat();
                kitchen.isFree = true;
            } else {
                think();
            }
        }
    }
}
