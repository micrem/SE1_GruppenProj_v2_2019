package baggageScanner;

import cardReader.*;
import configuration.Configuration;
import employees.IInspectorOperatingStation;
import idCard.*;
import string_matching.*;

public class OperatingStation implements IOperatingStation {

    private IBaggageScanner baggageScanner;
    private ICardReader cardReader;
    private Configuration config;
    private IStringMatching string_matcher;
    private IInspectorOperatingStation inspector;

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
        if(baggageScanner.getStatusBaggerScanner()!=StatusBaggageScanner.activated){
            return;
        }
        baggageScanner.getScannerDevice().buttonRightPushed();
    }

    @Override
    public void buttonSquare() {
        if(!operatorLoggedIn) {
            System.out.println("Error: Square Button inactive, no operator logged in.");
            return;
        }
        baggageScanner.getScannerDevice().buttonSquarePushed(inspector, string_matcher);
//        String content;
//        int position;
//        if(getBaggageScanner().scan()==false) return;
//        if (plasticTray==null || plasticTray.getHandbaggage()==null) return;
//        for (int i = 0; i < 5; i++) {
//            content = plasticTray.getHandbaggage().getLayer(i).getContent();
//            position = string_matcher.search(content, ProhibitedItems.explosive.getItemString()) ;
//            if (position!=-1) {
//                System.out.println("Scanenr found explosives at:"+position+" in layer:"+i);
//                inspector.discoverExplosive(position, i);
//                return;
//            }
//        }
    }

    @Override
    public void buttonLeft() {
        baggageScanner.getScannerDevice().buttonRightPushed();
    }

    //TODO: extract basic login logic into "logInEmployee(Employee)" which also registeres employees with cardType into "registeredUsers" map
    @Override
    public boolean logInOperator(IInspectorOperatingStation inspector) {
        boolean enteredCorrectPin = false;
        ICardReader cardReader = this.getCardReader();
        inspector.insertCardIntoReader(cardReader);

        if (       cardReader.getCardType() != IDCardType.staff
                || cardReader.isCardLocked()
                || cardReader.getCardProfileType() != ProfileType.I) {
            inspector.giveCard(cardReader.ejectCard());
            return false;
        }

        while (!enteredCorrectPin) {
            enteredCorrectPin = inspector.enterPin(cardReader);
            if (cardReader.isCardLocked()) {
                inspector.giveCard(cardReader.ejectCard());
                return false;
            }
        }

        inspector.giveCard(cardReader.ejectCard());

        if (enteredCorrectPin){
            operatorLoggedIn = true;
            this.getBaggageScanner().inspectorOperationsLoggedIn();
            this.inspector = inspector;
            return true;
        }

        return false;
    }

    public IBaggageScanner getBaggageScanner() {
        return baggageScanner;
    }

}
