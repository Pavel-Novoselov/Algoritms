package lesson4.hw;

import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
//        HWOneLinkedList oll = new HWOneLinkedList();
//
//        oll.insertFirst("Вася");
//        oll.insertFirst("Петя");
//        oll.insertFirst("Маша");
//        oll.insertFirst("Маша2");
//
//
//
//        System.out.println(oll);
//        oll.insert(2, "Vitya");
//        System.out.println(oll);
//        oll.removeFirst();
//        System.out.println(oll);
//        oll.remove("Vitya");
//        System.out.println(oll);
//
//        HWLinkedQueue<String> hlq = new HWLinkedQueue<>();
//        hlq.enqueue("Kola");
//        hlq.enqueue("Sema");
//        hlq.enqueue("Dasha");
//        hlq.enqueue("Ira");
//        System.out.println(hlq);
//
//        System.out.println(hlq.dequeue());
//        System.out.println(hlq.dequeue());
//        System.out.println(hlq.dequeue());
//        System.out.println(hlq.dequeue());
//
//
//
//        HWLinkedStack<String> stack1 = new HWLinkedStack();
//        stack1.push("Igor1");
//        stack1.push("Igor2");
//        stack1.push("Igor3");
//        stack1.push("Igor4");
//        stack1.push("Igor5");
//
//        System.out.println(stack1.pop());
//        System.out.println(stack1.pop());
//        System.out.println(stack1.pop());
//
//        System.out.println(stack1);
//
//
//
//
        HWLinkedList<String> ll = new HWLinkedList();
        ll.insertFirst("Ira1");
        ll.insertFirst("Ira2");
        ll.insertFirst("Ira3");
//        ll.insertFirst("Ira4");
//        ll.insertFirst("Ira5");
//        ll.insertFirst("Ira6");
//        System.out.println(ll);
//        ll.insertLast("Vasa");
//        System.out.println(ll);
//        ll.insert(3, "Vova");
//        System.out.println(ll);
//        System.out.println(ll.removeLast());
//        ll.remove("Ira3");
//        System.out.println(ll);
//        ll.removeFirst();
//        System.out.println(ll);
//        System.out.println(ll.getLast());
//        System.out.println(ll.size());
//        System.out.println(ll.indexOf("Ira4"));
//        System.out.println(ll.contains("Ira5"));
//        System.out.println(ll.getFirst());

        for (String hw:ll) {
            System.out.print(hw+" ");
        }
        System.out.println();

        Iterator<String> iterator = ll.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" | ");
        }
        System.out.println();

        ListIterator<String> listIterator = ll.listIterator();
    //    listIterator.add("Egor");
        while (listIterator.hasNext()){
            System.out.println(listIterator.next()+" // ");
        }






    }
}
