package OOP.inheritence;

public class Box {
    double l;
    double h;
    double w;
    double weight;

    public Box(double l, double h, double w, double weight) {
        this.l = l;
        this.h = h;
        this.w = w;
        this.setWeight(weight);
    }

    public Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    public Box(double side) {
        this.l = side;
        this.h = side;
        this.w = side;
    }

    public Box() {
        this.l = -1;
        this.h = -1;
        this.w = -1;
        this.setWeight(10);
    }

    Box(Box old) {
        this.l = old.l;
        this.h = old.h;
        this.w = old.w;
        setWeight(old.getWeight());
    }

    public static void info() {
        System.out.println("Running");
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
