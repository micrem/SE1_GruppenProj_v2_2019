package employees;

import baggageScanner.BaggageScanner;

public interface iFederalPoliceOfficer extends IEmployee{
    void ConfiscateGun();
    void setAssignedBaggageScanner(BaggageScanner passignedBaggageScanner);
}
