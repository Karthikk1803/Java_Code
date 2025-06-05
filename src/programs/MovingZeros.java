package programs;

import java.util.*;

public class MovingZeros {
    public static void main(String[] args) {
        int[] arr = {3, 2, 17, 0, 0, 0, 4};
        int size = arr.length - 1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == 0) {
                int index = nextNum(arr, i + 1);
                if (index == -1) {
                    System.out.println(Arrays.toString(arr));
                    break;
                }
                swap(arr, i, index);
            }
        }
    }

    public static int nextNum(int[] arr, int index) {
        for (int i = index; i < arr.length; i++) {
            if (arr[i] != 0) return i;
        }
        return -1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

