package lesson7;

import java.util.LinkedList;

public class Queue {
    private LinkedList<Integer> list;


    public Queue(){

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
