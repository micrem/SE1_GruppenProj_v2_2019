package idCard;

public class MagnetStripe implements IStripe {

    private String content;

    @Override
    public String readStripe() {
        return content;
    }

    @Override
    public void writeStripe(String content) {
        this.content = content;
    }
}
