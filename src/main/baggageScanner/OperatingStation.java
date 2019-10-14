package baggageScanner;

public class OperatingStation implements  IOperatingStation, IBaggageScannerStation{

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
    public BaggageScanner getBaggageScanner(){
        return baggageScanner;
    }

    @Override
    public PlasticTray removePlasticTray() {
        return null;
    }

    @Override
    public PlasticTray getPlasticTray() {
        return null;
    }

    @Override
    public void putPlasticTray(PlasticTray plasticTray) {

    }
}
