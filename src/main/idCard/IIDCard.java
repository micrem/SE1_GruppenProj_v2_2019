package idCard;

public interface IIDCard {
    void writeStripe(String content);

    String readStripe();

    int getID();

    String getValidUntilDate();

    CardType getType();

    boolean isLocked();


}
