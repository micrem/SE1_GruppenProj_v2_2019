package idCard;

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

}
