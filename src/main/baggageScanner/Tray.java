package baggageScanner;

public class Tray implements IBaggageScannerStation{
    //plasticTray station
    private BaggageScanner baggageScanner;
    private PlasticTray plasticTray;

    @Override
    public PlasticTray getPlasticTray() {
        PlasticTray tempBaggage = this.plasticTray;
        this.plasticTray = null;
        return tempBaggage;
    }

    @Override
    public void putPlasticTray(PlasticTray plasticTray) {

    }

    public void setPlasticTray(PlasticTray plasticTray) {
        this.plasticTray = plasticTray;
    }

    public Tray(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        baggageScanner.setTray(this);
    }
}