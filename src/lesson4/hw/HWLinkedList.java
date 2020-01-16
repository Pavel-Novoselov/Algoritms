package lesson4.hw;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class HWLinkedList<T> implements Iterable<T> {
    private int size=0;
    private Node first;
    private Node last;

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    public ListIterator<T> listIterator() {
        return new LIter();
    }

    private class Node<T>{
        Node next;
        Node prev;
        T value;

        public Node(Node prev, T value, Node next) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        public Node(T value, Node next) {
            this.next = next;
            this.value = value;
        }

        public Node(T value) {
            this.value = value;
        }
    }

    private class Iter implements Iterator<T> {
        Node current = new Node(null, first);

        @Override
        public boolean hasNext() {
            return current.next!=null;
        }

        @Override
        public T next() {
            current = current.next;
            return (T) current.value;
        }

    }

    private class LIter implements ListIterator<T> {
        Node current = new Node(null, first, null);

        @Override
        public boolean hasNext() {
            return current.next!=null;
        }

        @Override
        public T next() {
            current = current.next;
            return (T) current.value;
        }

        @Override
        public boolean hasPrevious() {
            return current.prev!=null;
        }

        @Override
        public T previous() {
            current = current.prev;
            return (T) current.value;
        }

        @Override
        public int nextIndex() {
            return index()+1;
        }

        private int index(){
            Node temp=first;
            int index=0;
            do{
                index++;
                temp = temp.next;
            } while (temp!=current);
            return index;
        }

        @Override
        public int previousIndex() {
            return index()+1;
        }

        @Override
        public void remove() {
            current.prev.next=current.next;
            current.next.prev = current.prev;
            current=current.next;
        }

        @Override
        public void set(T t) {
            current.value=t;
        }

        @Override
        public void add(T t) {
            if(isEmpty()){
                insertFirst(t);
            } else {
                insert(nextIndex(), t);
            }
        }
    }

    public void insertFirst(T value){
        Node newNode = new Node(value);
        if(isEmpty()){
            last=newNode;
            first=newNode;
        } else {
            newNode.next = first;
            first.prev=newNode;
        }
        first=newNode;
        newNode.prev=null;
        size++;
    }

    public void insertLast(T value){
        Node newNode = new Node(value);
        if(isEmpty()){
            first=newNode;
        }
        last.next=newNode;
        newNode.prev=last;
        last=newNode;
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
        newNode.next.prev=newNode;
        newNode.prev=current;
        size++;
    }

    public T removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Node oldFirst = first;
        first=first.next;
        first.prev=null;
        size--;
        return (T) oldFirst.value;
    }

    public  T removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Node temp = last;
        if(last==first){
            last=null;
            first=null;
            return (T) temp.value;
        }
        last=last.prev;
        last.next=null;
        size--;
        return (T) temp.value;
    }

    public T getLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return (T) last.value;
    }

    public T getFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return (T) first.value;
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
        if (last.value.equals(value)){
            removeLast();
            return true;
        }
        Node current = first;
        while (current.next!=null&&!current.next.value.equals(value)){
            current=current.next;
        }
        if (current.next==null)
            return false;
        current.next=current.next.next;
        current.next.prev=current;
        size--;
        return true;
    }

    public int indexOf (T value){
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

    public boolean contains(T value){
        return indexOf(value)>-1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[ ]";
        }
        Node current = first;
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
