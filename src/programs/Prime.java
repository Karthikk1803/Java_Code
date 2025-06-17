package programs;

import java.util.*;

public class Prime {
//    public static String isPrime(int a) {
//        boolean flag = true;
//        for (int i = 2; i < Math.sqrt(a); i++) {
//            if (a % i == 1) {
//                flag = false;
//                break;
//            }
//        }
//        return flag ? "Prime" : "NotPrime";
//    }

    public static void main(String[] args) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('M', 1000); m.put('D', 500); m.put('C', 100); m.put('L', 50); m.put('X', 10);m.put('V', 5); m.put('I', 1);
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res=0;

        for(int i=0; i< s.length()-1; i++){
            if(m.get(s.charAt(i)) < m.get(s.charAt(i+1))) res -= m.get(s.charAt(i));
            else res += m.get(s.charAt(i));
        }
        res += m.get(s.charAt(s.length() - 1));

        System.out.println(res);
    }
}
