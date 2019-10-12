package Employees;


public class FederalPoliceOfficer extends Employee implements iFederalPoliceOfficer{

    public FederalPoliceOfficer(int pid, String pname, String pbirthDate) {
        super(pid, pname, pbirthDate);
    }
    @Override
    public void ConfiscateGun(){}
}