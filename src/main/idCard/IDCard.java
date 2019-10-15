package idCard;

import cardReader.CardReader;
import cardReader.ICardReader;
import cardReader.ProfileType;

public class IDCard implements IIDCard {

    IStripe magnetStripe;
    int id;
    String validUntil;
    boolean isLocked;
    CardType type;

    public IDCard( int id, String validUntil, CardType type) {
        this.id = id;
        this.validUntil = validUntil;
        this.isLocked = false;
        this.type = type;
        magnetStripe = new MagnetStripe();
    }

    @Override
    public void writeStripe(String content) {
        magnetStripe.writeStripe(content);
    }

    @Override
    public String readStripe() {
        return magnetStripe==null ? null : magnetStripe.readStripe();
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public String getValidUntilDate() {
        return validUntil;
    }

    @Override
    public CardType getType() {
        return type;
    }

    @Override
    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public void lockCard() {
        isLocked = true;
    }

    public static void main(String[] args) {

        IIDCard idCard = new IDCard(1,"1.1.3000", CardType.staff);

        ICardReader cardReader = new CardReader("magicKey123!$");
        cardReader.writeTypePin(idCard, ProfileType.I,4321);
        cardReader.insertCard(idCard);
        System.out.println("pin:1234 correct:"+cardReader.enterPin(1234));
        System.out.println("pin:4321 correct:"+cardReader.enterPin(4321));
        System.out.println("CardType:"+cardReader.getCardProfileType());
        System.out.println("cardread is card locked="+cardReader.isCardLocked());
        cardReader.ejectCard();
        System.out.println("cardReader has card:"+cardReader.hasCard());
    }

}
