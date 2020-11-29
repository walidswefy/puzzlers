package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author walid.sewaify
 * @since 25/9/2017.
 * <p>
 * Simple thread pool implementation
 */
public class MyThreadPool {
    private final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
    private final int numberOfThread = 3;
    private volatile boolean running = true;

    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool();
        myThreadPool.start();
        myThreadPool.addJob(() -> System.out.println("one"));
        myThreadPool.addJob(() -> System.out.println("two"));
        myThreadPool.addJob(() -> System.out.println("three"));
        myThreadPool.addJob(() -> System.out.println("four"));
        myThreadPool.addJob(() -> System.out.println("five"));
        myThreadPool.stop();
    }

    public void addJob(Runnable job) {
        queue.add(job);
    }

    public void start() {
        Runnable runnable = () -> {
            while (running) {
                try {
                    Runnable job = queue.take();
                    job.run();
                } catch (InterruptedException ignored) {
                }
            }
        };

        for (int i = 0; i < numberOfThread; i++) {
            new Thread(runnable).start();
        }
    }

    public void stop() {
        running = false;
    }


}
