package employees;

import baggageScanner.WorkplaceSupervision;

public interface ISupervisor extends IEmployee{
    void BePresentByGunConfiscation();
    void UnlockDeviceInLockedStatus();
    void setAssignedWorkplaceSupervision(WorkplaceSupervision passignedWorkplaceSUpervision);
}
