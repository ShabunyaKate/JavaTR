<<<<<<< HEAD
package by.javatr.task.creator;

import by.javatr.task.entity.Rate;
import by.javatr.task.entity.typeOfRate.TypeOfRate;
import by.javatr.task.exception.GeneralException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreatorFromFile {
     private static final Logger log= LogManager.getLogger(CreatorFromFile.class);
     public static final String RATE_SEPARATOR_IN_FILE = ",";
     public static List<Rate> createListOfRates(Optional<List<String>> lines1)throws GeneralException {
         if (lines1.isPresent()) {
             List<String>lines=lines1.get();
             int number_id = 1;
             List<Rate> rates = new ArrayList<>();
             for (String line : lines) {
                 String[] param = line.split(RATE_SEPARATOR_IN_FILE);
                 if (param.length == 0 && param.length < 6) continue;
                 try {
                     Rate rate = RateFactory.creator(TypeOfRate.makeType(param[0]), param);
                     if (!rates.contains(rate)) {
                         rate.setId(number_id++);
                         rates.add(rate);
                         log.info("Rate was created");
                     }
                 } catch (GeneralException e) {
                     log.warn(e.getMessage(), e);
                     log.info("NotCreated");
                 }
             }
             return rates;
         }
         else throw new GeneralException("no information");
     }
=======
package by.javatr.task.creator;

import by.javatr.task.entity.Rate;
import by.javatr.task.entity.typeOfRate.TypeOfRate;
import by.javatr.task.exception.GeneralException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreatorFromFile {
     private static final Logger log= LogManager.getLogger(CreatorFromFile.class);
     public static final String RATE_SEPARATOR_IN_FILE = ",";
     public static List<Rate> createListOfRates(Optional<List<String>> lines1)throws GeneralException {
         if (lines1.isPresent()) {
             List<String>lines=lines1.get();
             int number_id = 1;
             List<Rate> rates = new ArrayList<>();
             for (String line : lines) {
                 String[] param = line.split(RATE_SEPARATOR_IN_FILE);
                 if (param.length == 0 && param.length < 6) continue;
                 try {
                     Rate rate = RateFactory.creator(TypeOfRate.makeType(param[0]), param);
                     if (!rates.contains(rate)) {
                         rate.setId(number_id++);
                         rates.add(rate);
                         log.info("Rate was created");
                     }
                 } catch (GeneralException e) {
                     log.warn(e.getMessage(), e);
                     log.info("NotCreated");
                 }
             }
             return rates;
         }
         else throw new GeneralException("no information");
     }
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
    }