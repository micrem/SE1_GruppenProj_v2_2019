package employees;

import baggageScanner.*;


public class InspectorOperationStation extends Inspector implements IInspectorOperatingStation {
    OperatingStation assignedOS;
    public InspectorOperationStation(int pid, String pname, String pbirthDate, boolean pisSenior) {
        super(pid, pname, pbirthDate, pisSenior);
    }
    @Override
    public void setAssignedOS(OperatingStation passignedOS){assignedOS=passignedOS;}


    @Override
    public boolean LogIn(){
        if (this.assignedOS==null){ return false;}
        assignedOS.logInOperator(this);

        System.out.println("Inspector has logged in successfully."); //spaeter ueberschreiben mit methoden aus cardreader
        return true;
    }
    @Override
    public void PushButtonRight(){
        assignedOS.buttonRight();
    }
    @Override
    public void PushButtonSquare(){
        assignedOS.buttonSquare();
    }
    @Override
    public void discoverKnife(int position, int layerID){
        System.out.println("Messer an der Stelle" + position + " in layer "+layerID +" gefunden!");
        //Methode InsMPC.ConfiscateKnife(Tray tray);
    }
    @Override
    public void discoverGun(int position, int layerID){
        System.out.println("Waffe an der Stelle" + position + " in layer "+layerID +" gefunden, Alarm!");
    }

    @Override
    public void discoverExplosive(int position, int layerID){
        System.out.println("Sprengstoff an der Stelle" + position + " in layer "+layerID +" gefunden, Alarm!");
    }
    @Override
    public void PushButtonLeft(){
        assignedOS.buttonLeft();
    }
    public void pushAlarmButton(){
        assignedOS.getBaggageScanner().alarmButtonPushed();
    }
}
