package baggageScanner;

public class WorkplaceSupervision implements IBaggageScannerStation{
    private IBaggageScanner baggageScanner;
    private PlasticTray plasticTray;

    public  WorkplaceSupervision(IBaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        //baggageScanner.setWorkplaceSupervision(this);
    }

    @Override
    public PlasticTray getPlasticTray() {
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
