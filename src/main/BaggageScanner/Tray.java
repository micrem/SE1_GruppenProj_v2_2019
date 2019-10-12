package BaggageScanner;

public class Tray {
    private BaggageScanner baggageScanner;

    public Tray(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        baggageScanner.setTray(this);

    }

}
