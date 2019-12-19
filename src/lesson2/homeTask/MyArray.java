package lesson2.homeTask;

import java.sql.DataTruncation;
import java.util.Comparator;

public class MyArray<T extends Comparable> {
    private T[] array;
    private int size=0;
    private int maxSize;

    public MyArray(int maxSize) {
        this.array = (T[])new Comparable[maxSize];
        this.maxSize = maxSize;
    }

    public void add(T item){
        array[size]=item;
        size++;
    }

    public void add(int index, T item){
        for (int i = size; i < index; i++) {
            array[i]=array[i-1];
        }
        array[index] = item;
        size++;
    }

    public void delete (int index){
        for (int i = index; i < size-1; i++) {
            array[i]=array[i+1];
        }
        size--;
        array[size] = null;
    }

    public T getElement (int index){
        return array[index];
    }


    public void setElement (int index, T item){
        array[index] = item;
    }

    public T[] getArray() {
        return array;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int indexOf(T item){
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder(" [ ");
        for (int i = 0; i < size-1; i++) {
            sb.append(array[i] + ", ");
            if (i!=0&&i%50==0)
                sb.append("\n");
        }
        sb.append(array[size-1]);
        sb.append(" ]");
        return sb.toString();
    }

    public int getSize() {
        return size;
    }

    private void swap(int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

//сортировка пузырьком - написал сам с нуля
    public void sortBubble(){
        T temp;
        int i=size;
        while (i>1){
            for (int j = 1; j < i; j++) {
                if (array[j-1].compareTo(array[j])>0){
                    swap(j-1,j);
                }
            }
            i--;
        }
    }
//сортировка 2
    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int imin = i;
            for (int j = i + 1; j < size; j++) {
                if( array[j].compareTo(array[imin])<0){
                    imin = j;
                }
            }
            swap(i, imin);
        }
    }
//сортировка вставками
    public void insertionSort(){
        T key;
        for (int i = 1; i <size ; i++) {
            int j = i;
            key  = array[i];
            while(j>0 && key.compareTo(array[j-1])<0){
                array[j] = array[j-1];
                j--;
            }
            array[j] = key;
        }
    }
//bubble sort
    public void bubbleSort(Comparator<T> comparator){
        boolean isSwap;
        for (int i = size-1; i > 0 ; i--) {
            isSwap = false;
            for (int j = 0; j < i ; j++) {
                 if( comparator.compare(array[j+1],array[j])<0 ){
                  swap(j+1, j);
                     isSwap = true;
                }
            }
            if(!isSwap){
                break;
             }
        }
    }

    public void bubbleSort(){
        bubbleSort(Comparator.naturalOrder());
    }

}
