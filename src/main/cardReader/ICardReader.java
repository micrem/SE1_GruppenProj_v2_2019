package cardReader;

import idCard.*;

public interface ICardReader {
    void setKeyAES(String keyAES);

    void insertCard(IIDCard card);

    IIDCard ejectCard();

    boolean enterPin(int pin);

    boolean isKeySet();

    boolean hasCard();

    boolean isCardLocked();

    ProfileType getProfileType();

    //void writeCardStripe(char profileType, int pin);
}
