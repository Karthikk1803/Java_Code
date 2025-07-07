package Algo;

public class Insertion {
    public static void main(String[] args) {
        int[] a = {1,0,2,4,3,8,6,5,7,9};
        for(int i=1; i<a.length;i++){
            int k = a[i];
            int j = i-1;
            while(j>= 0 && a[j] > k){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = k;
        }
        for(int i=0; i<a.length;i++){
            System.out.print(a[i] + " ");
        }
    }
}
