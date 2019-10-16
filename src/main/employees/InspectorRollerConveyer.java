package employees;

import baggageScanner.StatusBaggageScanner;
import baggageScanner.RollerConveyer;

public class InspectorRollerConveyer extends Inspector implements iInspectorRollerConveyer {


    RollerConveyer assignedConveyer;


    public InspectorRollerConveyer(int pid, String pname, String pbirthDate, boolean pisSenior) {
        super(pid, pname, pbirthDate, pisSenior);
    }
    @Override
    public void setRC(RollerConveyer passignedRC){assignedConveyer=passignedRC;}

    @Override
    public void PushTray() {
        if(assignedConveyer.getBaggageScanner().getStatusBaggerScanner()==StatusBaggageScanner.activated){
        assignedConveyer.getBaggageScanner().getBelt().putPlasticTray(assignedConveyer.removePlasticTray());}
        else{
            System.out.println("Error 301: Scanner not in active mode.");
        }
    }
}