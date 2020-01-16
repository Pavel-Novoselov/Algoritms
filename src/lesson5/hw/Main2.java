package lesson5.hw;

import java.util.ArrayList;
import java.util.Comparator;

public class Main2 {

    public static void main(String[] args) {
//спосок вещей (имя/вес/цена)
        ArrayList<Things> list=new ArrayList<>();
        Things thing1 = new Things("thing1", 1f, 100);
        Things thing2 = new Things("thing2", 1.1f, 160);
        Things thing3 = new Things("thing3", 0.5f, 60);
        Things thing4 = new Things("thing4", 0.7f, 90);
        Things thing5 = new Things("thing5", 1.4f, 130);
        list.add(thing1);
        list.add(thing2);
        list.add(thing3);
        list.add(thing4);
        list.add(thing5);

 //сортируем вещи по удельной стоимости
        list.sort(new Comparator<Things>() {
            @Override
            public int compare(Things o1, Things o2) {
                return (int)(o2.udelPrice-o1.udelPrice);
            }
        });
//создаем рюкзак и указ. его макс вес
        Ruckzack ruckzack = new Ruckzack(2.9f);
//добавляем в рюкзак вначале вещи с самой большой удельной стоимостью, пока есть место в рюкзаке
        for (Things t: list) {
            if (ruckzack.getCurrent_weight()+t.getWeight()>ruckzack.getMax_waight())
                break;
            ruckzack.addThing(t);
        }

        System.out.println("Итого стомость рюкзака- "+ruckzack.getCurrent_price());
        System.out.println("Итого вес рюкзака- "+ruckzack.getCurrent_weight());
        System.out.println("Что положили- "+ruckzack.getThings());

    }

}
