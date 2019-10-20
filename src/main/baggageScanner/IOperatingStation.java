package baggageScanner;

import cardReader.ICardReader;
import employees.IInspectorOperatingStation;

public interface IOperatingStation {
    ICardReader getCardReader();
    void buttonRight();
    void buttonSquare();
    void buttonLeft();

    boolean logInOperator(IInspectorOperatingStation employee);
}
