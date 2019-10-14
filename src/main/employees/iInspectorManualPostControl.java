package employees;

import baggageScanner.ManualPostControl;

public interface iInspectorManualPostControl {
    void ConfiscateKnife();
    void NeutralizeExplosive();
    void PushBack();
    void setAssignedMPC(ManualPostControl passignedMPC);
}
