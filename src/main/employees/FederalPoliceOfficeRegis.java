package employees;

import java.util.ArrayList;

public class FederalPoliceOfficeRegis {
    private PoliceOfficeRegis profilTyp;
    private ArrayList<FederalPoliceOfficer> federalPoliceOfficersList;

    public FederalPoliceOfficeRegis() {
        federalPoliceOfficersList = new ArrayList<>();


    }

    public void addFederalPoliceOfficer(FederalPoliceOfficer federalPoliceOfficer){
        federalPoliceOfficersList.add(federalPoliceOfficer);
    }

}
