package BaggageScanner;

public class ManualPostControl {

    private BaggageScanner baggageScanner;

    public ManualPostControl(BaggageScanner baggageScanner){
        this.baggageScanner= baggageScanner;
        baggageScanner.setManualPostControl(this);
    }
    public BaggageScanner getBaggageScanner(){
        return baggageScanner;
    }
}
