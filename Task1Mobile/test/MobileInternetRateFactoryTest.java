<<<<<<< HEAD
package test;

import by.javatr.task.creator.MobileInternetRateFactory;

import by.javatr.task.entity.MobileInternetRate;

import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MobileInternetRateFactoryTest {

    String[] arr1={"mobile_internet","new","1","2","-1","1"};
    String[] arr2={"mobile_internet","new","1","2","d","1"};
    String[] arr3={"mobile_internet","new","1","2","14","1"};
    String[] arr4={"mobile_internet","new","1"};
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate1()throws GeneralException {
        Rate actual= MobileInternetRateFactory.create(arr1);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate2()throws GeneralException {
        Rate actual=MobileInternetRateFactory.create(arr2);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testCreate3()throws GeneralException {
        Rate actual=MobileInternetRateFactory.create(arr3);
        MobileInternetRate expected1=new MobileInternetRate();
        expected1.setName("new");
        expected1.setPrice(1);
        expected1.setPeople(2);
        expected1.setCalls(14);
        expected1.setInternet(1);
        Rate expected=(Rate) expected1;
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate4()throws GeneralException {
        Rate actual=MobileInternetRateFactory.create(arr4);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
=======
package test;

import by.javatr.task.creator.MobileInternetRateFactory;

import by.javatr.task.entity.MobileInternetRate;

import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MobileInternetRateFactoryTest {

    String[] arr1={"mobile_internet","new","1","2","-1","1"};
    String[] arr2={"mobile_internet","new","1","2","d","1"};
    String[] arr3={"mobile_internet","new","1","2","14","1"};
    String[] arr4={"mobile_internet","new","1"};
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate1()throws GeneralException {
        Rate actual= MobileInternetRateFactory.create(arr1);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate2()throws GeneralException {
        Rate actual=MobileInternetRateFactory.create(arr2);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testCreate3()throws GeneralException {
        Rate actual=MobileInternetRateFactory.create(arr3);
        MobileInternetRate expected1=new MobileInternetRate();
        expected1.setName("new");
        expected1.setPrice(1);
        expected1.setPeople(2);
        expected1.setCalls(14);
        expected1.setInternet(1);
        Rate expected=(Rate) expected1;
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate4()throws GeneralException {
        Rate actual=MobileInternetRateFactory.create(arr4);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
}