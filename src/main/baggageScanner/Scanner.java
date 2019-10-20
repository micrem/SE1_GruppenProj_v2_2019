package baggageScanner;

import string_matching.*;
import employees.IInspectorOperatingStation;

public class Scanner implements IBaggageScannerStation{
    private PlasticTray plasticTray;
    private IBaggageScanner baggageScanner;



    public Scanner(IBaggageScanner pbaggageScanner){
        this.baggageScanner=pbaggageScanner;
    }

    @Override
    public IBaggageScanner getBaggageScanner() {
        return baggageScanner;
    }

    @Override
    public PlasticTray peekPlasticTray() {
        return plasticTray;
    }

    @Override
    public PlasticTray removePlasticTray() {
        PlasticTray tempBaggage = this.plasticTray;
        this.plasticTray = null;
        return tempBaggage;
    }

    @Override
    public void putPlasticTray(PlasticTray plasticTray) {
        this.plasticTray = plasticTray;

    }
    public void buttonSquarePushed(IInspectorOperatingStation inspector, IStringMatching string_matcher){
        String content;
        int position;
        if(getBaggageScanner().scan(inspector.getID())==false) return;
        if (plasticTray==null || plasticTray.getHandbaggage()==null) return;
        for (int i = 0; i < 5; i++) {
            content = plasticTray.getHandbaggage().getLayer(i).getContent();
            position = string_matcher.search(content, ProhibitedItems.explosive.getItemString()) ;
            if (position!=-1) {
                inspector.discoverExplosive(position, i);
                return;
            }
        }
        for (int i = 0; i < 5; i++) {
            content = plasticTray.getHandbaggage().getLayer(i).getContent();
            position = string_matcher.search(content, ProhibitedItems.gun.getItemString()) ;
            if (position!=-1) {
                inspector.discoverKnife(position, i);
                inspector.PushButtonLeft();
                inspector.PushButtonSquare();
                return;
            }
        }
        for (int i = 0; i < 5; i++) {
            content = plasticTray.getHandbaggage().getLayer(i).getContent();
            position = string_matcher.search(content, ProhibitedItems.gun.getItemString()) ;
            if (position!=-1) {
                inspector.discoverGun(position, i);
                inspector.PushButtonLeft();
                inspector.PushButtonSquare();
                return;
            }
        }
    }
    public void buttonRightPushed(){
        baggageScanner.getScannerDevice().putPlasticTray(baggageScanner.getOperatingStation().removePlasticTray());

    }
    public void buttonLeftPushed(){
        baggageScanner.getScannerDevice().putPlasticTray(baggageScanner.getManualPostControl().removePlasticTray());
    }

}
