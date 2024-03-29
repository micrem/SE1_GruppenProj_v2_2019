package employees;

import baggageScanner.BaggageScanner;
import baggageScanner.IBaggageScanner;

public interface IFederalPoliceOfficer extends IEmployee{
    void ConfiscateGun();
    void setAssignedBaggageScanner(BaggageScanner passignedBaggageScanner);
    void roboterDestroyBaggage();
    FederalPoliceOfficeRegis getFederalPoliceOfficeRegis();
    IBaggageScanner getAssignedBaggageScanner();
}
