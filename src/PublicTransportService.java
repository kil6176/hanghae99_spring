public interface PublicTransportService {
    public void changePassenger(byte count);

    public void changeState(String state);

    public void changeFuelTank(short count);

    public void calculateCost();
    
    public void printInfomation();
}
