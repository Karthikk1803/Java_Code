package Train;

public class Passenger {
    String name;
    int age;
    String coach;
    int seatNo;
    boolean isWait;

    public Passenger(String name, int age, String coach, int seatNo, boolean wait){
        this.name = name;
        this.age = age;
        this.coach = coach;
        this.seatNo = seatNo;
        this.isWait = wait;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }
}
