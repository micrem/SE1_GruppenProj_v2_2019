package baggageScanner;

public class ManualPostControl implements  IBaggageScannerStation{

    private BaggageScanner baggageScanner;
    private PlasticTray plasticTray;

    public ManualPostControl(BaggageScanner baggageScanner){
        this.baggageScanner= baggageScanner;
        baggageScanner.setManualPostControl(this);
    }
    public BaggageScanner getBaggageScanner(){
        return baggageScanner;
    }

    @Override
    public PlasticTray removePlasticTray() {
        return plasticTray;
    }

    @Override
    public PlasticTray getPlasticTray() {
        PlasticTray tempBaggage = this.plasticTray;
        this.plasticTray = null;
        return tempBaggage;

    }

    @Override
    public void putPlasticTray(PlasticTray plasticTray) {
        this.plasticTray = plasticTray;
    }
}
