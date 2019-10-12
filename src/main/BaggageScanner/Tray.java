package BaggageScanner;

import Passenger_Baggage.HandBaggage;

public class Tray {
    private BaggageScanner baggageScanner;
    private HandBaggage handBaggage;

    public HandBaggage getHandBaggage() {
        HandBaggage tempBaggage = this.handBaggage;
        this.handBaggage = null;
        return handBaggage;
    }

    public void setHandBaggage(HandBaggage handBaggage) {
        this.handBaggage = handBaggage;
    }

    public Tray(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        baggageScanner.setTray(this);
    }
}
