package concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author walid.sewaify
 * @since 25/9/2017.
 */
public class RaceContention {
    static ReentrantLock lock = new ReentrantLock();
    static int count = 0;

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception ignored) {
        }

        // count should be 20000, will be less if synchronization is not properly handled
        System.out.println(count);
    }

    private static void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
