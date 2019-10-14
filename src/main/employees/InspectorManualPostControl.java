package employees;


import baggageScanner.ManualPostControl;
public class InspectorManualPostControl extends Inspector implements iInspectorManualPostControl {
    ManualPostControl assignedMPC;

    public InspectorManualPostControl(int pid, String pname, String pbirthDate, boolean pisSenior) {
        super(pid, pname, pbirthDate, pisSenior);
    }
    public void setAssignedMPC(ManualPostControl passignedMPC){assignedMPC=passignedMPC;}
    @Override
    public void ConfiscateKnife(){
        //entfernt Messer
    }
    @Override
    public void NeutralizeExplosive(){
        //neutralisiert Sprengstoff
    }
    @Override
    public void PushBack(){
        //ddda
    }
}
