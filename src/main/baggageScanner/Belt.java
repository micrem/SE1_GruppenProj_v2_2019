package baggageScanner;

public class Belt implements IBaggageScannerStation{
    private BaggageScanner baggageScanner;
    private PlasticTray plasticTray;

    public Belt(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        //baggageScanner.setBelt(this);

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
