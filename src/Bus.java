public class Bus extends PublicTransport implements PublicTransportService {
    final String STATE_DRIVE_START = "운행";
    final String STATE_DRIVE_END = "운행종료";
    final String STATE_GARAGE = "차고지행";

    private static short number;

    public Bus(short MAX_FUEL, short MAX_SPEED, byte MAX_PASSENGER, int cost) {
        super(MAX_FUEL, MAX_SPEED, MAX_PASSENGER, cost);
        setState(STATE_DRIVE_START);
        setNumber((short) (getNumber() + 1));
        System.out.printf("%d버스가 생성되었습니다.\n", getNumber());
    }

    @Override
    public void changePassenger(byte count) {
        if (getState().equals(STATE_DRIVE_START)) {
            addPassenger(count);
            calculateCost();
            printInfomation();
        } else
            System.out.println("운행 중이 아닙니다.");
    }

    @Override
    public void changeState(String state) {
        switch (state) {
            case STATE_DRIVE_START:
                if (getFuel() < 10) {
                    System.out.println("주유량이 부족하여 운행이 불가합니다.");
                } else {
                    setState(STATE_DRIVE_START);
                }
                break;
            case STATE_GARAGE:
                setState(STATE_GARAGE);
                break;
            case STATE_DRIVE_END:
                System.out.println("오늘의 수익 : " + getTotalCost());;
                setState(STATE_GARAGE);
                break;
            default:
                System.out.println("제대로 된 상태를 입력해주세요.");
        }
    }

    @Override
    public void changeFuel(short count) {
        if (addFuel(count) < 10) {
            System.out.println("주유량이 부족하여 강제로 차고지로 이동합니다.");
            setState(STATE_GARAGE);
        }
    }


    @Override
    public void calculateCost() {
        setTotalCost(getTotalPassenger() * getCost());
    }

    @Override
    public void printInfomation() {
        System.out.println("탑승 승객 수 = " + getPassenger());
        System.out.printf("잔여 승객 수 = %d\n", RemainingPassengerCount());
        System.out.printf("요금 확인 = %d\n", getCost());
        System.out.printf("속도 = %d\n", getSpeed());
    }

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }
}
