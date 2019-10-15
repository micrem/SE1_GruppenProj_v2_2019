package cardReader;

import idCard.*;

public interface ICardReader {

    void insertCard(IIDCard card);

    IIDCard ejectCard();

    boolean enterPin(int pin);

    boolean hasCard();

    boolean isCardLocked();

    ProfileType getProfileType();

    void writeTypePin(ProfileType type, int pin);

    //void writeCardStripe(char profileType, int pin);
}
