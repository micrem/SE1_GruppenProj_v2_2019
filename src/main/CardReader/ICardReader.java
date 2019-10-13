package CardReader;

import IDCard.IIDCard;

public interface ICardReader {
    void setKeyAES(String keyAES);
    void insertCard(IIDCard card);
    boolean enterPin(int pin);
    boolean keySet();
    boolean cardInserted();
}
