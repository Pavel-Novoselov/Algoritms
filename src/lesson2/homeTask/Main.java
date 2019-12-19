package lesson2.homeTask;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 100000;
        String type = "int";
        MyArray<Integer> arrInt = new MyArray<>(size);

        arrInt.add(5);
        arrInt.add(8);
        arrInt.add(7);

        System.out.println(arrInt);

        arrInt.delete(1);

        System.out.println(arrInt);

        arrInt.add(15);
        arrInt.add(28);
        arrInt.add(73);

        System.out.println(arrInt);

        System.out.println("index: "+arrInt.indexOf(73));

        Random random = new Random();

        for (int i = arrInt.getSize(); i < size; i++) {
            arrInt.add(random.nextInt(100));
        }
        long time=0;

        time=System.currentTimeMillis();
        arrInt.sortBubble();
        System.out.println("My buble Sort = "+(System.currentTimeMillis()-time)+" mSec");
  //      System.out.println(arrInt);

        time=System.currentTimeMillis();
        arrInt.selectionSort();
        System.out.println("selection Sort = "+(System.currentTimeMillis()-time)+" mSec");
 //       System.out.println(arrInt);

        for (int i = 0; i < size; i++) {
            arrInt.delete(i);
        }
        for (int i = 0; i < size; i++) {
            arrInt.add(random.nextInt(1000));
        }

        time=System.currentTimeMillis();
        arrInt.insertionSort();
        System.out.println("insert Sort = "+(System.currentTimeMillis()-time)+" mSec");
 //       System.out.println(arrInt);

        for (int i = 0; i < size; i++) {
            arrInt.delete(i);
        }
        for (int i = 0; i < size; i++) {
            arrInt.add(random.nextInt(100));
        }

        time=System.currentTimeMillis();
        arrInt.bubbleSort();
        System.out.println("bubble Sort 2 = "+(System.currentTimeMillis()-time)+" mSec");
 //       System.out.println(arrInt);

    }
}
