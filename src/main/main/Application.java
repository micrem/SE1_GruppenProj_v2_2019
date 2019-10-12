package main;

import BaggageScanner.BaggageScanner;
import Employees.InspectorManualPostControl;
import Employees.*;
import configuration.Configuration;

import java.net.PasswordAuthentication;

public class Application {

    public static void main(String[] args) {

        //hallosad
        // Festlegung dea Algorithmus zur such nach verboten Gegenstaende
        Configuration config  = Configuration.KnuthMorrisPratt;

        // Gepäkscännner legt seiene Objekte an
        BaggageScanner BS1=new BaggageScanner();



        //InspectorManualPostControl insMPC=new InspectorManualPostControl(1, "Mueller", "10.10.1990", true, BS1.setManualPostControl(););
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