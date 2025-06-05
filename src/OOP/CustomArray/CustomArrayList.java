package OOP.CustomArray;

import java.util.Arrays;

public class CustomArrayList {
    private static int DEFAULT_SIZE = 10;
    private static int size = 0; //current size of the Array
    private int[] data;
    private CustomArrayList CustomArrayList;

    public CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(5);
        list.add(75);
        System.out.println(list);

    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public int get(int index) {
        return data[index];
    }

    public void resize() {
        int[] temp = new int[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    public int remove() {
        if (size == 0) {
            return -1;
        }
        return data[size--];
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + tS(data) +
                ", size=" + size +
                '}';
    }
//
//    Arrays.toString()

    public String tS(int[] a) {
        if (a == null) return null;
        int iMax = size - 1;
        if (iMax == -1) return "[]";
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (iMax == i) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }

}
