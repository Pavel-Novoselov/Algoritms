package lesson4.hw;

import java.util.NoSuchElementException;

public class HWOneLinkedList<T> {
    private int size=0;
    private Node first;

    private class Node<T>{
        Node next;
        T value;

        public Node(Node next, T value) {
            this.next = next;
            this.value = value;
        }

        public Node(T value) {
            this.value = value;
        }
    }

    public void insertFirst(T value){
        Node newNode = new Node(value);
        if(!isEmpty()){
            newNode.next = first;
        }
        first=newNode;
        size++;
    }

    public void insert(int index, T value){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(isEmpty()){
            insertFirst(value);
            return;
        }
        if (index == 0) {
            insertFirst(value);
            return;
        }
        Node newNode = new Node(value);
        Node current = first;
        int i=0;
        while (i<index-1){
            current=current.next;
            i++;
        }
        newNode.next=current.next;
        current.next=newNode;
        size++;
    }

    public T removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Node oldFirst = first;
        first=first.next;
        size--;
        return (T) oldFirst.value;
    }

    public  T removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Node current = first;
        if (first.next==null){
            first=null;
            return (T) current.value;
        }
        while (current.next.next!=null){
            current=current.next;
        }
        Node temp=current.next;
        current.next=null;
        size--;
        return (T) temp.value;
    }

    public T getLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Node current = first;
        while (current.next.next!=null){
            current=current.next;
        }
        return (T) current.next.value;
    }

    public int size(){
        return size;
    }

    public boolean remove (T value){
        if (isEmpty()){
            return false;
        }
        if (first.value.equals(value)){
            removeFirst();
            return true;
        }
        Node current = first;
        while (current.next!=null&&!current.next.value.equals(value)){
            current=current.next;
        }
        if (current.next==null)
            return false;
        current.next=current.next.next;
        size--;
        return true;
    }

    public int index(T value){
        Node current = first;
        int index=0;
        while(current!=null){
            if (current.value.equals(value)){
                return index;
            }
            current=current.next;
            index++;
        }
        return  -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[ ]";
        }
        HWOneLinkedList.Node current = first;
        StringBuilder sb = new StringBuilder("[ ");

        while (current != null) {
            sb.append(current.value.toString() + ", ");
            current = current.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(" ]");
        return sb.toString();
    }

    public boolean isEmpty(){
        return first==null;
    }
}
