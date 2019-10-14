package employees;


import baggageScanner.BaggageScanner;

public class FederalPoliceOfficer extends Employee implements iFederalPoliceOfficer{
    BaggageScanner assignedBaggageScanner;
    public FederalPoliceOfficer(int pid, String pname, String pbirthDate) {
        super(pid, pname, pbirthDate);
    }
    @Override
    public void ConfiscateGun(){}
    @Override
    public void setAssignedBaggageScanner(BaggageScanner passignedBaggageScanner){
        assignedBaggageScanner=passignedBaggageScanner;
    }
}

