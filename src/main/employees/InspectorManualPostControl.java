package employees;


import baggageScanner.ManualPostControl;
public class InspectorManualPostControl extends Inspector implements iInspectorManualPostControl {
    ManualPostControl assignedMPC;

    public InspectorManualPostControl(int pid, String pname, String pbirthDate, boolean pisSenior) {
        super(pid, pname, pbirthDate, pisSenior);
    }

    @Override
    public void setAssignedMPC(ManualPostControl passignedMPC){assignedMPC=passignedMPC;}
    @Override
    public void ConfiscateKnife(){
        //entfernt Messer
    }
    @Override
    public void NeutralizeExplosive(){


        // wenn Wüschtest erfolgreich ist --> Gepäck zerstören
        assignedMPC.getBaggageScanner().getFederalPoliceOfficer().federalPoliceOfficeRegis.getRoboter()[0].destroyBaggage();
    }
    @Override
    public void PushBack(){
        //ddda
    }
}
