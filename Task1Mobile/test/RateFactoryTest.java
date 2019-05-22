<<<<<<< HEAD
package test;

import by.javatr.task.creator.RateFactory;
import by.javatr.task.entity.InternetRate;
import by.javatr.task.entity.Rate;
import by.javatr.task.entity.typeOfRate.TypeOfRate;
import by.javatr.task.exception.GeneralException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RateFactoryTest {
    String[] arr={"default","new","1","2"};

    @Test
    public void testCreator_TypeGInternet() throws GeneralException {
        Rate actual = RateFactory.creator(TypeOfRate.DEFAULT,arr);
        Rate expected=new Rate();
        expected.setName("new");
        expected.setPeople(2);
        expected.setPrice(1);
        Assert.assertEquals(actual,expected);
    }
=======
package test;

import by.javatr.task.creator.RateFactory;
import by.javatr.task.entity.InternetRate;
import by.javatr.task.entity.Rate;
import by.javatr.task.entity.typeOfRate.TypeOfRate;
import by.javatr.task.exception.GeneralException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RateFactoryTest {
    String[] arr={"default","new","1","2"};

    @Test
    public void testCreator_TypeGInternet() throws GeneralException {
        Rate actual = RateFactory.creator(TypeOfRate.DEFAULT,arr);
        Rate expected=new Rate();
        expected.setName("new");
        expected.setPeople(2);
        expected.setPrice(1);
        Assert.assertEquals(actual,expected);
    }
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
}