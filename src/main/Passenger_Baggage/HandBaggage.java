package Passenger_Baggage;

public class HandBaggage {

    //fuer 1 zu 5 verkuepfung
    private Layer layer1;
    private Layer layer2;
    private Layer layer3;
    private Layer layer4;
    private Layer layer5;


    private String baggageText;
    private String layer1Text;
    private String layer2Text;
    private String layer3Text;
    private String layer4Text;
    private String layer5Text;

    public HandBaggage(String baggageText){
        this.baggageText = baggageText;

        layer1Text = baggageText.substring(0,10000);
        layer2Text = baggageText.substring(10000,20000);
        layer3Text = baggageText.substring(20000,30000);
        layer4Text = baggageText.substring(30000,40000);
        layer5Text = baggageText.substring(40000,50000);

        Layer layer1 = new Layer(layer1Text,this);
        Layer layer2 = new Layer(layer2Text,this);
        Layer layer3 = new Layer(layer3Text,this);
        Layer layer4 = new Layer(layer4Text,this);
        Layer layer5 = new Layer(layer5Text,this);

    }

    public void setLayer1 (Layer layer1){
        this.layer1 = layer1;
    }
    public void setLayer2 (Layer layer2){
        this.layer2 = layer2;
    }
    public void setLayer3 (Layer layer3){
        this.layer3 = layer3;
    }
    public void setLayer4 (Layer layer4){
        this.layer4 = layer4;
    }
    public void setLayer5 (Layer layer5){
        this.layer5 = layer5;
    }

}
