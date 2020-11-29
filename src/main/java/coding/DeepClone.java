package coding;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author walid.sewaify
 * @since 25-Nov-10
 * Deep Copy vs Shallow Copy (cloneable objects)
 */
public class DeepClone {

    private static <T> T deepCopy(Object obj, Class<T> type) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            new ObjectOutputStream(bos).writeObject(obj);
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            return type.cast(new ObjectInputStream(bin).readObject());
        } catch (Exception e) {
            throw new IllegalArgumentException("error");
        }
    }
}
