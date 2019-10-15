package baggageScanner;

import cardReader.CardReader;
import cardReader.ICardReader;

public class OperatingStation implements  IOperatingStation, IBaggageScannerStation{

    private BaggageScanner baggageScanner;
    private PlasticTray plasticTray;
    private ICardReader cardReader;

    public OperatingStation(BaggageScanner baggageScanner, String keyAES){
        this.baggageScanner = baggageScanner;
        cardReader = new CardReader(keyAES);
        //baggageScanner.setOperatingStation(this);
    }

    @Override
    public ICardReader getCardReader() {
        return cardReader;
    }

    @Override
    public void buttonRight() {

    }

    @Override
    public void buttonRechteck() {

    }

    @Override
    public void buttonLeft() {

    }
    public BaggageScanner getBaggageScanner(){
        return baggageScanner;
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
        this.plasticTray =plasticTray;

    }
}
