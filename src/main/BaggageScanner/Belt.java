package BaggageScanner;

public class Belt {
    private BaggageScanner baggageScanner;

    public Belt(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        baggageScanner.setBelt(this);

    }
}
