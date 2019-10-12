package Passenger_Baggage;

public class Layer {
    public static int layerSize=10000;

    private String layerText;
    private HandBaggage handBaggage;

    public Layer(String layerText, HandBaggage handBaggage){
        this.layerText = layerText;
        this.handBaggage =handBaggage;
    }

    public String getContent() {
        return layerText;
    }
}
