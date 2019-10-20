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

    StatusBaggageScanner getStatusBaggerScanner();

    void alarmButtonPushed();

    Tray getTray();

    RollerConveyer getRollerConveyer();

    Belt getBelt();

    OperatingStation getOperatingStation();

    ManualPostControl getManualPostControl();

    WorkplaceSupervision getWorkplaceSupervision();

    void setFederalPoliceOfficer(IFederalPoliceOfficer federalPoliceOfficer);

    IFederalPoliceOfficer getFederalPoliceOfficer();

    void inspectorOperationsLoggedIn();

    Scanner getScannerDevice();
}
