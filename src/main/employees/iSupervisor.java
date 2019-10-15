package employees;

import baggageScanner.WorkplaceSupervision;

public interface iSupervisor extends IEmployee{
    void BePresentByGunConfiscation();
    void UnlockDeviceInLockedStatus();
    void setAssignedWorkplaceSupervision(WorkplaceSupervision passignedWorkplaceSUpervision);
}
