package baggageScanner;

import cardReader.ICardReader;
import employees.IEmployee;
import employees.InspectorOperationStation;

public interface IOperatingStation {
    ICardReader getCardReader();
    void buttonRight();
    void buttonRechteck();
    void buttonLeft();

    boolean logInOperator(IEmployee employee);
}
