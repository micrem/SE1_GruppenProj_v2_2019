package employees;

import baggageScanner.RollerConveyer;

public interface IInspectorRollerConveyer extends IEmployee{
    void PushTray();
    void setRC(RollerConveyer passignedRC);
}
