package employees;

public abstract class Employee {

    protected int id;
    protected String name;
    protected String birthDate;

    public void setName(String inName){
        name=inName;
    }
    public void setBirthDate(String inBirthDate){
        birthDate=inBirthDate;
    }

    public Employee(int pid, String pname, String pbirthDate){
        this.id=pid;
        setName(pname);
        name=pname;
        setBirthDate(pbirthDate);
    }
}
