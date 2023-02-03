public class Taxi extends PublicTransport implements PublicTransportService {
    final String STATE_DRIVE_START = "운행";
    final String STATE_DRIVE_WAIT = "일반";
    final String STATE_DRIVE_END = "운행종료";
    final String STATE_DRIVE_FAIL = "운행불가";

    private static short number;
    String destination = "";
    int distance = 0;
    int distanceCost = 500;

    public Taxi(short MAX_FUEL, short MAX_SPEED, byte MAX_PASSENGER, int cost) {
        super(MAX_FUEL, MAX_SPEED, MAX_PASSENGER, cost);
        setState(STATE_DRIVE_WAIT);
        setNumber((short) (getNumber() + 1));
        System.out.printf("%d택시가 생성되었습니다.\n", getNumber());
    }

    @Override
    public void changePassenger(byte count) {
        if (getState().equals(STATE_DRIVE_WAIT)) {
            addPassenger(count);
            printInfomation();
        } else
            System.out.println("빈 차가 아니거나 운행 중이 아닙니다.");
    }

    @Override
    public void changeState(String state) {
        switch (state) {
            case STATE_DRIVE_START:
                if (getFuel() < 10) {
                    System.out.println("주유량이 부족하여 운행이 불가합니다.");
                } else if (getPassenger() <= 0) {
                    System.out.println("승객이 없습니다.");
                } else if (distance == 0 || destination.equals("")) {
                    System.out.println("목적지나 거리가 잘못 입력 되었습니다.");
                } else {
                    setState(STATE_DRIVE_START);
                }
                break;

            case STATE_DRIVE_WAIT:
                setState(STATE_DRIVE_WAIT);
                break;
            case STATE_DRIVE_END:
                initializeTaxi();
                System.out.println("누적 요금 : " + getTotalCost());
                setState(STATE_DRIVE_WAIT);
                break;
            case STATE_DRIVE_FAIL:
                setState(STATE_DRIVE_FAIL);
                break;
            default:
                System.out.println("제대로 된 상태를 입력해주세요.");
        }
    }

    @Override
    public void changeFuel(short count) {
        if (addFuel(count) < 10) {
            setState(STATE_DRIVE_FAIL);
        }
    }


    @Override
    public void calculateCost() {
        setTotalCost(getTotalCost() + getCost() + distance * distanceCost);
    }

    @Override
    public void printInfomation() {
        System.out.println("탑승 승객 수 = " + getPassenger());
        System.out.printf("잔여 승객 수 = %d\n", RemainingPassengerCount());
        System.out.printf("속도 = %d\n", getSpeed());
    }


    public void setDestination(String destination, int distance) {
        if (!destination.equals("")) {
            if (0 < distance) {
                this.distance = distance;
                this.destination = destination;
                calculateCost();
            } else {
                System.out.println("거리를 제대로 입력해주세요.");
            }
        } else {
            System.out.println("목적지를 제대로 입력해주세요.");
        }
        printDestination();
    }

    public void initializeTaxi() {
        this.destination = "";
        this.distance = 0;
        setPassenger((byte) 0);
    }

    public void printDestination() {
        System.out.println("목적지 : " + getDestination());
        System.out.println("목적지까지의 거리 = " + getDistance() + "km");
        System.out.println("기본요금 확인 : " + getCost());
        System.out.printf("지불할 요금 = %d\n", getCost() + distance * distanceCost);
    }

    public String getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public int getDistanceCost() {
        return distanceCost;
    }

    public void setDistanceCost(int distanceCost) {
        this.distanceCost = distanceCost;
    }

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }
}
