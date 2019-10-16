package baggageScanner;

public class Tray implements IBaggageScannerStation{
    //plasticTray station
    private IBaggageScanner baggageScanner;
    private PlasticTray plasticTray;

    @Override
    public PlasticTray peekPlasticTray() {
        return plasticTray;
    }

    @Override
    public IBaggageScanner getBaggageScanner() {
        return baggageScanner;
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

    public Tray(IBaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        plasticTray=new PlasticTray();
    }
}
