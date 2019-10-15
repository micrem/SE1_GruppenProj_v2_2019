package baggageScanner;

import cardReader.*;
import employees.IEmployee;
import idCard.*;

public class OperatingStation implements IOperatingStation, IBaggageScannerStation {

    private IBaggageScanner baggageScanner;
    private PlasticTray plasticTray;
    private ICardReader cardReader;

    private boolean operatorLoggedIn = false;

    public OperatingStation(IBaggageScanner baggageScanner, String keyAES) {
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

    @Override
    public boolean logInOperator(IEmployee employee) {
        boolean enteredCorrectPin = false;
        ICardReader cardReader = this.getCardReader();
        employee.insertCardIntoReader(cardReader);

        if (       cardReader.getCardType() != CardType.staff
                || cardReader.isCardLocked()
                || cardReader.getCardProfileType() != ProfileType.I) {
            employee.giveCard(cardReader.ejectCard());
            return false;
        }

        while (!enteredCorrectPin) {
            enteredCorrectPin = employee.enterPin(cardReader);
            if (cardReader.isCardLocked()) {
                employee.giveCard(cardReader.ejectCard());
                return false;
            }
        }

        employee.giveCard(cardReader.ejectCard());

        if (enteredCorrectPin){
            operatorLoggedIn = true;
            this.getBaggageScanner().inspectorOperationsLoggedIn();
            return true;
        }

        return false;
    }

    @Override
    public IBaggageScanner getBaggageScanner() {
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
        this.plasticTray = plasticTray;

    }
}
