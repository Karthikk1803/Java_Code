package programs;

import java.util.Scanner;

public class NumSplit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
//        int[] a = new int[n];

//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }

        int []dp = new int[n+1];
        dp[n] = 1;

//        System.out.println(dp[0]);

        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '0') continue;

            long num = 0;
            for(int j=i; j<n; j++){
                num = num*10 + (s.charAt(j) - '0');
                if(num > c) break;
                dp[i] = dp[i] + dp[j+1];
            }
        }
    }
}

