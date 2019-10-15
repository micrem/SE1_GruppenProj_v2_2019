package employees;


import baggageScanner.WorkplaceSupervision;
import idCard.*;

public class Supervisor extends Employee implements iSupervisor{
    private boolean isSenior;
    private boolean isExecutive;
    private IIDCard idCard;
    WorkplaceSupervision assignedWorkplaceSupervision;

    public Supervisor(int pid, String pname, String pbirthDate, boolean pisSenior, boolean pisExecutive) {
        super(pid, pname, pbirthDate);
        isSenior=pisSenior;
        isExecutive=pisExecutive;
        String validUntil = "2.2.2222";
        idCard = new IDCard(pid, validUntil, CardType.staff);

    }
    @Override
    public void setAssignedWorkplaceSupervision(WorkplaceSupervision passignedWorkplaceSUpervision){
        assignedWorkplaceSupervision=passignedWorkplaceSUpervision;
    }
    @Override
    public void BePresentByGunConfiscation(){}
    @Override
    public void UnlockDeviceInLockedStatus(){}
}