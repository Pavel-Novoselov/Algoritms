package graf;

import java.util.LinkedList;

public class Queue {
    private int maxSize;
    private LinkedList<Integer> list;


    public Queue(int size){
        this.maxSize = size;
        this.list = new LinkedList<>();

    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void insert(int i){
        list.addLast(i);
    }

    public int remove(){
        return list.removeFirst();
    }

}
