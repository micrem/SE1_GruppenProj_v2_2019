package employees;


public class Supervisor extends Employee implements iSupervisor{
    private boolean isSenior;
    private boolean isExecutive;

    public Supervisor(int pid, String pname, String pbirthDate, boolean pisSenior, boolean pisExecutive) {
        super(pid, pname, pbirthDate);
        isSenior=pisSenior;
        isExecutive=pisExecutive;
    }
    @Override
    public void BePresentByGunConfiscation(){}
    @Override
    public void UnlockDeviceInLockedStatus(){};
}