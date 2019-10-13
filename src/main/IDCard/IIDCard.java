package IDCard;

public interface IIDCard {
    MagnetStripe magnetStripe = new MagnetStripe();
    void write(String content);
    String readEncoded();
}
