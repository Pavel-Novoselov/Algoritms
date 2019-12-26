package lesson3.hw;

import lesson3.MyPriorityQueue;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        HwStack<Integer> stack = new HwStack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//
//        for (int i = 0; i < 5; i++) System.out.println(stack.pop());
//
//        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(10, Comparator.naturalOrder());
//        pq.insert(5);
//        pq.insert(9);
//        pq.insert(1);
//        pq.insert(6);
//        pq.insert(4);
//
//        for (int i = 0; i <5 ; i++) {
//            System.out.println(pq.remove());
//        }

        String str = "Hello World!";
        System.out.println(reversStr(str));

        //двусторонняя очередь
        //добавляем слева
        HwDeQueue<Integer> hdq = new HwDeQueue<>(10);
        hdq.insertRight(1);
        hdq.insertRight(2);
        hdq.insertRight(3);
        hdq.insertRight(4);
        hdq.insertRight(5);

        int size = hdq.getSize();
        for (int i = 0; i < size; i++) {
            System.out.print(hdq.removeLeft()+ " ");
        }
        System.out.println();

        hdq.insertLeft(11);
        hdq.insertLeft(12);
        hdq.insertLeft(13);
        hdq.insertLeft(14);
        hdq.insertLeft(15);

        size = hdq.getSize();
        for (int i = 0; i < size; i++) {
            System.out.print(hdq.removeRight()+ " ");
        }
    }
//метод возвращает зеркальную строку
    public static String reversStr(String str){
        HwStack<Character> stack = new HwStack<>(str.length());
        String string="";
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            string+=stack.pop();
        }
        return string;
    }
}
