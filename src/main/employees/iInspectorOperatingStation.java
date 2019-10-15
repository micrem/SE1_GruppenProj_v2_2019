package employees;

import baggageScanner.OperatingStation;
import baggageScanner.PlasticTray;

public interface iInspectorOperatingStation extends IEmployee{
    void LogIn();
    void CheckLuggage(PlasticTray plasticTray);
    void PushButtonRight();
    void PushButtonSquare();
    void DiscoverKnife();
    void DiscoverGun();
    void DiscoverExplosive();
    void PushButtonLeft();
    void setAssignedOS(OperatingStation passignedOS);
}
