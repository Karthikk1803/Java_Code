package programs;

import java.util.Collections;
import java.util.Scanner;

public class Equilibrium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = {1,1,1,1};
        String []st = new String[4] ;
        System.arraycopy(st, 0, a, 0, 4);
        int[] p = new int[4];
        int[] s = new int[4];
        int pre=0, suf = 0;

        for(int i=0; i<4; i++){
            p[i] = pre += a[i];
            s[3-i] = suf += a[3-i];
        }


        for(int i=1; i<4; i++){
            if(p[i] - s[i] == 0) System.out.println(a[i]);
//            System.out.println(st[i] , st[i].getClass().getName());
//            System.out.println(p[i] + " " + s[i]);
        }

    }
}
