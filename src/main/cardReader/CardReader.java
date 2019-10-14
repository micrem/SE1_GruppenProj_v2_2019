package cardReader;

import idCard.IIDCard;

public class CardReader implements ICardReader {
    private boolean isKeySet = false;
    private boolean hasCard = false;
    private boolean correctPinEntered=false;
    private String keyAES;
    private IIDCard insertedCard;

    @Override
    public void setKeyAES(String keyAES) {
        this.keyAES = keyAES;
        isKeySet = true;
    }

    @Override
    public void insertCard(IIDCard card) {
        insertedCard = card;
        hasCard = true;
    }

    @Override
    public IIDCard ejectCard() {
        IIDCard tempCardReference = this.insertedCard;
        insertedCard = null;
        correctPinEntered=false;
        return tempCardReference;
    }

    @Override
    public boolean enterPin(int pin) {
        //check if has card
        //read card stripe
        //decode card stripe
        //get key from decoded string
        return false;
    }

    @Override
    public boolean isKeySet() {
        return isKeySet;
    }

    @Override
    public boolean hasCard() {
        return hasCard;
    }

    @Override
    public boolean isCardLocked() {
        return false;
    }

    @Override
    public ProfileType getProfileType() {
        return null;
    }

}
