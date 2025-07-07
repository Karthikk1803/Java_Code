package programs;

import java.util.*;

public class AjiraQues {
    static public List<Integer> required = new ArrayList<>();
    static List<List<String>> l = new ArrayList<>();
    static public Map<String, String> map= new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int res=0;


        int days = sc.nextInt();
        int cls = sc.nextInt(); sc.nextLine();

        for(int i=0; i<cls; i++){
            String []tem = sc.nextLine().split(" ");
            l.add(Arrays.asList(tem));
            res += Integer.parseInt(tem[2]);
            required.add(Integer.parseInt(tem[1]) * days);
        }

        int count = sc.nextInt(); sc.nextLine();
        for(int i=0; i<count; i++){
            String []s = sc.next().split("_");
            map.put(s[1], s[0]);
        }


        while(days-- > 0){
            int t = 0;
            while(t < cls){
                List<String> cur = l.get(t);
                String s = cur.get(0);
                int cont = required.get(t);
                int amt = Integer.parseInt(cur.get(1));

                if(amt > cont) res += check_par(s, 0);
                else{
                    res += amt;
                    required.remove(t);
                    required.add(t, cont - amt);
                }
                t++;
            }
        }

        System.out.println(res);
//        System.out.println(map);
//        System.out.println(l);
    }

    private static int check_par(String s, int i) {
        if(s.equals("F")) return 0;

        String dest = map.get(s);
        if(i == 0) {
            if (dest.equals("F")) {
                return fill_in(dest);
            } else {
                return check_par(dest, 1) + fill_in(s);
            }
        }
        else{
            List<String> list = List.of();
            for(List<String> temp: l){
                if(temp.getFirst().equals(s)) list=new ArrayList<>(temp);
            }

            int ind = Integer.parseInt(list.getFirst().substring(1,2)) - 1;
            int cap = Integer.parseInt(list.getLast());

            int temp = required.remove(ind);
            required.add(ind, temp - cap);

            return cap + check_par(dest, 1) ;
        }
    }

    private static int fill_in(String t) {
        List<String> list = List.of();
        for(List<String> temp: l){
            if(temp.getFirst().equals(t)) list=new ArrayList<>(temp);
        }

        int use = Integer.parseInt(list.get(1));
        int ind = Integer.parseInt(list.getFirst().substring(1,2)) - 1;
        int cap = required.remove(ind);

        if( use >  required.get(ind)){
            required.add(ind, 0);
            return use;
        }
        else{
            required.add(ind, cap - use);
            return Integer.parseInt(list.getLast());
        }
    }
}
