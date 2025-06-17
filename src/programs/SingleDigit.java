package programs;

public class SingleDigit{
    public static void main(String[] args) {
        int[] a = {1,2,2,3,3,4 ,4,5,5};

        int l=0, r=a.length-1;
        while(l<r){
            int m = l+ (r-l)/2;
            //System.out.println(m);
            if(m%2==1)m--;
            if(a[m] == a[m+1]) l = m+2;
            else r=m;
            //System.out.println(a[l]+"\n");
        }
        System.out.println(a[l]);
    }

}