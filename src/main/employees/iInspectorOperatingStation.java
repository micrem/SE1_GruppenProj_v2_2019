package employees;

import baggageScanner.Tray;

public interface iInspectorOperatingStation {
    void LogIn();
    void CheckLuggage(Tray tray);
    void PushButtonRight();
    void PushButtonSquare();
    void DiscoverKnife();
    void DiscoverGun();
    void DiscoverExplosive();
    void PushButtonLeft();
}
