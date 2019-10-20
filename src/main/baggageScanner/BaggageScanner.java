package baggageScanner;

import cardReader.ProfileType;
import configuration.Configuration;
import employees.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

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
    private IFederalPoliceOfficer federalPoliceOfficer;
    private Scanner scannerDevice;

    private Map<Integer, ProfileType> registeredUsers;
    private Vector<Record> records;




    public BaggageScanner (String keyAES, Configuration config){
        this.status = StatusBaggageScanner.shutdown;
        trayStation = new Tray(this);
        rollerConveyer = new RollerConveyer(this);
        beltStation = new Belt(this);
        operatingStation = new OperatingStation(this, keyAES, config);
        manualPostControl = new ManualPostControl(this);
        workplaceSupervision = new WorkplaceSupervision(this);
        scannerDevice = new Scanner(this);
        registeredUsers = new HashMap<>();
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
    public void setFederalPoliceOfficer(IFederalPoliceOfficer federalPoliceOfficer){
        this.federalPoliceOfficer=federalPoliceOfficer;

    }

    @Override
    public void inspectorOperationsLoggedIn() {
        if (status == StatusBaggageScanner.shutdown) {
            status = StatusBaggageScanner.activated;
        }
    }

    @Override
    public void registerUser(int id, ProfileType profileType) {
        registeredUsers.put(id, profileType);
    }

    @Override
    public IFederalPoliceOfficer getFederalPoliceOfficer(){
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
     public void moveBeltForward(int workerID){

     }

    @Override
    public void moveBeltBackward(int workerID) {

    }

    @Override
    public boolean scan(int workerID) {
        if (status==StatusBaggageScanner.activated){
            status = StatusBaggageScanner.inUse;
            return true;
        }
        return false;
    }

    @Override
    public void alarm(int workerID) {

    }

    @Override
    public void report(int position, ProhibitedItems foundItem) {
        records.add(new Record(position,foundItem));
    }

    @Override
    public void maintenance(int workerID) {

    }

    @Override
    public void onOffButton() {
        if (this.status!=StatusBaggageScanner.shutdown){
            this.status = StatusBaggageScanner.shutdown;
        } else {
            this.status=StatusBaggageScanner.deactivated;
        }
    }

    @Override
    public void alarmButtonPushed(){
         if(this.status==StatusBaggageScanner.inUse)
            status = StatusBaggageScanner.locked;
         else
             System.out.println("Error: Scanner aktuell nicht im inUse-Modus, Alarm kann nicht ausgelöst werden.");
    }

    @Override
    public StatusBaggageScanner getStatusBaggerScanner() {
        return this.status;
    }

    @Override
    public Scanner getScannerDevice(){
        return scannerDevice;
    }
}
