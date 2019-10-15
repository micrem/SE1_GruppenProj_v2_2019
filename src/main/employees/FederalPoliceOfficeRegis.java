package employees;

import java.util.ArrayList;

public class FederalPoliceOfficeRegis {
    private PoliceOfficeRegis profilTyp;
    private ArrayList<FederalPoliceOfficer> federalPoliceOfficersList;
    private Roboter[] roboter = new Roboter[3];

    public FederalPoliceOfficeRegis() {
        federalPoliceOfficersList = new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            roboter[i] = new Roboter(this);
        }


    }

    public void addFederalPoliceOfficer(FederalPoliceOfficer federalPoliceOfficer){
        federalPoliceOfficersList.add(federalPoliceOfficer);
    }

    public Roboter[] getRoboter() {
        return roboter;
    }
}
