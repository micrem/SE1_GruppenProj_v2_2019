package employees;

import baggageScanner.*;
import baggageScanner.StatusBaggageScanner;


public class InspectorOperationStation extends Inspector implements iInspectorOperatingStation{
    OperatingStation assignedOS;
    public InspectorOperationStation(int pid, String pname, String pbirthDate, boolean pisSenior) {
        super(pid, pname, pbirthDate, pisSenior);
    }
    @Override
    public void setAssignedOS(OperatingStation passignedOS){assignedOS=passignedOS;}

    @Override
    public void CheckLuggage(PlasticTray plasticTray){
        if(assignedOS.getBaggageScanner().getStatusBaggerScanner()==StatusBaggageScanner.inUse){
            if(true/*messer*/)
                DiscoverKnife();
            else if(true/*waffe*/){
                pushAlarmButton();
                DiscoverGun();}
            else if(true/*expl*/){
                pushAlarmButton();
                discoverExplosive(0, 0);}
            else
            //fuck yeah
            ;
        }
    }

    @Override
    public boolean LogIn(){
        if (this.assignedOS==null){ return false;}
        assignedOS.logInOperator(this);

        System.out.println("Inspector has logged in successfully."); //spaeter ueberschreiben mit methoden aus cardreader
        return true;
    }
    @Override
    public void PushButtonRight(){
        //TODO: Status-Logik sollte im jeweiligen Objekt (im BaggageScanner) sein, das entscheidet intern wie es auf eingaben reagiert
        if(assignedOS.getBaggageScanner().getStatusBaggerScanner()==StatusBaggageScanner.activated){
        assignedOS.putPlasticTray(assignedOS.getBaggageScanner().getBelt().peekPlasticTray());
        }else{
            System.out.println("Error 301: Scanner not in active mode.");
            System.out.println("Error 301.1: Device in " + assignedOS.getBaggageScanner().getStatusBaggerScanner()+" mode.");
        }
    }
    @Override
    public void PushButtonSquare(){
        if(assignedOS.getBaggageScanner().getStatusBaggerScanner()==StatusBaggageScanner.activated){
            assignedOS.getBaggageScanner().setStatusScanner(StatusBaggageScanner.inUse);
            CheckLuggage(assignedOS.peekPlasticTray());
        }
        else{
            System.out.println("Error 301: Scanner not in active mode.");
            System.out.println("Error 301.1: Device in " + assignedOS.getBaggageScanner().getStatusBaggerScanner()+" mode.");
        }
    }
    @Override
    public void DiscoverKnife(){
        System.out.println("Messer an der {0} Stelle gefunden");
        //Methode InsMPC.ConfiscateKnife(Tray tray);
    }
    @Override
    public void DiscoverGun(){
        System.out.println("Waffe an der {0} Stelle gefunden, Alarm!");
    }

    @Override
    public void discoverExplosive(int position, int layerID){
        System.out.println("Sprengstoff an der {0} Stelle gefunden, Alarm!");
    }
    @Override
    public void PushButtonLeft(){
        //InsRC.PushTray(Tray tray);
    }
    public void pushAlarmButton(){
        assignedOS.getBaggageScanner().alarmButtonPushed();
    }
}
