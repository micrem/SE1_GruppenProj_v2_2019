package baggageScanner;

public interface IBaggageScannerStation {
    BaggageScanner getBaggageScanner();
    PlasticTray removePlasticTray();
    PlasticTray getPlasticTray();
    void putPlasticTray(PlasticTray plasticTray);
}
