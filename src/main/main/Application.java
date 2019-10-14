package main;

import baggageScanner.BaggageScanner;
import employees.*;
import passenger_Baggage.Gender;
import passenger_Baggage.HandBaggage;
import passenger_Baggage.Passenger;
import configuration.Configuration;
import fileReader.*;

import java.io.IOException;
import java.util.*;

public class Application {

    public static void main(String[] args) {

        String AESkey = "Hallo Welt";

        //hallosad
        // Festlegung dea Algorithmus zur such nach verboten Gegenstaende
        Configuration config  = Configuration.KnuthMorrisPratt;

        // Gepäkscännner legt seiene Objekte an
        BaggageScanner BS1 = new BaggageScanner();

        Map<Integer, Passenger> passengers = new HashMap<>();

        initPassengers(passengers);
        initAssignments(passengers);
        initPassengerBaggage(passengers.get(1));

        HandBaggage testBag = passengers.get(1).getBaggageByIndex(0);

        System.out.println(testBag.getLayer(4).getContent().substring(0,50));


        iInspectorManualPostControl inspManCtrl= new InspectorManualPostControl(1, "Mueller", "10.10.1990",false);
        iInspectorOperatingStation inspOpStation = new InspectorOperationStation(1, "Mueller", "10.10.1990",false);
        iInspectorRollerConveyer inspRollConv = new InspectorRollerConveyer(1, "Mueller", "10.10.1990",false);
        iSupervisor supervisor = new Supervisor(1, "Mueller", "10.10.1990",false, true);
        iFederalPoliceOfficer fedOfficer = new FederalPoliceOfficer(1, "Mueller", "10.10.1990");
        iTechnician techWorker = new Technician(1, "Mueller", "10.10.1990");

        for (int i = 0; i < 10; i++) {
            System.out.println(IDGenerator.getID());
        }

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
        for (int i=0;i<bagIDs.length;i++){
            IFileReader fRead = new BaggageScannerFileReader();
            int passID;
            int[] baggageIDs = new int[3];
            int numBaggage;

            try {
                String baggage_filePath = "data/hand_baggage_"+bagIDs[i]+".txt";
                String[] baggage_content = fRead.readFileToString(baggage_filePath);
                    HandBaggage bag = new HandBaggage(baggage_content[0]);
                    passenger.addHandBaggage(bag);
            } catch (IOException e) {
                e.printStackTrace();
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
                passID = Integer.valueOf(subStrs[0]);
                numBaggage = Integer.valueOf(subStrs[1]);
                Arrays.fill(baggageIDs, 0);
                for (int i = 0; i < numBaggage; i++) {
                    baggageIDs[i] = Integer.valueOf(subStrs[i + 2]);
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
            for (String passengerString: passengerStrings
            ) {
                if (passengerString.contains("//")) continue;

                passSubStrs = passengerString.split(",");
                if(passSubStrs.length!=8){
                    String id = "??";
                    if (passSubStrs.length>0) id=passSubStrs[0];
                    System.out.println("Faulty passenger data found at ID '"+id+"', discarding");
                    continue;
                }
                passID = Integer.valueOf(passSubStrs[0]);
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


    static class IDGenerator {
        static int id = 0;
        static int getID(){
            return id++;
        }
    }

}



/*  DELET THIS

    BaggageScanner scannerA = new BaggageScanner();

    Passagier passagier1 = new Passagier();

    passagier1.putBaggageInTray(scannerA );


    loop passagiersArray into passagier
            passagier.putBaggageInTray(checkpoint);
    end loop;


    checkpoint.checkPassagiers(passagierArray);

    InterfaceScanner scanner = new BaggageScanner();

    scanner.*/