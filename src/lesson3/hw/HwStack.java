package lesson3.hw;

import java.util.EmptyStackException;

public class HwStack<T> {
    private T[] list;
    private int size;
    private final int CAPASITY = 10;

    public HwStack() {
        list = (T[]) new Object[CAPASITY];
    }

    public HwStack(int capacity) {
        if (capacity<0){
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public void push(T value){
        if (isFull()){
            throw new StackOverflowError();
        }
        list[size]=value;
        size++;
    }

    public T pop(){
        T temp = peek();
        size--;
        list[size]=null;
        return temp;
    }

    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return list[size-1];
    }

    public boolean isFull(){
        return size==list.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size() {
        return size;
    }

    private void reCapacity(int newCapacity){
        T[] tempArr = (T[]) new Object[newCapacity];
        System.arraycopy(list, 0, tempArr, 0, size);
        list=tempArr;
    }

}
