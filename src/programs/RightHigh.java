package programs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightHigh {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        int[] a= {16,17,3,5,1,2};
        List<Integer> l = new ArrayList<>();
        for(int i= a.length-1; i >= 0; i--){
            if(q.isEmpty()){
                l.add(a[i]);
                q.offer(a[i]);
                continue;
            }

            while(!q.isEmpty() && q.peek() >= a[i]){
                q.poll();
            }
            if(q.isEmpty()) l.add(a[i]);
            else {
                l.add(q.peek());
                q.offer(a[i]);
            }
        }
        System.out.println(l.reversed());
    }
}
