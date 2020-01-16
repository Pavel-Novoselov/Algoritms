package lesson4.hw;

public class HWLinkedQueue<T> {
    HWOneLinkedList queue = new HWOneLinkedList();

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void enqueue(T value){
        queue.insertFirst(value);
    }

    public T dequeue(){
        return (T) queue.removeLast();
    }

    public T peek(){
        return (T) queue.getLast();
    }

    public String toString(){
        return queue.toString();
    }
}
