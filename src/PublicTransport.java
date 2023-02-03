public class PublicTransport {
    private final short MAX_FUEL_TANK;
    private final byte MAX_PASSENGER;
    private final short MAX_SPEED;


    private static short number;

    private short speed = 0;
    private short fuelTank;
    private byte passenger = 0;
    private String state = "";
    private int cost = 0;
    private short totalPassenger = 0;
    private int totalCost = 0;


    public PublicTransport(short MAX_FUEL_TANK, short MAX_SPEED, byte MAX_PASSENGER, int cost) {
        this.MAX_FUEL_TANK = MAX_FUEL_TANK;
        this.fuelTank = MAX_FUEL_TANK;
        this.MAX_SPEED = MAX_SPEED;
        this.MAX_PASSENGER = MAX_PASSENGER;
        this.cost = cost;
    }

    public byte RemainingPassengerCount() {
        return (byte) (MAX_PASSENGER - passenger);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public short getTotalPassenger() {
        return totalPassenger;
    }

    public void setTotalPassenger(short totalPassenger) {
        this.totalPassenger = totalPassenger;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public short getMAX_FUEL_TANK() {
        return MAX_FUEL_TANK;
    }

    public byte getMAX_PASSENGER() {
        return MAX_PASSENGER;
    }

    public short getMAX_SPEED() {
        return MAX_SPEED;
    }

    public void printState() {
        System.out.println("상태 : " + getState());
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public short getSpeed() {
        return speed;
    }

    public void setSpeed(short speed) {
        if (0 <= this.speed + speed && this.speed + speed <= MAX_SPEED) {

            if (0 < this.fuelTank && this.fuelTank < 10) {
                System.out.println("주유량이 10미만 입니다. 주유를 해주세요.");
            }else if (this.fuelTank < 0) {
                System.out.println("주유량이 0이라 속도를 올릴 수 없습니다.");
                return;
            }
            this.speed += speed;
        } else if (this.speed + speed < 0) {
            System.out.println("속도가 최대치를 넘깁니다. 다시 입력 해주세요.");
            this.speed = 0;
        }
    }

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public short getFuelTank() {
        return fuelTank;
    }

    public short setFuelTank(short fuelTank) {
        if (0 <= this.fuelTank + fuelTank && this.fuelTank + fuelTank <= MAX_FUEL_TANK) {
            this.fuelTank += fuelTank;
        } else if (MAX_FUEL_TANK < this.fuelTank + fuelTank) {

        } else if (this.fuelTank + fuelTank < 0) {
            this.fuelTank = 0;
        }
        System.out.println("주유량 : " + this.fuelTank);
        if (this.fuelTank < 10) {
            System.out.println("주유가 필요합니다. 주유량을 확인해주세요");
        }
        return this.fuelTank;
    }


    public byte getPassenger() {
        return passenger;
    }

    public void setPassenger(byte passenger) {
        if (0 <= this.passenger + passenger && this.passenger + passenger <= MAX_PASSENGER) {
            this.passenger += passenger;
            if (0 < passenger)
                this.totalPassenger += passenger;
        } else if (this.passenger + passenger < 0) {
            this.passenger = 0;
        } else {
            System.out.println("최대 승객 수 초과");
        }
    }
}
