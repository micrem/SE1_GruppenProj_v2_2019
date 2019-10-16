package baggageScanner;

import employees.*;

public interface IBaggageScanner {
    void moveBeltForward();
    void moveBeltBackward();
    boolean scan();
    void alarm();
    void report();
    void maintenance();
    void onOffButton();
    void setStatusScanner(StatusBaggageScanner newStatus);
    StatusBaggageScanner getStatusBaggerScanner();
    void alarmButtonPushed();

    Tray getTray();

    RollerConveyer getRollerConveyer();

    Belt getBelt();

    OperatingStation getOperatingStation();

    ManualPostControl getManualPostControl();

    WorkplaceSupervision getWorkplaceSupervision();

    void setFederalPoliceOfficer(iFederalPoliceOfficer federalPoliceOfficer);

    iFederalPoliceOfficer getFederalPoliceOfficer();

    void inspectorOperationsLoggedIn();
}
