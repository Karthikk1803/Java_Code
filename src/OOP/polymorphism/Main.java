package OOP.polymorphism;

public class Main {
    public static void main(String[] args) {

//        Circle circle = new Circle();
//        Square square = new Square();
//
//        circle.area();
        Numbers obj1 = new Numbers(45);
        Numbers obj2 = obj1;

        if (obj1.equals(obj2)) {
            System.out.println("obj 1 is less");
        } else System.out.println("Not");
    }

    //Comment
}
