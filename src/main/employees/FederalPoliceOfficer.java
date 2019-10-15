package employees;


import baggageScanner.BaggageScanner;

public class FederalPoliceOfficer extends Employee implements iFederalPoliceOfficer{
    BaggageScanner assignedBaggageScanner;
    String grade;
    FederalPoliceOfficeRegis federalPoliceOfficeRegis;
    public FederalPoliceOfficer(int pid, String pname, String pbirthDate, String grade, FederalPoliceOfficeRegis federalPoliceOfficeRegis)
    {
        super(pid, pname, pbirthDate);
        this.grade= grade;
        this.federalPoliceOfficeRegis = federalPoliceOfficeRegis;
        federalPoliceOfficeRegis.addFederalPoliceOfficer(this);
    }
    @Override
    public void ConfiscateGun(){}
    @Override
    public void setAssignedBaggageScanner(BaggageScanner passignedBaggageScanner){
        assignedBaggageScanner=passignedBaggageScanner;
    }

    @Override
    public void roboterDestroyBaggage() {
        federalPoliceOfficeRegis.getRoboter()[0].destroyBaggage();

    }


}

