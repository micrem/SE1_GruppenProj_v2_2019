package Employees;

public class Technician extends Employee implements iTechnician{
    public Technician(int pid, String pname, String pbirthDate) {
        super(pid, pname, pbirthDate);
    }
}
