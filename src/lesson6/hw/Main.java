package lesson6.hw;

public class Main {
    public static void main(String[] args) {
        final int AMOUNT = 20;
        int balanced = 0;
        HWTreeMap arr[] = new HWTreeMap[AMOUNT];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new HWTreeMap<Integer, String>();
            do {
                arr[i].put((int)(((Math.random()*2)-1)*100), " ");
            } while (arr[i].height()!=6);
            System.out.print("#"+i+" size="+arr[i].size()+" height=");
            System.out.print(arr[i].height()+" is Balansed=");
            System.out.println(arr[i].isBalanced());
  //          System.out.println(arr[i]);
            if (arr[i].isBalanced()){
                balanced++;
            }
        }

        double proc = (1-( balanced/(double) AMOUNT))*100;
        System.out.println("Процент несбалансированных деревьев - "+proc+" %");






    }

}
