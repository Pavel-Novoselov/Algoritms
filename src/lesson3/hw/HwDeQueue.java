package lesson3.hw;

import java.util.EmptyStackException;

public class HwDeQueue<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int begin = 0;
    private int end = 0;



    public int getSize() {
        return size;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public HwDeQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public HwDeQueue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertRight(T value) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        list[end] = value;
        size++;
        end = nextIndex(end);
    }

    public void insertLeft(T value) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        if (begin>0) {
            list[begin-1] = value;
            begin--;
        } else{
            for (int i = end; i > begin; i--) {
                list[i]=list[i-1];
            }
            list[begin]=value;
            end++;
        }
        size++;
    }

    public T removeLeft() {
        T temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeRight() {
        T temp = peekLast();
        size--;
        list[end-1]=null;
        end--;
        return temp;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[begin];
    }

    public T peekLast() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return list[end-1];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
