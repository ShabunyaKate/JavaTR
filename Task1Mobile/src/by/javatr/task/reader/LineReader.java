<<<<<<< HEAD
package by.javatr.task.reader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import by.javatr.task.exception.GeneralException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;


import static java.nio.charset.StandardCharsets.UTF_8;

public class LineReader {
    private static final Logger log= LogManager.getLogger(LineReader.class);
    public static Optional<List<String>> readFromFile(String filename) throws GeneralException{
        String FILE_NAME="data/"+filename;
        List<String> lines;
        try {
            File file = new File(filename);
            lines = Files.readAllLines(Paths.get(FILE_NAME), UTF_8);
            Optional<List<String>> mas=Optional.ofNullable(lines);
            return  mas;
        }
        catch(IOException e){
            log.error("FileError",e);
            throw new GeneralException(e);
        }
    }
}
=======
package by.javatr.task.reader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import by.javatr.task.exception.GeneralException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;


import static java.nio.charset.StandardCharsets.UTF_8;

public class LineReader {
    private static final Logger log= LogManager.getLogger(LineReader.class);
    public static Optional<List<String>> readFromFile(String filename) throws GeneralException{
        String FILE_NAME="data/"+filename;
        List<String> lines;
        try {
            File file = new File(filename);
            lines = Files.readAllLines(Paths.get(FILE_NAME), UTF_8);
            Optional<List<String>> mas=Optional.ofNullable(lines);
            return  mas;
        }
        catch(IOException e){
            log.error("FileError",e);
            throw new GeneralException(e);
        }
    }
}
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
