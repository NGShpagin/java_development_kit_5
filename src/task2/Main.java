package task2;

/* Задание 2.
    Создайте два потока A и B
    Поток A меняет значение Boolean переменной switcher с задержкой 1000 миллисекунд (true в состояние false и наоборот)
    Поток B ожидает состояния true переменной switcher и выводит на консоль обратный отсчет от 100
    с задержкой 100 миллисекунд и приостанавливает свои действия, как только поток А переключит switcher в состояние false.
    Условием завершения работы потоков является достижение отсчета нулевой отметки.
 */

public class Main {

    private static boolean switcher = true;
    private static int counter = 100;

    public static void main(String[] args) throws InterruptedException {

        Runnable runA = () -> {
            try {
                while (counter > 0) {
                    switcher = !switcher;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runB = () -> {
            try {
                while (counter > 0) {
                    if (switcher) {
                        counter--;
                        System.out.println(counter);
                    }
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Thread threadA = new Thread(runA);
        Thread threadB = new Thread(runB);

        threadA.start();
        threadB.start();
    }
}