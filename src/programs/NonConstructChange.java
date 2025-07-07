package programs;

import java.util.*;

public class NonConstructChange {
    static ArrayList<Integer> l = new ArrayList<>();

    public static void main(String[] args) {
        int []a = {1,2,3,8};
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<a.length; i++){
            s.add(a[i]);
            for(int j=i+1; j<a.length; j++){
                s.add(a[i] + a[j]);
            }
        }
        System.out.println(s);
        for(int i=1;; i++){
            if (!s.contains(i))
            {
                System.out.println(i);
                break;
            }
        }



//        int x = a[0];
//        for(int n=1; n<a.length; n++){
//            x ^= a[n];
//        }
//        System.out.println(x);




        //Optimised
//        Arrays.sort(a);
//        int curr = 0;
//        for(int c: a){
//            if(c > curr + 1) break;
//            curr += c;
//        }
//        System.out.println(curr+1);
//
    }


}
