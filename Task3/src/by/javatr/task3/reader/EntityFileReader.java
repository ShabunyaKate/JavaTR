package by.javatr.task3.reader;

import by.javatr.task3.exception.GeneralException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class EntityFileReader {
    private static final Logger log= LogManager.getLogger(EntityFileReader.class);
    /**Read information from file, in package data
     * @param  filename is name of file in package data
     * @return list of strings
     */
    public static List<String> readFromFile(String filename) throws GeneralException {
        String FILE_NAME="data/"+filename;
        List<String> lines;
        try {
            File file = new File(filename);
            lines = Files.readAllLines(Paths.get(FILE_NAME), UTF_8);
            log.info("File "+filename+"  was successfully read");
            return lines;
        }
        catch(IOException e){
            /**catch IOException
             * and use GeneralException as wrapper
             */
           throw new GeneralException("File Exception");
        }
    }
}
