<<<<<<< HEAD
package by.javatr.task.repository.service;

import by.javatr.task.entity.Rate;

public class SearchByPeople extends SearchParametr {
    private int searchingPeople;
    public SearchByPeople(int searchingPeople){
        this.searchingPeople=searchingPeople;
    }
    @Override
    public boolean condition(Rate o) {
        return o.getPeople() == searchingPeople;
    }
}
=======
package by.javatr.task.repository.service;

import by.javatr.task.entity.Rate;

public class SearchByPeople extends SearchParametr {
    private int searchingPeople;
    public SearchByPeople(int searchingPeople){
        this.searchingPeople=searchingPeople;
    }
    @Override
    public boolean condition(Rate o) {
        return o.getPeople() == searchingPeople;
    }
}
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
