package programs;

import java.util.*;

public class PatternSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int len1 = s1.length(), len2 = s2.length();
        int p1 = 0, p2 = 0;

        // Find first occurrence of starting pattern character
        if (len2 == 0) {
            System.out.println("");
            return;
        }


        p1 = s1.indexOf(s2.charAt(0));
        if (p1 == -1) {
            System.out.println("");
            return;
        }

        int s = p1, e = p1;
        if (s2.charAt(1) != '*')
            p1 = s1.indexOf(s2.charAt(0));

        s = p1;
        e = s;

        while (p1 < len1 && p2 < len2) {
            // Handle '*' wildcard
            if (p2 + 1 < len2 && s2.charAt(p2 + 1) == '*') {
                while (p1 < len1 && s1.charAt(p1) == s2.charAt(p2)) {
                    e = ++p1;
                }
                p2 += 2;
                if (p2 < len2) {
                    p1 = s1.indexOf(s2.charAt(p2), p1);
                    if (p1 == -1) break;
                    s = e = p1;
                }
                continue;
            }

            // Handle '+' wildcard
            if (p2 + 1 < len2 && s2.charAt(p2 + 1) == '+') {
                if (p1 < len1 && s1.charAt(p1) == s2.charAt(p2)) {
                    while (p1 < len1 && s1.charAt(p1) == s2.charAt(p2)) {
                        e = ++p1;
                    }
                    p2 += 2;
                    continue;
                } else {
                    p2 = 0;
                    p1 = s1.indexOf(s2.charAt(p2), p1 + 1);
                    if (p1 == -1) break;
                    s = e = p1;
                    continue;
                }
            }

            // Direct match
            if (p1 < len1 && p2 < len2 && s1.charAt(p1) == s2.charAt(p2)) {
                p1++;
                p2++;
                e = p1;
            } else {
                p2 = 0;
                p1 = s1.indexOf(s2.charAt(p2), s + 1);
                if (p1 == -1) break;
                s = e = p1;
            }
        }

        String res = answer(s1, s, e);
        System.out.println(res);
    }

    public static String answer(String s, int start, int end) {
        if (start == -1 || end == -1 || start >= end) return "";
        return s.substring(start, end);
    }
}
