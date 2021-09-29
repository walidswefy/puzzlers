package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Simulation of 10 players racing to enter a tennis playground to play
 */
public class TennisSemaphore {
    public static void main(String[] args) throws InterruptedException {
        Semaphore playground = new Semaphore(2);
        CountDownLatch players = new CountDownLatch(10);
        CyclicBarrier match = new CyclicBarrier(2);
        AtomicBoolean matchCompleted = new AtomicBoolean(false);

        Runnable player = () -> {
            String name = Thread.currentThread().getName();
            try {
                playground.acquire();
                matchCompleted.set(false);
                System.out.println(name + " entered the playground...");
                Thread.sleep(2000);
                System.out.println(name + " finished playing...");
                players.countDown();
                match.await(); // cyclic barrier automatically reset (can be reused)

                if (matchCompleted.compareAndSet(false, true) && players.getCount() > 0) {
                    System.out.println("------ new match -------");
                }

            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            } finally {
                playground.release();
            }
        };


        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(player, "player: " + i);
            t.start();
        }

        players.await();

    }
}
