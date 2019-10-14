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
        Tray tray1 = new Tray(this);
        RollerConveyer rollerConveyer1 = new RollerConveyer(this);
        Belt belt1 = new Belt(this);
        OperatingStation operatingStation1 = new OperatingStation(this);
        ManualPostControl manualPostControl1 = new ManualPostControl(this);
        WorkplaceSupervision workplaceSupervision1 = new WorkplaceSupervision(this);
    }

    public Tray getPlasticTray(){
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
    public void setStatusScanner() {

    }

    @Override
    public void getStatusBaggerScanner() {

    }


}
