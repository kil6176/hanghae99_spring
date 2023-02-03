public class Car {
    private final short NAX_FUEL_TANK;
    private final short MAX_SPEED;
    private final byte MAX_PASSENGER;
    short speed = 0;
    short number = 0;
    short fuelTank = 0;

    byte state = -1;
    byte passenger = 0;

    public Car(short NAX_FUEL_TANK, short MAX_SPEED, byte MAX_PASSENGER) {
        this.NAX_FUEL_TANK = NAX_FUEL_TANK;
        this.MAX_SPEED = MAX_SPEED;
        this.MAX_PASSENGER = MAX_PASSENGER;
    }

    public short getSpeed() {
        return speed;
    }

    public void setSpeed(short speed) {
        this.speed = speed;
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

    public void setFuelTank(short fuelTank) {
        this.fuelTank = fuelTank;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public byte getPassenger() {
        return passenger;
    }

    public void setPassenger(byte passenger) {
        this.passenger = passenger;
    }
}
