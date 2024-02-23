package task_4;

/*
    Есть пять философов (потоки), которые могут либо пообедать, либо размышлять.
    Каждый философ должен пообедать три раза.
    Каждый прием пищи длится 500 миллисекунд.
    После каждого приема пищи философ должен размышлять.
    Не должно возникнуть общей блокировки.
    Философы не должны есть больше одного раза подряд
 */


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Kitchen kitchen = new Kitchen();

        Philosophy phil1 = new Philosophy("Philosophy 1");
        Philosophy phil2 = new Philosophy("Philosophy 2");
        Philosophy phil3 = new Philosophy("Philosophy 3");
        Philosophy phil4 = new Philosophy("Philosophy 4");
        Philosophy phil5 = new Philosophy("Philosophy 5");

        List<Philosophy> philosophies = new ArrayList<>();
        philosophies.add(phil1);
        philosophies.add(phil2);
        philosophies.add(phil3);
        philosophies.add(phil4);
        philosophies.add(phil5);

        for (Philosophy phil: philosophies) {
            Thread thread = new Thread(() -> {
                phil.live(kitchen);
            });
            thread.start();
        }
    }
}
