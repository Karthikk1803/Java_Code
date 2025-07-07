package programs;

import java.util.Scanner;

public class Fraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double in = sc.nextFloat();
        int x = (int) in;
        int par = 100000;
        int y =  Math.round((float) (in - x) * 100000);
        int gcd = gcd(par, y);


        System.out.println();
        y /= gcd; par /= gcd;
        System.out.println(x + " " + y + "/" + par);

    }

    public static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
