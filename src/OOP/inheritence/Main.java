package OOP.inheritence;

public class Main {
    public static void main(String[] args) {
//        Box box1 = new Box(10,4,13);
//        Box box2 = new Box(box1);
//        System.out.println(box1.l + " " + box2.h);
        BoxWeight box3 = new BoxWeight();
        BoxWeight copy = new BoxWeight(box3);
        System.out.println(box3.h + " " + box3.weight);
    }
}
