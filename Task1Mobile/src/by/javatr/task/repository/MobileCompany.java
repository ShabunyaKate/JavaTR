<<<<<<< HEAD
package by.javatr.task.repository;

import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;

import by.javatr.task.entity.typeOfRate.TypeOfRate;
import by.javatr.task.repository.service.Parametr;
import by.javatr.task.repository.service.SearchParametr;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class MobileCompany {
    private static final Logger log= LogManager.getLogger(MobileCompany.class);
    private static MobileCompany instanse;
    private List<Rate> rates;
    private static String DATA_FILE="data/database";
    private MobileCompany(List<Rate> rates) {
        this.rates = rates;
    }

    public static MobileCompany getInstance(List<Rate> rates) {
        if (instanse == null) {
            instanse = new MobileCompany(rates);
        }
        return instanse;

    }

    public void add(Optional<Rate> rate) throws GeneralException{

        if (!rate.isPresent()||rates.contains(rate.get())) {
            log.error("Cant add, because Mobile Company contain this rate");
            throw new GeneralException();

        }
        rates.add(rate.get());
        upload();
    }

    public void delete(Optional<Rate> rate) throws GeneralException {
        if (!rate.isPresent()||!rates.contains(rate.get())) {
            log.error("Cant delete, because Mobile Company doesnt contain this rate");
             throw new GeneralException();
        }
        rates.remove(rate.get());
        upload();
    }

    public void upload() {
        PrintWriter writer=null;
        try {
            writer = new PrintWriter(DATA_FILE, "UTF-8");
            for (Rate rate : rates) {
                writer.println(transformToFileFormat(rate));
            }
        }
        catch (FileNotFoundException | UnsupportedEncodingException e) {
        } finally {
            writer.close();
        }
        log.info("File successfully upload");
    }
    public Optional<List<Rate>> query(Parametr parametr) {
        List<Rate> list=null;
        if(parametr instanceof Comparator){
            Comparator parametr1=(Comparator) parametr;
            list=cloneList(rates);
           list.sort(parametr1);
        }
        else{
            SearchParametr parametr1=(SearchParametr) parametr;
            list=new ArrayList<>();
           for(Rate rate:rates){
               if(parametr1.condition(rate)){
                   list.add(rate);
               }
           }

        }
        return Optional.ofNullable(list);
    }
    public int countOfPeople () {
        int people = 0;
        for (Rate a : rates) people += a.getPeople();
        return people;
    }
    private String transformToFileFormat(Rate rate)  {
            String data = TypeOfRate.typeOfRate(rate) + "," + rate.toFileString() + "," + rate.getId();
        return data;
        }
    private  List<Rate> cloneList(List<Rate> list) {
        List<Rate> clone = new ArrayList<Rate>(list.size());
        for (Rate item : list) clone.add(item);
        return clone;
    }
=======
package by.javatr.task.repository;

import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;

import by.javatr.task.entity.typeOfRate.TypeOfRate;
import by.javatr.task.repository.service.Parametr;
import by.javatr.task.repository.service.SearchParametr;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class MobileCompany {
    private static final Logger log= LogManager.getLogger(MobileCompany.class);
    private static MobileCompany instanse;
    private List<Rate> rates;
    private static String DATA_FILE="data/database";
    private MobileCompany(List<Rate> rates) {
        this.rates = rates;
    }

    public static MobileCompany getInstance(List<Rate> rates) {
        if (instanse == null) {
            instanse = new MobileCompany(rates);
        }
        return instanse;

    }

    public void add(Optional<Rate> rate) throws GeneralException{

        if (!rate.isPresent()||rates.contains(rate.get())) {
            log.error("Cant add, because Mobile Company contain this rate");
            throw new GeneralException();

        }
        rates.add(rate.get());
        upload();
    }

    public void delete(Optional<Rate> rate) throws GeneralException {
        if (!rate.isPresent()||!rates.contains(rate.get())) {
            log.error("Cant delete, because Mobile Company doesnt contain this rate");
             throw new GeneralException();
        }
        rates.remove(rate.get());
        upload();
    }

    public void upload() {
        PrintWriter writer=null;
        try {
            writer = new PrintWriter(DATA_FILE, "UTF-8");
            for (Rate rate : rates) {
                writer.println(transformToFileFormat(rate));
            }
        }
        catch (FileNotFoundException | UnsupportedEncodingException e) {
        } finally {
            writer.close();
        }
        log.info("File successfully upload");
    }
    public Optional<List<Rate>> query(Parametr parametr) {
        List<Rate> list=null;
        if(parametr instanceof Comparator){
            Comparator parametr1=(Comparator) parametr;
            list=cloneList(rates);
           list.sort(parametr1);
        }
        else{
            SearchParametr parametr1=(SearchParametr) parametr;
            list=new ArrayList<>();
           for(Rate rate:rates){
               if(parametr1.condition(rate)){
                   list.add(rate);
               }
           }

        }
        return Optional.ofNullable(list);
    }
    public int countOfPeople () {
        int people = 0;
        for (Rate a : rates) people += a.getPeople();
        return people;
    }
    private String transformToFileFormat(Rate rate)  {
            String data = TypeOfRate.typeOfRate(rate) + "," + rate.toFileString() + "," + rate.getId();
        return data;
        }
    private  List<Rate> cloneList(List<Rate> list) {
        List<Rate> clone = new ArrayList<Rate>(list.size());
        for (Rate item : list) clone.add(item);
        return clone;
    }
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
}