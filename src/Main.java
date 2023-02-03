import java.util.*;

public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus((short) 100, (short) 200, (byte) 50, 1500);
        Bus bus2 = new Bus((short) 100, (short) 200, (byte) 50, 1500);
        Taxi taxi1 = new Taxi((short) 100, (short) 200, (byte) 5, 3000);

        bus1.setSpeed((short) 300);
        bus1.changePassenger((byte) 1);
        bus1.changeFuelTank((short) -50);
        bus1.changeState("차고지행");
        bus1.changeFuelTank((short) 10);
        bus1.changePassenger((byte) 50);
        bus1.changeState("운행");
        bus1.changePassenger((byte) 50);
        bus1.changePassenger((byte) 4);
        bus1.changeFuelTank((short) -55);
        bus1.changeState("운행");
        bus1.changeState("운행종료");
//        taxi1.printState();
//        taxi1.printInfomation();
//        taxi1.changePassenger((byte) 2);
//        taxi1.setDestination("서울역", 2);
//        taxi1.changeState("운행");
//        taxi1.changeFuelTank((short) -80);
//        taxi1.changeFuelTank((short) 20);
//        taxi1.changeState("운행종료");
//        taxi1.changePassenger((byte) 6);
//        taxi1.changeState("운행");
//        taxi1.printState();
//        taxi1.setDestination("구로디지털단지역", 15);
//        taxi1.changeState("운행종료");
//        taxi1.changeFuelTank((short) -80);
//        taxi1.printState();

    }
}