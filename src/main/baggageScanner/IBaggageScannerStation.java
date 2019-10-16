package baggageScanner;

public interface IBaggageScannerStation {
    IBaggageScanner getBaggageScanner();
    PlasticTray removePlasticTray();
    PlasticTray peekPlasticTray();
    void putPlasticTray(PlasticTray plasticTray);
}
