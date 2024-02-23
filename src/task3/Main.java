package task3;

/* Задание 3.
    3 бегуна должны прийти к старту.
    Программа должна гарантировать, что гонка начнется только когда все 3 участника будут на старте
    Программа должна отсчитать "На старт", "Внимание", "Марш"
    Программа должна завершиться, когда все участники закончат гонку
 */

public class Main {

    public static void main(String[] args) {

        Runner runner1 = new Runner("Runner 1");
        Runner runner2 = new Runner("Runner 2");
        Runner runner3 = new Runner("Runner 3");

        Race race = new Race(100, runner1, runner2, runner3);
        race.isReady();
        race.startRace();
    }
}
