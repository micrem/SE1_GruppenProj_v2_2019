package BaggageScanner;

public class ManualPostControl {

    private BaggageScanner baggageScanner;

    public ManualPostControl(BaggageScanner baggageScanner){
        this.baggageScanner= baggageScanner;
        baggageScanner.setManualPostControl(this);
    }
}
