package FileReader;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class BaggageScannerFileReader implements IFileReader{

    public String[] readFileToString(String filePath) throws IOException {

        String line;
        String lineEnd = ";";

        Vector<String> fileLines = new Vector<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath), 50001 * 4)) { //try-with-resource block

            while ((line = br.readLine()) != null) {
                fileLines.addElement(line);
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("BaggageScannerFileReader has not found the given filename or directory: '" + filePath + "'");
        } catch (IOException e) {
            throw new IOException("BaggageScannerFileReader I/O operations failed or were interrupted");
        }

        return fileLines.toArray(new String[0]); //String[0] only defines return type, array-size is changed in toArray()
    }
}
