package programs;

import java.util.Scanner;

public class MinSubSeqProd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        int n = sc.nextInt();
//        int[] a = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }


        int m=5;
        int n =9;         //0 1 2 3 4 5 6 7 8
        int []a = new int[]{5,2,3,6,2,9,3,3,5};



//        int res = Integer.MAX_VALUE;
//        for(int i=0; i <= n-m; i++){
//            for(int j = i+m-1; j<n; j++){
//                res = Math.min(res, a[i] * a[j]);
//            }
//        }
//        System.out.println(res);

        int []suf = new int[n];
        suf[n-1] = a[n-1];

        for(int i = n-2; i>=0; i--){
            suf[i] = Math.min(suf[i+1], a[i]);
        }

        int res = Integer.MAX_VALUE;
        for(int i=0; i<=n-m; i++){
            int j = i+m-1;
            res = Math.min(res, a[i] * suf[j]);
        }

        System.out.println(res);

    }
}
