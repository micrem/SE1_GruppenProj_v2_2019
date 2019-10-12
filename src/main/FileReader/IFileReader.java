package FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IFileReader {
    String[] readFileToString(String fileName) throws IOException;
}
