package concurrency;

/**
 * @author walid.sewaify
 * @since 25-Feb-10
 * <p>
 * Potential deadlock is there if order of locking objects is not preserved.
 */
public class LockOrder {
    private final Object primaryLock = new Object();
    private final Object secondaryLock = new Object();

    public boolean requiresLock() {
        synchronized (primaryLock) {
            synchronized (secondaryLock) {
                return false;
            }
        }
    }

    public boolean yetAnotherLock() {
        synchronized (secondaryLock) {
            synchronized (primaryLock) {
                return true;
            }
        }
    }

}
