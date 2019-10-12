package BaggageScanner;

public interface IBaggageScanner {
    void moveBellForward();
    void moveBeltBackward();
    void scan();
    void alarm();
    void report();
    void maintenance();
    void onOffButton();
    void setStatusScanner();
    void getStatusBaggerScanner();

}
