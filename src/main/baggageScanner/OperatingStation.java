package baggageScanner;

public class OperatingStation implements  IOperatingStation, IBaggageScannerStation{

    private BaggageScanner baggageScanner;
    private PlasticTray plasticTray;
    public OperatingStation(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        //baggageScanner.setOperatingStation(this);
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
    public PlasticTray getPlasticTray() {
        return plasticTray;
    }

    @Override
    public PlasticTray removePlasticTray() {
        PlasticTray tempBaggage = this.plasticTray;
        this.plasticTray = null;
        return tempBaggage;
    }

    @Override
    public void putPlasticTray(PlasticTray plasticTray) {
        this.plasticTray =plasticTray;

    }
}
