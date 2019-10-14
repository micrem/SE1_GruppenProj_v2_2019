package baggageScanner;

public class WorkplaceSupervision implements IBaggageScannerStation{
    private BaggageScanner baggageScanner;

    public  WorkplaceSupervision(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        baggageScanner.setWorkplaceSupervision(this);
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
