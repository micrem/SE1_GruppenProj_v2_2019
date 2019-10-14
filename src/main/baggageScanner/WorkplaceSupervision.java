package baggageScanner;

public class WorkplaceSupervision implements IBaggageScannerStation{
    private BaggageScanner baggageScanner;
    private PlasticTray plasticTray;

    public  WorkplaceSupervision(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        //baggageScanner.setWorkplaceSupervision(this);
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
