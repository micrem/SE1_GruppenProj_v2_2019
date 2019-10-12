package BaggageScanner;

public class RollerConveyer {
    private BaggageScanner baggageScanner;

    public RollerConveyer(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        baggageScanner.setRollerConveyer(this);
    }
}
