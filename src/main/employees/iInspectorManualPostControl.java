package employees;

import baggageScanner.ManualPostControl;

public interface iInspectorManualPostControl extends IEmployee{
    void ConfiscateKnife();
    void NeutralizeExplosive();
    void PushBack();
    void setAssignedMPC(ManualPostControl passignedMPC);
}
