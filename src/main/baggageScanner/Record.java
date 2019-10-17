package baggageScanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static baggageScanner.ProhibitedItems.knife;
import static baggageScanner.ProhibitedItems.none;

public class Record {
    private int id;
    private String timeStamp;
    private String result;
    private int position;
    private int layerIndex;
    ProhibitedItems a;

    public Record(int id, ProhibitedItems item, int position, int layerIndex) {
        this.id = id;
        this.position = position;
        this.layerIndex = layerIndex;

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
        if (item==none){
            result = "clean";
        } else {
            result = "prohibited item | "+result+"detected at position "+position;
        }
    }
}
