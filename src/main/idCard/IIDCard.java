package idCard;

public interface IIDCard {


    void writeStripe(String content);

    String readStripe();

    int getID();

    String getValidUntilDate();

    IDCardType getType();

    boolean isLocked();

    void lockCard();


}
