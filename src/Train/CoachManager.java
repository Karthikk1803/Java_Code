package Train;

import java.util.*;

public class CoachManager {
    String type;
    private final int MAX_CONF = 60;
    private final int MAX_WAIT = 10;

    List<Passenger> con = new ArrayList<>();
    List<Passenger> wait = new ArrayList<>();

    public CoachManager(String type){
        this.type =type;
    }

    public void bookTkt(Passenger p){
        if(con.size() < MAX_CONF){
            con.add(p);
            p.setSeatNo(con.size());
            System.out.println("Booked Successfully!!\n");
        }
        else if(wait.size() < MAX_WAIT){
            wait.add(p);
            System.out.println("Waiting List: " + wait.size());
        }
        else{
            System.out.println("No Available Tickets in " + this.type );
        }
    }

    public boolean cancelTkt(String name){
        for(Passenger p : con){
            if(p.name.equalsIgnoreCase(name)){
                if(!wait.isEmpty()){
                    Passenger t = wait.removeFirst();
                    t.seatNo = p.seatNo;
                    t.isWait = false;
                    con.add(t);
                }
                con.remove(p);
                return true;
            }
        }
        for(Passenger p: wait){
            if(p.name.equalsIgnoreCase(name)){
                wait.remove(p);
                return true;
            }
        }
        return false;
    }

    public void printChart(){
        System.out.println(type);
        System.out.printf("%-10s %-3s %-6s\n", "Name", "Age", "SeatNumber");
        int c=1;
        for(Passenger p: con){
            System.out.printf("%-10s %-3d %-6d\n", p.name, p.age, p.seatNo);
        }
    }

    public void avail(){
        System.out.println(type);
        System.out.println("Seats Available: " + (MAX_CONF-con.size()) +
                "\nWaiting List: " + (MAX_WAIT - wait.size()) + "\n");
    }

}
