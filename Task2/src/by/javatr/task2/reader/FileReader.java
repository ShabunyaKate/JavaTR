package by.javatr.task2.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    public static String readFromFile( String path) {
        String text = "";
        try {
            FileInputStream file = new FileInputStream(path);
            byte[] str = new byte[file.available()];
            file.read(str);
            text = new String(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
