package BaggageScanner;


import java.util.Map;

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

    public void setTray(Tray tray){
        //if state = passend
        this.tray = tray;
        //else: do nothing;
    }

    public void setRollerConveyer(RollerConveyer rollerConveyer){
        this.rollerConveyer = rollerConveyer;
    }

    public void setBelt(Belt belt){
        this.belt = belt;
    }

    public void setOperatingStation(OperatingStation operatingStation){
        this.operatingStation = operatingStation;
    }

     public void setManualPostControl(ManualPostControl manualPostControl){
        this.manualPostControl = manualPostControl;
     }

     public void setWorkplaceSupervision (WorkplaceSupervision workplaceSupervision){
        this.workplaceSupervision = workplaceSupervision;
     }





}
