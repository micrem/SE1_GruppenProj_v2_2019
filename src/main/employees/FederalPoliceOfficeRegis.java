package employees;

import java.util.ArrayList;

public class FederalPoliceOfficeRegis {
    private PoliceOfficeRegis profilTyp;
    private ArrayList<iFederalPoliceOfficer> federalPoliceOfficersList;
    private Roboter[] roboter = new Roboter[3];

    public FederalPoliceOfficeRegis() {
        federalPoliceOfficersList = new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            roboter[i] = new Roboter(this);
        }


    }

    public void addFederalPoliceOfficer(iFederalPoliceOfficer federalPoliceOfficer){
        federalPoliceOfficersList.add(federalPoliceOfficer);
    }

    public ArrayList<iFederalPoliceOfficer> getFederalPoliceOfficersList() {
        return federalPoliceOfficersList;
    }

    public Roboter[] getRoboter() {
        return roboter;
    }
}
