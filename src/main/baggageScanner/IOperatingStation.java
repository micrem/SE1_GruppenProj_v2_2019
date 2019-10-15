package baggageScanner;

import cardReader.ICardReader;

public interface IOperatingStation {
    ICardReader getCardReader();
    void buttonRight();
    void buttonRechteck();
    void buttonLeft();


}
