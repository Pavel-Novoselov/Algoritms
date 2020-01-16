package lesson5.hw;

public class Main1 {
    private static double x;

    public static void main(String[] args) {
        x=2;
        System.out.println(recStep(-5));
    }
    static double recStep(int n){
        if (n==0)
            return 1;
        else if (n>0) {
            return recStep(n-1)*x;
        } else  {
            return recStep(n+1)/x;
        }
    }
}

