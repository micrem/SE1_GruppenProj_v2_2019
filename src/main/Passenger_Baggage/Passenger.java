package Passenger_Baggage;

// Daten Passenger
// id,name,gender,birthdate,address,passport_id
//1,Nicole Stewart,female,30.09.1988,39 Green Lane,Bath,BA14 6VW,R29IVXGBE

import java.util.Date;

public class Passenger {

    private static int MAXBAGGAGE = 3;

    private int idPassenger;
    private String name;
    private Gender gender;
    private String birthdate;
    private String street;
    private String city;
    private String plz;
    private String passport_id;


    private int[] baggageIDs;

    public Passenger(int idPassenger, String name, Gender gender,String birthdate, String street, String city, String plz, String passport_id){
        this.idPassenger = idPassenger;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.street = street;
        this.city = city;
        this.plz = plz;
        this.passport_id = passport_id;
    }

    public void setBaggage(int[] baggageIDs){
        int numOfBags=0;
        //create array to fit all non-null baggageIDs
        for (int bagID: baggageIDs
             ) {
            if (bagID!=0) numOfBags++;
        }
        this.baggageIDs = new int[numOfBags<=MAXBAGGAGE?numOfBags:MAXBAGGAGE];

        numOfBags=0;
        for (int bagID: baggageIDs
        ) {
            if (bagID!=0 && numOfBags<MAXBAGGAGE) this.baggageIDs[numOfBags++]=bagID;
        }
    }

    public int[] getBaggageIDs() {
        return baggageIDs;
    }

}
