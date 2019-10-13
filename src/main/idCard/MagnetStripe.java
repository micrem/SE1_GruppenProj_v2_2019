package idCard;

public class MagnetStripe implements IStripe {

    private String content;

    public void writeContent(String content) {

    }

    @Override
    public String readStripe() {
        return content;
    }

    @Override
    public void writeStripe(String content) {
        this.content = content;
    }
}
