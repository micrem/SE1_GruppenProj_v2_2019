package baggageScanner;

import configuration.Configuration;
import employees.*;

public class BaggageScanner implements IBaggageScanner {
    private StatusBaggageScanner status;
    private ProhibitedItems prohibitedItems;

    // fuer eins zu eins verkuepfung
    private Tray trayStation;
    private RollerConveyer rollerConveyer;
    private Belt beltStation;
    private OperatingStation operatingStation;
    private ManualPostControl manualPostControl;
    private WorkplaceSupervision workplaceSupervision;
    private iFederalPoliceOfficer federalPoliceOfficer;





    public BaggageScanner (String keyAES, Configuration config){
        this.status = StatusBaggageScanner.shutdown;
        trayStation = new Tray(this);
        rollerConveyer = new RollerConveyer(this);
        beltStation = new Belt(this);
        operatingStation = new OperatingStation(this, keyAES, config);
        manualPostControl = new ManualPostControl(this);
        workplaceSupervision = new WorkplaceSupervision(this);
    }

    @Override
    public Tray getTray(){
        return trayStation;
    }

    @Override
    public RollerConveyer getRollerConveyer() {
        return rollerConveyer;
    }

    @Override
    public Belt getBelt() {
        return beltStation;
    }

    @Override
    public OperatingStation getOperatingStation() {
        return operatingStation;
    }

    @Override
    public ManualPostControl getManualPostControl() {
        return manualPostControl;
    }

    @Override
    public WorkplaceSupervision getWorkplaceSupervision() {
        return workplaceSupervision;
    }

    @Override
    public void setFederalPoliceOfficer(iFederalPoliceOfficer federalPoliceOfficer){
        this.federalPoliceOfficer=federalPoliceOfficer;

    }

    @Override
    public void inspectorOperationsLoggedIn() {
        if (status == StatusBaggageScanner.shutdown) {
            status = StatusBaggageScanner.activated;
        }
    }

    @Override
    public iFederalPoliceOfficer getFederalPoliceOfficer(){
        return federalPoliceOfficer;
    }

    /*    public void setRollerConveyer(RollerConveyer rollerConveyer){
        this.rollerConveyer = rollerConveyer;
    }

    public void setBelt(Belt belt){
        this.belt = belt;
    }

    public void setTray(Tray tray){
        this.tray = tray;
    }

    public void setOperatingStation(OperatingStation operatingStation){
        this.operatingStation = operatingStation;
    }

     public void setManualPostControl(ManualPostControl manualPostControl){
        this.manualPostControl = manualPostControl;
     }

     public void setWorkplaceSupervision (WorkplaceSupervision workplaceSupervision){
        this.workplaceSupervision = workplaceSupervision;
     }*/

    @Override
     public void moveBeltForward(){

     }

    @Override
    public void moveBeltBackward() {

    }

    @Override
    public boolean scan() {
        if (status==StatusBaggageScanner.activated){
            status = StatusBaggageScanner.inUse;
            return true;
        }
        return false;
    }

    @Override
    public void alarm() {

    }

    @Override
    public void report() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public void onOffButton() {
        //todo: add on/off logic, change state
    }

    @Override
    public void alarmButtonPushed(){
         if(this.status==StatusBaggageScanner.inUse)
            status = StatusBaggageScanner.locked;
         else
             System.out.println("Error: Scanner aktuell nicht im inUse-Modus");
    }

    @Override
    public StatusBaggageScanner getStatusBaggerScanner() {
        return this.status;
    }


}
