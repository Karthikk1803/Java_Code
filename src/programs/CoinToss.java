package programs;

import java.util.Scanner;

public class CoinToss {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(); //Number of Tosses
        int r=sc.nextInt(); //Number of Head

        System.out.println(c_head(n,r));
    }

    public double fact(int n){
        if(n<2) return 1;
        return n * fact(n-1);
    }

    public double c_head(int n, int r){
        double res = fact(n) / fact(r) * fact(n-r);
        res = res / Math.pow(2,n);
        return res;
    }
}
