package employees;


import baggageScanner.BaggageScanner;

public class FederalPoliceOfficer extends Employee implements iFederalPoliceOfficer{
    BaggageScanner assignedBaggageScanner;
    String grade;
    FederalPoliceOfficeRegis federalPoliceOfficeRegis;
    public FederalPoliceOfficer(int pid, String pname, String pbirthDate, String grade)
    {
        super(pid, pname, pbirthDate);
        this.grade= grade;
    }
    @Override
    public void ConfiscateGun(){}
    @Override
    public void setAssignedBaggageScanner(BaggageScanner passignedBaggageScanner){
        assignedBaggageScanner=passignedBaggageScanner;
    }

    public void setFederalPoliceOfficeRegis(FederalPoliceOfficeRegis federalPoliceOfficeRegis){
        this.federalPoliceOfficeRegis = federalPoliceOfficeRegis;
    }

}

