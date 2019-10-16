package baggageScanner;

public class Belt implements IBaggageScannerStation{
    private IBaggageScanner baggageScanner;
    private PlasticTray plasticTray;

    public Belt(IBaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        //baggageScanner.setBelt(this);

    }


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
    public void putPlasticTray(PlasticTray plasticTray) {
        this.plasticTray = plasticTray;

    }
}
