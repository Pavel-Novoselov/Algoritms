package lesson4.hw;

public class HWLinkedStack<T> {
    HWOneLinkedList queue = new HWOneLinkedList();

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void push(T value){
        queue.insertFirst(value);
    }

    public T pop(){
        return (T) queue.removeFirst();
    }

    public T peek(){
        return (T) queue.getLast();
    }

    public String toString(){
        return queue.toString();
    }
}
