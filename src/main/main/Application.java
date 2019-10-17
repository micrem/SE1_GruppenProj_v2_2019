package main;

import baggageScanner.BaggageScanner;
import baggageScanner.IBaggageScanner;
import baggageScanner.PlasticTray;
import cardReader.*;
import employees.*;
import idCard.CardType;
import idCard.IDCard;
import idCard.IIDCard;
import passenger_Baggage.Gender;
import passenger_Baggage.HandBaggage;
import passenger_Baggage.Passenger;
import configuration.Configuration;
import fileReader.*;

import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

public class Application {

    private static final String keyAES = "Hallo Welt";

    public static void main(String[] args) {
        Random r = new Random();
        r.setSeed(LocalTime.now().toNanoOfDay());

        // Festlegung dea Algorithmus zur such nach verboten Gegenstaende
        Configuration config = Configuration.KnuthMorrisPratt;

        // Gepäkscännner legt seiene Objekte an
        BaggageScanner BS1 = new BaggageScanner(keyAES, config);

        String cardValidUntil = "2.2.2222";
        IIDCard tempCard;
        ICardReader cardReader = BS1.getOperatingStation().getCardReader();
        int tempPin;

        iInspectorManualPostControl inspManCtrl = new InspectorManualPostControl(IDGenerator.getID(), "Mueller", "10.10.1990", false);
            tempPin = r.nextInt(9999);
            tempCard = getCardWithPinType( cardReader, IDGenerator.getLastID(), cardValidUntil, CardType.staff, ProfileType.O,tempPin);
            inspManCtrl.giveCard(tempCard);
            inspManCtrl.giveCardPin(tempPin);

        iInspectorOperatingStation inspOpStation = new InspectorOperationStation(IDGenerator.getID(), "Mueller", "10.10.1990", false);
            tempPin = r.nextInt(9999);
            tempCard = getCardWithPinType( cardReader, IDGenerator.getLastID(), cardValidUntil, CardType.staff, ProfileType.O,tempPin);
            inspOpStation.giveCard(tempCard);
            inspOpStation.giveCardPin(tempPin);

        iInspectorRollerConveyer inspRollConv = new InspectorRollerConveyer(IDGenerator.getID(), "Mueller", "10.10.1990", false);
            tempPin = r.nextInt(9999);
            tempCard = getCardWithPinType( cardReader, IDGenerator.getLastID(), cardValidUntil, CardType.staff, ProfileType.O,tempPin);
            inspRollConv.giveCard(tempCard);
            inspRollConv.giveCardPin(tempPin);

        iSupervisor supervisor = new Supervisor(IDGenerator.getID(), "Mueller", "10.10.1990", false, true);
            tempPin = r.nextInt(9999);
            tempCard = getCardWithPinType( cardReader, IDGenerator.getLastID(), cardValidUntil, CardType.staff, ProfileType.O,tempPin);
            supervisor.giveCard(tempCard);
            supervisor.giveCardPin(tempPin);

        FederalPoliceOfficeRegis federalPoliceOfficeRegis = new FederalPoliceOfficeRegis();
        iFederalPoliceOfficer fedOfficer = new FederalPoliceOfficer(IDGenerator.getID(), "Mueller", "10.10.1990", "PolizeiPraesedent",federalPoliceOfficeRegis);
        tempPin = r.nextInt(9999);
        tempCard = getCardWithPinType( cardReader, IDGenerator.getLastID(), cardValidUntil, CardType.external, ProfileType.O,tempPin);
        fedOfficer.giveCard(tempCard);
        fedOfficer.giveCardPin(tempPin);
        federalPoliceOfficeRegis.addFederalPoliceOfficer(fedOfficer);

        iTechnician techWorker = new Technician(IDGenerator.getID(), "Mueller", "10.10.1990");
            tempPin = r.nextInt(9999);
            tempCard = getCardWithPinType( cardReader, IDGenerator.getLastID(), cardValidUntil, CardType.external, ProfileType.O,tempPin);
            techWorker.giveCard(tempCard);
            techWorker.giveCardPin(tempPin);



        PlasticTray plasticTray = new PlasticTray();

        inspManCtrl.setAssignedMPC(BS1.getManualPostControl());
        inspOpStation.setAssignedOS(BS1.getOperatingStation());
        inspRollConv.setRC(BS1.getRollerConveyer());
        supervisor.setAssignedWorkplaceSupervision(BS1.getWorkplaceSupervision());
        fedOfficer.setAssignedBaggageScanner(BS1);
        BS1.setFederalPoliceOfficer(fedOfficer);


        Map<Integer, Passenger> passengers = new HashMap<>();


        initPassengers(passengers);
        initAssignments(passengers);
        //System.out.println("Start reading baggage:"+LocalTime.now()); 17:38
        for (Passenger passenger : passengers.values()) {
            initPassengerBaggage(passenger);
        }
        //System.out.println("End reading baggage:"+LocalTime.now());
        HandBaggage testBag = passengers.get(1).getBaggageByIndex(0);

        plasticTray.setHandbaggage(testBag);

        inspOpStation.LogIn();//hier IDKarte Logik, gut gemacht

        //START OF SECURITY
        passengers.get(1).putBaggageInPlasticTray(BS1, 0);
        passengers.get(1).putPlasticTrayOnRollerConveyer(BS1);

        inspRollConv.PushTray();

        inspOpStation.PushButtonRight();
        inspOpStation.PushButtonSquare();



        System.out.println("first 50 baggage glyphs:\n\t" + testBag.getLayer(4).getContent().substring(0, 50));
        //scanner.registerInspectorManualContr(inspManCtrl);
        //read passanger data -> 2 Maps:
        //map id - passagierObject
        //map passangerID - handgepäckID

        //initialize all needed vars/classes
        //new employees+cards etc
        //new scanner
        //set scanner state
        //register users
        //start machine
        //change to "ON" state

        //ON state

    }

    private static void initPassengerBaggage(Passenger passenger) {
        int[] bagIDs = passenger.getBaggageIDs();
        for (int bagID : bagIDs) {
            IFileReader fRead = new BaggageScannerFileReader();
            try {
                String baggage_filePath = "data/hand_baggage_" + bagID + ".txt";
                String[] baggage_content = fRead.readFileToString(baggage_filePath);
                HandBaggage bag = new HandBaggage(baggage_content[0], passenger, bagID);
                passenger.addHandBaggage(bag);
            } catch (IOException e) {
                System.out.println("Baggage not found, id:'"+bagID+"'");
                //e.printStackTrace();
            }
        }

    }

    private static void initAssignments(Map<Integer, Passenger> passengers) {
        IFileReader fRead = new BaggageScannerFileReader();
        int passID;
        int[] baggageIDs = new int[3];
        int numBaggage;

        String[] assignments;
        try {
            assignments = fRead.readFileToString("data/assignment.txt");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            for (String assignment : assignments
            ) {
                //  // passenger_id;number_of_hand_baggage;hand_baggage_id(s)
                if (assignment.contains("//")) continue;
                String[] subStrs = assignment.split("[,;]");
                passID = Integer.parseInt(subStrs[0]);
                numBaggage = Integer.parseInt(subStrs[1]);
                Arrays.fill(baggageIDs, 0);
                for (int i = 0; i < numBaggage; i++) {
                    baggageIDs[i] = Integer.parseInt(subStrs[i + 2]);
                }
                if (passengers.containsKey(passID)) {
                    passengers.get(passID).setBaggageIDs(baggageIDs);
                }
            }
        } catch (NumberFormatException e1) {
            e1.printStackTrace();
        }
    }


    private static void initPassengers(Map<Integer, Passenger> passengers) {
        IFileReader fRead = new BaggageScannerFileReader();

        String[] passSubStrs;
        int passID;
        String name;
        Gender gender;
        String birthdate;
        String street;
        String city;
        String plz;
        String passport_id;

        try {
            String[] passengerStrings = fRead.readFileToString("data/passenger.txt");
            // id,name,gender,birthdate,address,passport_id
            for (String passengerString : passengerStrings) {
                if (passengerString.contains("//")) continue;

                passSubStrs = passengerString.split(",");
                if (passSubStrs.length != 8) {
                    String id = "??";
                    if (passSubStrs.length > 0) id = passSubStrs[0];
                    System.out.println("Faulty passenger data found at ID '" + id + "', discarding");
                    continue;
                }
                passID = Integer.parseInt(passSubStrs[0]);
                name = passSubStrs[1];
                gender = passSubStrs[2].equalsIgnoreCase("male") ? Gender.male : Gender.female;
                birthdate = passSubStrs[3];
                street = passSubStrs[4];
                city = passSubStrs[5];
                plz = passSubStrs[6];
                passport_id = passSubStrs[7];
                passengers.put(passID, new Passenger(passID, name, gender, birthdate, street, city, plz, passport_id));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static IIDCard getCardWithPinType(ICardReader cardReader, int id, String validUntil, CardType cardType, ProfileType profile, int pin) {
        IIDCard newCard = new IDCard(IDGenerator.getLastID(), validUntil, cardType);
        cardReader.writeTypePin(newCard, profile, pin);
        return newCard;
    }

    static class IDGenerator {
        static int id = 0;

        static int getID() {
            return id++;
        }

        static int getLastID() {
            return id;
        }
    }

}