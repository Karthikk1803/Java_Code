package Train;

import com.sun.security.jgss.GSSUtil;

import javax.sound.midi.Soundbank;
import java.util.*;

public class MainPage {
    static CoachManager AC = new CoachManager("AC");
    static CoachManager NC = new CoachManager("NC");
    static CoachManager SR = new CoachManager("SR");

    static Scanner sc = new Scanner(System.in);
    public void main(String[] args) {

        while(true){
            System.out.println("1. Book\n2. Cancel\n3. Chart\n4. Availability\n");
            System.out.print("Enter choice: ");
            int c = sc.nextInt();

            switch (c){
                case 1: booktkt();
                        break;
                case 2: canceltkt();
                        break;
                case 3: showChart();
                        break;
                case 4: avail();
                        break;
                default:
                    System.out.println("Enter valid choice."); continue;
            }
        }
    }

    private void showChart() {
        if(!AC.con.isEmpty()) AC.printChart();
        System.out.println();
        if(!NC.con.isEmpty())NC.printChart();
        System.out.println();
        if(!SR.con.isEmpty())SR.printChart();
    }

    private void avail(){
        AC.avail();
        NC.avail();
        SR.avail();
    }

    private void booktkt(){
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Pref Coach [AC, NC, SR]: ");
        String coach = sc.next().toUpperCase();

        Passenger p = new Passenger(name, age, coach, -1, true);
        switch (coach){
            case "AC": AC.bookTkt(p); break;
            case "NC": NC.bookTkt(p); break;
            case "SR": SR.bookTkt(p); break;
            default:
                System.out.println("Enter Valid choice.");
        }
    }

    private void canceltkt(){
        System.out.print("Enter Name: ");
        String name = sc.next();

        if(AC.cancelTkt(name) || NC.cancelTkt(name) || SR.cancelTkt(name)) System.out.println("Successfully Cancelled");
        else System.out.println("Please Check Name");

    }
}
