package baggageScanner;

public class ManualPostControl implements  IBaggageScannerStation{

    private BaggageScanner baggageScanner;
    private PlasticTray plasticTray;

    public ManualPostControl(BaggageScanner baggageScanner){
        this.baggageScanner= baggageScanner;
        //baggageScanner.setManualPostControl(this);
    }

    @Override
    public IBaggageScanner getBaggageScanner(){
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
        this.plasticTray = plasticTray;
    }
}
