package concurrency;

/**
 * @author Walid.Elswaify
 * @since 10/26/11
 * <p>
 * From Java Concurrency In Practise
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
        // count print 0 or go in infinite loop. Changes in Main thread may not be possible to Reader thread
        // reordering may result in printing 0
    }

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }
}



