package baggageScanner;

public class Belt implements IBaggageScannerStation{
    private BaggageScanner baggageScanner;

    public Belt(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        baggageScanner.setBelt(this);

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
