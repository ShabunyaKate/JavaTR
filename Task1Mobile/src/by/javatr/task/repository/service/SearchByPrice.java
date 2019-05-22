<<<<<<< HEAD
package by.javatr.task.repository.service;

import by.javatr.task.entity.Rate;

public class SearchByPrice extends SearchParametr {
    private int searchingPrice;
    public SearchByPrice(int searchingPrice){
        this.searchingPrice=searchingPrice;
    }
    @Override
    public boolean condition(Rate o) {
        return o.getPrice() == searchingPrice;
    }
}
=======
package by.javatr.task.repository.service;

import by.javatr.task.entity.Rate;

public class SearchByPrice extends SearchParametr {
    private int searchingPrice;
    public SearchByPrice(int searchingPrice){
        this.searchingPrice=searchingPrice;
    }
    @Override
    public boolean condition(Rate o) {
        return o.getPrice() == searchingPrice;
    }
}
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
