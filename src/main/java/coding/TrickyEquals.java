package coding;

/**
 * @author walid.sewaify
 * @since 25-Nov-2
 * <p>
 * Equals contract
 * reflexive: an object must equal itself
 * symmetric: x.equals(y) must return the same result as y.equals(x)
 * transitive: if x.equals(y) and y.equals(z) then also x.equals(z)
 * consistent: no randomness allowed
 */
public class TrickyEquals {
    public static void main(String[] args) {
        Parent p = new Parent(1, 2);
        Child c = new Child(1, 2, 3);
        // To respect equals contract, inherited objects that add new properties can never be equal to parent objects
        System.out.println(p.equals(c));
        System.out.println(c.equals(p));
    }
}

class Parent {
    private int x;
    private int y;

    Parent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return x == parent.x && y == parent.y;
    }
}

class Child extends Parent {
    private int z;

    Child(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Child child = (Child) o;
        return z == child.z;
    }
}
