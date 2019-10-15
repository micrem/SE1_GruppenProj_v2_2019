package employees;

import baggageScanner.OperatingStation;
import baggageScanner.PlasticTray;

public interface iInspectorOperatingStation extends IEmployee{
    boolean LogIn();
    void CheckLuggage(PlasticTray plasticTray);
    void PushButtonRight();
    void PushButtonSquare();
    void DiscoverKnife();
    void DiscoverGun();
    void discoverExplosive(int position, int layerID);
    void PushButtonLeft();
    void setAssignedOS(OperatingStation passignedOS);
}
