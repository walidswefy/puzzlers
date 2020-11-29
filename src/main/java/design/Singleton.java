package design;

/**
 * @author walid.sewaify
 * @since 22-Nov-2010
 * <p>
 * Effective-Java elegant approach
 */
public class Singleton {
    private static Singleton instance;

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }
}
