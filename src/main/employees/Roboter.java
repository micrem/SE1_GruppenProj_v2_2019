package employees;

import passenger_Baggage.HandBaggage;

import java.util.function.DoubleToIntFunction;

public class Roboter {
    FederalPoliceOfficeRegis federalPoliceOfficeRegis;

    public Roboter(FederalPoliceOfficeRegis federalPoliceOfficeRegis) {
        this.federalPoliceOfficeRegis = federalPoliceOfficeRegis;
    }

    public void destroyBaggage(){
        // Handgepäck vom Tray Lösen
        HandBaggage tempHandB= federalPoliceOfficeRegis.getFederalPoliceOfficersList().get(0).getAssignedBaggageScanner().getManualPostControl().getPlasticTray().takeHandbaggage();
        String textHandBaggage =tempHandB.getBaggageText();
        String[] textHandBaggageFragment = new String[499];
        for (int i = 0; i <500 ; i++) {
            textHandBaggageFragment[i]= textHandBaggage.substring(i*100,(i+1)*100);
        }
        textHandBaggage = null;

        System.out.println("Gapaeck zerstoert von Passagier"+tempHandB.getPassenger().getName()+ "Passportnummer"+tempHandB.getPassenger().getPassport_id()+"mit Gepaeck ID"+ tempHandB.getBagID());
    }
}
