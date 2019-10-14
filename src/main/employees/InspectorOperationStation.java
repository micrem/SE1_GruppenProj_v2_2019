package employees;

import baggageScanner.OperatingStation;
import baggageScanner.Tray;


public class InspectorOperationStation extends Inspector implements iInspectorOperatingStation{
    OperatingStation assignedOS;
    public InspectorOperationStation(int pid, String pname, String pbirthDate, boolean pisSenior, OperatingStation passignedOS) {
        super(pid, pname, pbirthDate, pisSenior);
        assignedOS=passignedOS;
    }
    @Override
    public void CheckLuggage(Tray tray){
        //Methodeeeeeee
        if(true/*messer*/)
            DiscoverKnife();
        else if(true/*waffe*/)
            DiscoverGun();
        else if(true/*expl*/)
            DiscoverExplosive();
        else
            //fuck yeah
        ;
    }
    @Override
    public void LogIn(){
        //logs in
    }
    @Override
    public void PushButtonRight(){

    }
    @Override
    public void PushButtonSquare(){
        //Methode this.CheckBaggage(Tray tray);
        CheckLuggage(assignedOS.getBaggageScanner().getPlasticTray());
    }
    @Override
    public void DiscoverKnife(){
        //Methode InsMPC.ConfiscateKnife(Tray tray);
    }
    @Override
    public void DiscoverGun(){
        //Scanner sperren
        //Methode BPZ.ConfiscateGun(Tray tray);
        //noch verhaftet den Passagier
        //this.PushButtonLeft(Tray tray);
    }
    @Override
    public void DiscoverExplosive(){

    }
    @Override
    public void PushButtonLeft(){
        //InsRC.PushTray(Tray tray);
    }
}
