package baggageScanner;

public interface IBaggageScannerStation {
    IBaggageScanner getBaggageScanner();
    PlasticTray removePlasticTray();
    PlasticTray getPlasticTray();
    void putPlasticTray(PlasticTray plasticTray);
}
