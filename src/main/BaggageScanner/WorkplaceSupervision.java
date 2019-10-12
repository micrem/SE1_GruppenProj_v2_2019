package BaggageScanner;

public class WorkplaceSupervision {
    private BaggageScanner baggageScanner;

    public  WorkplaceSupervision(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
        baggageScanner.setWorkplaceSupervision(this);
    }

}
