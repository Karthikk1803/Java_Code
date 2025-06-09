package programs;

import java.util.Scanner;

public class VowelRem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(remVow(s));
    }

    public static String remVow(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(!vow(s.charAt(i))) sb.append(s.charAt(i));
            else if(vow(s.charAt(i)) && i+1<s.length() && vow(s.charAt(i+1))){
                sb.append(s, i, i+2);
                i+=2;
                while(i<s.length() && vow(s.charAt(i))){
                    sb.append(s.charAt(i));
                    i++;
                }
                i--;
            }
        }
        return sb.toString();
    }

    public static boolean vow(char c){
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
