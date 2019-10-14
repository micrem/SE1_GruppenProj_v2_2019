package baggageScanner;

public class ManualPostControl implements  IBaggageScannerStation{

    private BaggageScanner baggageScanner;

    public ManualPostControl(BaggageScanner baggageScanner){
        this.baggageScanner= baggageScanner;
        baggageScanner.setManualPostControl(this);
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
