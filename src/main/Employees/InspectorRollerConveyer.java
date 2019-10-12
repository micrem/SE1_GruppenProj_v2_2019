package Employees;

import BaggageScanner.RollerConveyer;



public class InspectorRollerConveyer extends Inspector implements iInspectorRollerConveyer{

    RollerConveyer assignedConveyer;
    public void ExecutePush(){
        //this.assignedConveyer.push(); //doesnt exist yet
    }

    public InspectorRollerConveyer(int pid, String pname, String pbirthDate, boolean pisSenior, RollerConveyer passignedConveyer) {
        super(pid, pname, pbirthDate, pisSenior);
        assignedConveyer=passignedConveyer;
    }
    @Override
    public void Push(){}

}
