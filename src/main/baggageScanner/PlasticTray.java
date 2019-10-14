package baggageScanner;

import passenger_Baggage.HandBaggage;

public class PlasticTray {
    private HandBaggage handbaggage;


    public HandBaggage getHandbaggage() {
        return handbaggage;
    }

    public void setHandbaggage(HandBaggage handbaggage) {
        this.handbaggage = handbaggage;
    }

    public HandBaggage takeHandbaggage() {
        HandBaggage tempBaggage = this.handbaggage;
        handbaggage = null;
        return tempBaggage;
    }
}
