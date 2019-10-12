package Employees;


public abstract class Inspector extends Employee {
    private boolean isSenior;

    public Inspector(int pid, String pname, String pbirthDate, boolean pisSenior) {
        super(pid, pname, pbirthDate);
        isSenior=pisSenior;
    }
}
