package employees;

import baggageScanner.BaggageScanner;

public interface IFederalPoliceOfficer extends IEmployee{
    void ConfiscateGun();
    void setAssignedBaggageScanner(BaggageScanner passignedBaggageScanner);
    void roboterDestroyBaggage();

}
