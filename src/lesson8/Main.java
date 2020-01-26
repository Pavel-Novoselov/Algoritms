package lesson8;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        ChainedHashMap map = new ChainedHashMap();
//
//        map.put(1, "one");
//        map.put(2, "two");
//        map.put(3, "three");
//        map.put(4, "four");
//        map.put(5, "five");
//
//        System.out.println(map.contains(2));
//        System.out.println(map.get(4));
//        map.put(4,"four4");
//        System.out.println(map.get(4));
//
//        System.out.println(map);
//        map.put (38, "");
//        map.delete(4);
//        System.out.println(map);
//        map.put(205,"");
//        System.out.println(map);
//        map.delete(38);
//        System.out.println(map);


        LinearProbingHashMap<String, String> lpmap = new LinearProbingHashMap<>("Deleted");
        lpmap.put("1", "one");
        lpmap.put("2", "two");
        lpmap.put("3", "three");
        lpmap.put("4", "four");
        lpmap.put("5", "five");

        System.out.println(lpmap);

        lpmap.delete("3");
        System.out.println(lpmap);
        lpmap.put("23", "2twenty two");
        System.out.println(lpmap);




    }
}
