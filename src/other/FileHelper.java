package other;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {

    private static File answerFile;
    private static File questionFile;

    public static void writeToFile(String content, File file) {
        try {
            FileWriter resultFile = new FileWriter(file);
            resultFile.write(content);
            resultFile.flush();
            resultFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
