package interfaces;

class Prototype implements Cloneable {
    int id;
    Prototype(int id) { this.id = id; }
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CloningPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p1 = new Prototype(101);
        Prototype p2 = (Prototype)p1.clone();
        System.out.println("Cloned ID: " + p2.id);
    }
}
