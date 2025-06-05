package OOP.polymorphism;

public class Numbers {
    int num;

    public Numbers(int num) {
        this.num = num;
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
