package employees;

import baggageScanner.OperatingStation;
import baggageScanner.PlasticTray;

public interface IInspectorOperatingStation extends IEmployee{
    boolean LogIn();
    void PushButtonRight();
    void PushButtonSquare();
    void discoverKnife(int position, int layerID);
    void discoverGun(int position, int layerID);
    void discoverExplosive(int position, int layerID);
    void PushButtonLeft();
    void setAssignedOS(OperatingStation passignedOS);
}
