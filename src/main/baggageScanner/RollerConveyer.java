package baggageScanner;

public class RollerConveyer implements  IBaggageScannerStation{
    private BaggageScanner baggageScanner;
    private PlasticTray plasticTray;

    public RollerConveyer(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        baggageScanner.setRollerConveyer(this);
    }

    public BaggageScanner getBaggageScanner(){
        return baggageScanner;
    }
    public void MoveTrayToConveyerBelt(){

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
