import java.util.*;

public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus((short) 100, (short) 200, (byte) 50, 1500);
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
    }
}