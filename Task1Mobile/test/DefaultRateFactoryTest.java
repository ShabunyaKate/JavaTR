<<<<<<< HEAD
package test;



import by.javatr.task.creator.DefaultRateFactory;
import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DefaultRateFactoryTest {


    String[] arr1={"default","new","1","-1"};
    String[] arr2={"default","new","1","d"};
    String[] arr3={"default","new","1","14"};
    String[] arr4={"default","new","1","14","sw","edde"};
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate1()throws GeneralException {
        Rate actual= DefaultRateFactory.create(arr1);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate2()throws GeneralException {
        Rate actual=DefaultRateFactory.create(arr2);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testCreate3()throws GeneralException {
        Rate actual=DefaultRateFactory.create(arr3);
        Rate expected=new Rate();
        expected.setName("new");
        expected.setPrice(1);
        expected.setPeople(14);
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate4()throws GeneralException {
        Rate actual=DefaultRateFactory.create(arr4);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
=======
package test;



import by.javatr.task.creator.DefaultRateFactory;
import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DefaultRateFactoryTest {


    String[] arr1={"default","new","1","-1"};
    String[] arr2={"default","new","1","d"};
    String[] arr3={"default","new","1","14"};
    String[] arr4={"default","new","1","14","sw","edde"};
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate1()throws GeneralException {
        Rate actual= DefaultRateFactory.create(arr1);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate2()throws GeneralException {
        Rate actual=DefaultRateFactory.create(arr2);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testCreate3()throws GeneralException {
        Rate actual=DefaultRateFactory.create(arr3);
        Rate expected=new Rate();
        expected.setName("new");
        expected.setPrice(1);
        expected.setPeople(14);
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testCreate4()throws GeneralException {
        Rate actual=DefaultRateFactory.create(arr4);
        Rate expected=null;
        Assert.assertEquals(actual,expected);
    }
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
}