package employees;

import idCard.IIDCard;

public abstract class Employee implements IEmployee{

    protected int id;
    protected String name;
    protected String birthDate;
    protected int cardPin;
    protected IIDCard card;

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

    @Override
    public void giveCard(IIDCard card) {
        this.card = card;
    }

    @Override
    public void giveCardPin(int cardPin){
        this.cardPin = cardPin;
    }
}
