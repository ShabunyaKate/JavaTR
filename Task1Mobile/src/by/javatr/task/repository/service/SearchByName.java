<<<<<<< HEAD
package by.javatr.task.repository.service;

import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;

import java.util.Optional;

public class SearchByName extends SearchParametr {
    private String searchingName;
    public SearchByName(Optional<String>  searchingName)throws GeneralException{
        if(searchingName.isPresent()) {
            this.searchingName = searchingName.get();
        }
        else throw new GeneralException();
    }
    @Override
    public boolean condition(Rate o) {
        return o.getName().equals(searchingName);
    }
}
=======
package by.javatr.task.repository.service;

import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;

import java.util.Optional;

public class SearchByName extends SearchParametr {
    private String searchingName;
    public SearchByName(Optional<String>  searchingName)throws GeneralException{
        if(searchingName.isPresent()) {
            this.searchingName = searchingName.get();
        }
        else throw new GeneralException();
    }
    @Override
    public boolean condition(Rate o) {
        return o.getName().equals(searchingName);
    }
}
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
