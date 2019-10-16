package baggageScanner;

import cardReader.*;
import configuration.Configuration;
import employees.iInspectorOperatingStation;
import idCard.*;
import string_matching.*;

public class OperatingStation implements IOperatingStation, IBaggageScannerStation {

    private IBaggageScanner baggageScanner;
    private PlasticTray plasticTray;
    private ICardReader cardReader;
    private Configuration config;
    private IStringMatching string_matcher;
    private iInspectorOperatingStation inspector;

    private boolean operatorLoggedIn = false;

    public OperatingStation(IBaggageScanner baggageScanner, String keyAES, Configuration config) {
        this.baggageScanner = baggageScanner;
        this.config = config;
        switch (config){
            case KnuthMorrisPratt:
                string_matcher = new KnuthMorrisPratt();
                break;
            case BoyerMoore:
                string_matcher = new BoyerMoore();
                break;
            default:
                string_matcher = new BruteForce();
        }
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
        String content;
        int position;
        if(getBaggageScanner().scan()==false) return;
        if (plasticTray==null || plasticTray.getHandbaggage()==null) return;
        for (int i = 0; i < 5; i++) {
            content = plasticTray.getHandbaggage().getLayer(i).getContent();
            position = string_matcher.search(content, ProhibitedItems.explosive.getItemString()) ;
            if (position!=-1) {
                System.out.println("Scanenr found explosives at:"+position+" in layer:"+i);
                inspector.discoverExplosive(position, i);
                return;
            }
        }
    }

    @Override
    public void buttonLeft() {

    }

    @Override
    public boolean logInOperator(iInspectorOperatingStation employee) {
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
    public PlasticTray peekPlasticTray() {
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
