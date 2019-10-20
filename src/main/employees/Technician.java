package employees;

public class Technician extends Employee implements ITechnician {
    public Technician(int pid, String pname, String pbirthDate) {
        super(pid, pname, pbirthDate);
    }
}
