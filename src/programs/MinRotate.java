package programs;

public class MinRotate {
    public static void main(String[] args) {
        int[]a = {1,2,3,4,5};
        int l=0, r = a.length-1;
        while(l<r){
            if(a[l] < a[r]){
                System.out.println(a[l]);
                break;
            };
            int m = (l+r) /2;
            if(a[m] > a[r]) l = m+1;
            else r= m;
        }
        System.out.println(a[l]);
    }
}
