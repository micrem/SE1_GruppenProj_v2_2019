package employees;

import cardReader.ICardReader;
import idCard.IIDCard;

public interface IEmployee {
    boolean enterPin(ICardReader cardReader);
    void giveCardPin(int pin);
    void giveCard(IIDCard card);
    IIDCard insertCardIntoReader(ICardReader cardReader);
}
