package IDCard;

public class IDCard implements IIDCard {

    IStripe magnetStripe;
    @Override
    public void write(String content) {
        if(magnetStripe ==null) {
            magnetStripe = new MagnetStripe();
        }
        magnetStripe.writeStripe(content);

    }

    @Override
    public String read() {
        return magnetStripe ==null ? null : magnetStripe.readStripe();
    }
}
