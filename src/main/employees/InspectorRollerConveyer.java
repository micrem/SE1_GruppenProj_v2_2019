package employees;

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
        if (assignedConveyer.getBaggageScanner().getPlasticTray() != null) {
            //assignedConveyer.moveTrayToScannerConveyer(assignedConveyer.getBaggageScanner().getPlasticTray());
            //Methode existiert (noch) nicht
        }
    }
}