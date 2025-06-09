package programs;

import java.util.*;

public class BinToHex {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Character> m = new HashMap<>();
        m.put("0000", '0'); m.put("0001", '1'); m.put("0010", '2');
        m.put("0011", '3'); m.put("0100", '4'); m.put("0101", '5');
        m.put("0110", '6'); m.put("0111", '7'); m.put("1000", '8');
        m.put("1001", '9'); m.put("1010", 'A'); m.put("1011", 'B');
        m.put("1100", 'C'); m.put("1101", 'D'); m.put("1110", 'E');
        m.put("1111", 'F');
        StringBuilder res = new StringBuilder();

        String n = sc.next();
        String[] s = n.split("\\.");


        for(int a=0; a < (s[0].length() % 4); a++){
            s[0] = '0' + s[0];
        }
        if(s.length != 1) {
            for (int a = 0; a < (s[1].length() % 4); a++) {
                s[1] = s[1] + '0';
            }
            System.out.println(s[0] +" "+ s[1]);
        }
        boolean flag = true;
        for(String i: s){
            for(int a=0; a < (i.length()/4); a++){
                String t = i.substring(a*4, (a*4)+4);
                res.append(m.get(t));
            }
            if(flag && s.length != 1){
                res.append("."); flag = false;
            }
        }
        System.out.println(res);
    }
}
