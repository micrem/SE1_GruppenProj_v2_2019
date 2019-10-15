package employees;

import baggageScanner.IBaggageScanner;
import baggageScanner.OperatingStation;
import baggageScanner.PlasticTray;

public interface iInspectorOperatingStation extends IEmployee{
    boolean LogIn();
    void CheckLuggage(PlasticTray plasticTray);
    void PushButtonRight();
    void PushButtonSquare();
    void DiscoverKnife();
    void DiscoverGun();
    void DiscoverExplosive();
    void PushButtonLeft();
    void setAssignedOS(OperatingStation passignedOS);
}
