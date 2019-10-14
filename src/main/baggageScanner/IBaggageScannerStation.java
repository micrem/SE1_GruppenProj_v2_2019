package baggageScanner;

public interface IBaggageScannerStation {
    PlasticTray removePlasticTray();
    PlasticTray getPlasticTray();
    void putPlasticTray(PlasticTray plasticTray);
}
