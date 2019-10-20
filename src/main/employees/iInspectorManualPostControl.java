package employees;

import baggageScanner.ManualPostControl;

public interface IInspectorManualPostControl extends IEmployee{
    void ConfiscateKnife();
    void NeutralizeExplosive();
    void PushBack();
    void setAssignedMPC(ManualPostControl passignedMPC);
}
