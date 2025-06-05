package programs;

import java.util.Scanner;

public class SetBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int max = 0, min = 1000;
        int mx_ind = 0, mn_ind = 0;
        for (int i = 0; i < n; i++) {
            int num = a[i];
//            int temp = Integer.bitCount(num);
            int temp = setBit(num);
            if (temp > max) {
                max = temp;
                mx_ind = i;
                System.out.println(max + " " + temp + " max");
            }
            if (temp < min) {
                min = temp;
                mn_ind = i;
                System.out.println(min + " min");
            }
        }
        int m1 = a[mx_ind], m2 = a[mn_ind];

        System.out.println(m1 * m1 + " " + m2 * m2);

        sc.close();
    }

    public static int setBit(int i) {
        if (i == 1) return 1;
        return i % 2 + setBit(i / 2);
    }

}

