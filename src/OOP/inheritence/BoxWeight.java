package OOP.inheritence;

public class BoxWeight extends Box {
    double weight;

    BoxWeight() {
        weight = -1;
        super();
        weight = super.getWeight() * 2;
        System.out.println(super.weight);
    }

    BoxWeight(BoxWeight old) {
        super(old);
        weight = old.weight;
    }

    public BoxWeight(double l, double h, double w, double weight) {
        super(l, h, w);
        this.weight = weight;
    }
}
