package by.javatr.task3.creator;

import by.javatr.task3.entity.Matrix;
import by.javatr.task3.exception.GeneralException;
import by.javatr.task3.validator.RunnableValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;


 /**Class for creating list threads
 */
public class ThreadCreator {
    public static final String SEPARATOR_IN_FILE = " ";

    private static final Logger log= LogManager.getLogger(ThreadCreator.class);

     /**
      * @param lines count of lines == count of threads, lines have number parametr for threads
      * @param matrix-resource for threads.It is param of threads
      * @return list of threads
      * @throws GeneralException  throw,when incorrect information. A lot of check in class RunnableValidator
      */
    public static List<Thread> createThreads(List<String> lines,Matrix matrix) throws GeneralException {
        if (!RunnableValidator.isRangeOfLength(lines)){
            throw new GeneralException("Incorrect count of threads");
        }
        List<Thread> threads=new ArrayList<>();
        for (String line : lines) {
            if(line.isEmpty()){
                throw new GeneralException("Param line for threads is empty");
            }
            String[] param = line.split(SEPARATOR_IN_FILE);
            int parametr=RunnableValidator.isCorrectParam(param[0]);
            /**Create RunnableChanger
             * than place RunnableChanger in thread constructor
             */
            Thread thread=new Thread(RunnableChangerCreator.createRunnableChanger(parametr,matrix));
            threads.add(thread);
            log.info(thread.getName()+" with param "+parametr+" was created");
        }
        return threads;
    }
}