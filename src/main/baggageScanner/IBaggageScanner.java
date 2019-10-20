package baggageScanner;

import cardReader.ProfileType;
import employees.*;

public interface IBaggageScanner {
    void moveBeltForward(int workerID);

    void moveBeltBackward(int workerID);

    boolean scan(int workerID);

    void alarm(int workerID);

    void report(int position, ProhibitedItems foundItem);

    void maintenance(int workerID);

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

    void registerUser(int id, ProfileType profileType);

    Scanner getScannerDevice();
}
