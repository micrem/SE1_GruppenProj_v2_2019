package BaggageScanner;

public class OperatingStation implements  IOperatingStation{

    private BaggageScanner baggageScanner;
    public OperatingStation(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        baggageScanner.setOperatingStation(this);
    }

    @Override
    public void buttonRight() {

    }

    @Override
    public void buttonRechteck() {

    }

    @Override
    public void buttonLeft() {

    }
}
