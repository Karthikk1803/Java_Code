package programs;

import OOP.construct.Main;

import java.util.Scanner;

public class LongestSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();


        System.out.println(longSub(s));
    }

    public static String longSub(String s){
        String res = ""; int n = s.length();
        int[] l_seen = new int[256];
        int st = 0;
        int m = 0;

        for(int i=0; i<n; i++){
            char t = s.charAt(i);
            if(l_seen[t] > st){
                st = l_seen[t];
            }
            l_seen[t] = i+1;
            int t1 = m;
            m = Math.max(m, i+1-st);

            if(t1<m){
                res = s.substring(st, i+1);
            }
        }
        System.out.println(m);
        return res;
    }
}
