package coding;

import java.lang.reflect.Field;

/**
 * @author walid.sewaify
 * @since 22-Nov-20
 * <p>
 * You can hack String value if no proper JVM security is in place
 */
public class CrazyStrings {
    static {
        try {
            Field f = String.class.getDeclaredField("value");
            f.setAccessible(true);
            f.set("hello", "Bad Luck!".toCharArray());
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
