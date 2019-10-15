package employees;

import cardReader.ICardReader;
import idCard.IIDCard;

public interface IEmployee {
    void giveCardPin(int pin);
    void giveCard(IIDCard card);
}
