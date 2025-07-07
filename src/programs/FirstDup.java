package programs;

import java.util.HashMap;
import java.util.Map;

public class FirstDup {
    public static void main(String[] args) {
        int a[] = {3,4,2,4,2,5,3};
        Map<Integer, Integer> m = new HashMap<>();
        int minInd = Integer.MAX_VALUE;
        for(int i=0; i<a.length ; i++){
            if(m.containsKey(a[i])){
                minInd = Math.min(minInd, m.get(a[i]));
            }
            else m.put(a[i], i);
        }

        StringBuilder sb = new StringBuilder('a');
        String s = "";
        System.out.println(s);
        s="abcd"; s="edf";
//        s.contain
        if (minInd == Integer.MAX_VALUE) System.out.println("false");
        else System.out.println(a[minInd]);
    }
}
