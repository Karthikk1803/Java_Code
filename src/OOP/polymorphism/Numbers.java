package OOP.polymorphism;
import java.util.*;
public class Numbers {
    int num;

    public Numbers(int num) {
        this.num = num;
    }
    List<Integer> l= new ArrayList<Integer>();

    public static void main(String[] args) {
//        l.g
    }
    public Numbers(Numbers obj) {
        this.num = obj.num;
    }

    //    int sum (int a, int b){
//        return a+b;
//    }
//
//    int sum(int a, int b, int c) {
//        return a+b+c;
//    }
}
