package baggageScanner;

public class BaggageScanner implements IBaggageScanner {
    private StatusBaggageScanner status;
    private ProhibitedItems verbotendeGegen;

    // fuer eins zu eins verkuepfung
    private Tray tray;
    private RollerConveyer rollerConveyer;
    private Belt belt;
    private OperatingStation operatingStation;
    private ManualPostControl manualPostControl;
    private WorkplaceSupervision workplaceSupervision;



    public BaggageScanner (){
        this.status = StatusBaggageScanner.shutdown;
        tray = new Tray(this);
        rollerConveyer = new RollerConveyer(this);
        belt = new Belt(this);
        operatingStation = new OperatingStation(this);
        manualPostControl = new ManualPostControl(this);
        workplaceSupervision = new WorkplaceSupervision(this);
    }

    public Tray getTray(){
        return tray;
    }

    public RollerConveyer getRollerConveyer() {
        return rollerConveyer;
    }

    public Belt getBelt() {
        return belt;
    }

    public OperatingStation getOperatingStation() {
        return operatingStation;
    }

    public ManualPostControl getManualPostControl() {
        return manualPostControl;
    }

    public WorkplaceSupervision getWorkplaceSupervision() {
        return workplaceSupervision;
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

     public void moveBellForward(){

     }

    @Override
    public void moveBeltBackward() {

    }

    @Override
    public void scan() {

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

    }

    @Override
    public void setStatusScanner(StatusBaggageScanner newStatus) {
         this.status=newStatus;
    }
    @Override
    public void alarmButtonPushed(){
         if(this.status==StatusBaggageScanner.inUse)
            setStatusScanner(StatusBaggageScanner.locked);
         else
             System.out.println("Error: Scanner aktuell nicht im inUse-Modus");
    }

    @Override
    public StatusBaggageScanner getStatusBaggerScanner() {
        return this.status;
    }


}
