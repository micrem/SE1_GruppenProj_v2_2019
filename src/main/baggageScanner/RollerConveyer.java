package baggageScanner;

public class RollerConveyer implements  IBaggageScannerStation{
    private BaggageScanner baggageScanner;

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
