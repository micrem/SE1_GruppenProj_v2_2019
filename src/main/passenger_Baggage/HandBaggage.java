package passenger_Baggage;

public class HandBaggage {

    //fuer 1 zu 5 verkuepfung
    private Layer[] layers;


    private String baggageText;
    private String layerText;

    public HandBaggage(String baggageText){
        int layerSize = Layer.layerSize;
        this.baggageText = baggageText;
        layers = new Layer[5];

        for (int i=0;i<=4;i++){
            layerText = baggageText.substring(i*layerSize, i*layerSize+layerSize);
            layers[i] = new Layer(layerText, this);
        }

    }

    public Layer getLayer(int index) {
        if (index >= 0 && index < layers.length) {
            return layers[index];
        } else
            return null;
        }
}
