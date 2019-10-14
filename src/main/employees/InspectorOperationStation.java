package employees;

import baggageScanner.OperatingStation;
import baggageScanner.PlasticTray;
import baggageScanner.Tray;


public class InspectorOperationStation extends Inspector implements iInspectorOperatingStation{
    OperatingStation assignedOS;
    public InspectorOperationStation(int pid, String pname, String pbirthDate, boolean pisSenior) {
        super(pid, pname, pbirthDate, pisSenior);
    }
    @Override
    public void setAssignedOS(OperatingStation passignedOS){assignedOS=passignedOS;}
    @Override
    public void CheckLuggage(PlasticTray plasticTray){
        //Methodeeeeeee
        if(true/*messer*/)
            DiscoverKnife();
        else if(true/*waffe*/){
            pushAlarmButton();
            DiscoverGun();}
        else if(true/*expl*/){
            pushAlarmButton();
            DiscoverExplosive();}
        else
            //fuck yeah
        ;
    }

    @Override
    public void LogIn(){
        System.out.println("Inspector has logged in successfully."); //spaeter ueberschreiben mit methoden aus cardreader
    }
    @Override
    public void PushButtonRight(){
        assignedOS.putPlasticTray(assignedOS.getBaggageScanner().getBelt().getPlasticTray());
    }
    @Override
    public void PushButtonSquare(){
        //Methode this.CheckBaggage(Tray tray);
        CheckLuggage(assignedOS.getPlasticTray());
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
    public void DiscoverExplosive(){
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
