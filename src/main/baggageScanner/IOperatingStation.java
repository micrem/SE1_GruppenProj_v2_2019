package baggageScanner;

import cardReader.ICardReader;
import employees.iInspectorOperatingStation;

public interface IOperatingStation {
    ICardReader getCardReader();
    void buttonRight();
    void buttonRechteck();
    void buttonLeft();

    boolean logInOperator(iInspectorOperatingStation employee);
}
