package employees;

import baggageScanner.RollerConveyer;

public class InspectorRollerConveyer extends Inspector implements iInspectorRollerConveyer {


    RollerConveyer assignedConveyer;


    public InspectorRollerConveyer(int pid, String pname, String pbirthDate, boolean pisSenior, RollerConveyer passignedConveyer) {
        super(pid, pname, pbirthDate, pisSenior);
        assignedConveyer = passignedConveyer;
    }

    @Override
    public void PushTray() {
        if (assignedConveyer.getBaggageScanner().getTray() != null) {
            //assignedConveyer.moveTrayToScannerConveyer(assignedConveyer.getBaggageScanner().getTray());
            //Methode existiert (noch) nicht
        }
    }
}