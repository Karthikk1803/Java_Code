/*
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

        int s, e;

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

                    if (p1 == -1){
                        s = e = p1;
                        break;
                    }
                }
                continue;
            }

            // Handle '+' wildcard
            if (p2 + 1 < len2 && s2.charAt(p2 + 1) == '+') {
                if (s1.charAt(p1) == s2.charAt(p2)) {
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
                p1++;
                //if (p1 == -1) break;
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
*/

package programs;
import java.util.*;
public class PatternSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String pattern = sc.next();

        String result = "";
        for (int i = 0; i < text.length(); i++) {
            String match = matchFrom(text, pattern, i, 0);
            if (match.length() > result.length()) {
                result = match;
            }
        }

        System.out.println(result);
    }

    public static String matchFrom(String text, String pattern, int i, int j) {
        int start = i;

        while (i < text.length() && j < pattern.length()) {
            char pc = pattern.charAt(j);

            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                while (i < text.length() && text.charAt(i) == pc) i++;
                j += 2;
            }
//            text.inde
            else if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '+') {
                if (text.charAt(i) != pc) return "";
                while (i < text.length() && text.charAt(i) == pc) i++;
                j += 2;
            }

            else if (text.charAt(i) == pc) {
                i++;
                j++;
            }
            else {
                return "";
            }
        }

        if (j == pattern.length()) {
            return text.substring(start, i);
        }

        return "";
    }
}

