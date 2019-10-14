package cardReader;

import cryptography.AES;
import idCard.IIDCard;

public class CardReader implements ICardReader {


    private boolean correctPinEntered = false;
    private String keyAES;
    private IIDCard insertedCard;
    private int cardPin;
    private ProfileType profileType;
    private int pinAttempts;

    public CardReader(String keyAES) {
        this.keyAES = keyAES;
    }

    @Override
    public void insertCard(IIDCard card) {
        insertedCard = card;
        correctPinEntered = false;
        pinAttempts = 0;
    }

    @Override
    public IIDCard ejectCard() {
        IIDCard tempCardReference = this.insertedCard;
        insertedCard = null;
        return tempCardReference;
    }

    @Override
    public boolean enterPin(int pin) {
        if (!hasCard()) return false;
        if (insertedCard.isLocked()) {
            System.out.println("Can't enter pin, card is locked.");
            return false;
        }
        if (correctPinEntered) return true;
        if (pinAttempts >= 4) {
            System.out.println("Too many attempts, locking card.");
            insertedCard.lockCard();
            return false;
        }
        pinAttempts++;
        if (pin > 9999 || pin < 0) return false;
        if (pin == cardPin) {
            correctPinEntered = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean hasCard() {
        return insertedCard != null;
    }

    @Override
    public boolean isCardLocked() {
        if (!hasCard()) return false;
        return insertedCard.isLocked();
    }

    @Override
    public ProfileType getProfileType() {
        return profileType;
    }

    private void decodeCardData() {
        String stripeEncrypted = insertedCard.readStripe();
        String stripeDecrypted = AES.decrypt(stripeEncrypted, keyAES);
        if (stripeDecrypted == null || stripeDecrypted.length() < 11) {
            System.out.println("Card stripe data invalid, locking card.");
            insertedCard.lockCard();
            return;
        }
        try {
            this.cardPin = Integer.parseInt(stripeDecrypted.substring(7, 11));
            this.profileType = ProfileType.valueOf(stripeDecrypted.substring(4, 5));
        } catch (IllegalArgumentException e) {
            System.out.println("Card stripe data invalid, locking card.");
            insertedCard.lockCard();
        }
    }

}
