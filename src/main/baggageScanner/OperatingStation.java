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
    public boolean logInOperator(IInspectorOperatingStation employee) {
        boolean enteredCorrectPin = false;
        ICardReader cardReader = this.getCardReader();
        employee.insertCardIntoReader(cardReader);

        if (       cardReader.getCardType() != IDCardType.staff
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

    public IBaggageScanner getBaggageScanner() {
        return baggageScanner;
    }

}
