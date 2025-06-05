package OOP.construct;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        A guru;
        guru = new A("guru");
        for (int i = 0; i < 100000000; i++) {
            guru = new A("Random");
        }
    }
}

class Student {
    int rno;
    String name;
    float mark;

    Student(int r, String n, float m) {
        this.rno = r;
        this.mark = m;
        this.name = n;
    }

    Student() {
    }
}

class A {
    String name;


    public A(String name) {
        this.name = name;
    }
}