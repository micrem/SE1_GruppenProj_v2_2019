package employees;

import baggageScanner.RollerConveyer;

public interface iInspectorRollerConveyer extends IEmployee{
    void PushTray();
    void setRC(RollerConveyer passignedRC);
}
