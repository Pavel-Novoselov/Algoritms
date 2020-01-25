package lesson7;

import com.sun.org.apache.xerces.internal.impl.dv.xs.TypeValidator;

public class Vertex<T>{
 //   public char label;
    public T label;
    public boolean wasVisited;

    public Vertex() {
    }

    public Vertex(T label) {
        this.label = label;
        this.wasVisited = false;
    }
}
