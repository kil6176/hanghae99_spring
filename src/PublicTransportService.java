public interface PublicTransportService {
    public void changePassenger(byte count);

    public void changeState(String state);

    public void changeFuel(short count);

    public void calculateCost();

    public void printInfomation();
}
