package baggageScanner;

import employees.FederalPoliceOfficer;

public interface IBaggageScanner {
    void moveBeltForward();
    void moveBeltBackward();
    void scan();
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

    void setFederalPoliceOfficer(FederalPoliceOfficer federalPoliceOfficer);

    FederalPoliceOfficer getFederalPoliceOfficer();

    void inspectorOperationsLoggedIn();
}
