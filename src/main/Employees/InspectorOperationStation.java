package Employees;

import BaggageScanner.OperatingStation;


public class InspectorOperationStation extends Inspector implements iInspectorOperatingStation{
    OperatingStation assignedOS;
    public InspectorOperationStation(int pid, String pname, String pbirthDate, boolean pisSenior, OperatingStation passignedOS) {
        super(pid, pname, pbirthDate, pisSenior);
        assignedOS=passignedOS;
    }
    @Override
    public void LogIn(){
        //logs in
    }
    @Override
    public void PushButtonRight(){

    }@Override
    public void PushButtonTriangle(){
    }
    @Override
    public void DiscoverKnife(){
    }
    @Override
    public void DiscoverGun(){
    }
    @Override
    public void DiscoverExplosive(){

    }
    @Override
    public void PushButtonLeft(){

    }
}
