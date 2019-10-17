package baggageScanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Record {
    static int id=0;

    private String timeStamp;
    private String result;
    private int position;
    private int recordID;

    public Record(int position, ProhibitedItems item) {
        recordID = id++;
        this.position = position;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.mm.yyyy HH:mm:ss,SSS");
        String formatDateTime = now.format(formatter);
        this.timeStamp = formatDateTime;

        switch (item){
            case gun:
                result = "weapon - glock7";
                break;

            case knife:
                result = "knife";
            break;

            case explosive:
                result = "explosive";
                break;
        }
        if (item==ProhibitedItems.none){
            result = "clean";
        } else {
            result = "prohibited item | "+result+"detected at position "+position;
        }
    }
}
