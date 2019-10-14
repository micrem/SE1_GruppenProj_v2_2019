package baggageScanner;

public class Tray implements IBaggageScannerStation{
    //plasticTray station
    private BaggageScanner baggageScanner;
    private PlasticTray plasticTray;

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
    public void putPlasticTray(PlasticTray pplasticTray) {


        this.plasticTray = pplasticTray;
    }

    public Tray(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
    }
}
