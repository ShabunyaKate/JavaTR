<<<<<<< HEAD
package test;

import by.javatr.task.creator.InternetRateFactory;

import by.javatr.task.entity.InternetRate;

import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InternetRateFactoryTest {

    String[] arr1={"internet","new","1","2","-1"};
    String[] arr2={"internet","new","1","2","d"};
    String[] arr3={"internet","new","1","2","14"};
    String[] arr4={"internet","new","1"};
     @Test(expectedExceptions = GeneralException.class)
        public void testCreate1()throws GeneralException {
            Rate actual=InternetRateFactory.create(arr1);
            Rate expected=null;
            Assert.assertEquals(actual,expected);
        }
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate2()throws GeneralException {
        Rate actual=InternetRateFactory.create(arr2);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testCreate3()throws GeneralException {
        Rate actual=InternetRateFactory.create(arr3);
        InternetRate expected1=new InternetRate();
        expected1.setName("new");
        expected1.setPrice(1);
        expected1.setPeople(2);
        expected1.setInternet(14);
        Rate expected=(Rate) expected1;
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate4()throws GeneralException {
        Rate actual=InternetRateFactory.create(arr4);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
}
=======
package test;

import by.javatr.task.creator.InternetRateFactory;

import by.javatr.task.entity.InternetRate;

import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InternetRateFactoryTest {

    String[] arr1={"internet","new","1","2","-1"};
    String[] arr2={"internet","new","1","2","d"};
    String[] arr3={"internet","new","1","2","14"};
    String[] arr4={"internet","new","1"};
     @Test(expectedExceptions = GeneralException.class)
        public void testCreate1()throws GeneralException {
            Rate actual=InternetRateFactory.create(arr1);
            Rate expected=null;
            Assert.assertEquals(actual,expected);
        }
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate2()throws GeneralException {
        Rate actual=InternetRateFactory.create(arr2);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testCreate3()throws GeneralException {
        Rate actual=InternetRateFactory.create(arr3);
        InternetRate expected1=new InternetRate();
        expected1.setName("new");
        expected1.setPrice(1);
        expected1.setPeople(2);
        expected1.setInternet(14);
        Rate expected=(Rate) expected1;
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate4()throws GeneralException {
        Rate actual=InternetRateFactory.create(arr4);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
}
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
