<<<<<<< HEAD
package test;

import by.javatr.task.creator.RateFactory;
import by.javatr.task.entity.Rate;
import by.javatr.task.entity.typeOfRate.TypeOfRate;
import by.javatr.task.exception.GeneralException;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.RtMethodGenerator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TypeOfRateTest {
    String[] arr={"Mobile","new","1","2","3"};

    @Test
    public void testMakeType_TypeGood() throws GeneralException {
        TypeOfRate actual=TypeOfRate.makeType("Mobile");
        TypeOfRate expected=TypeOfRate.MOBILE;
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testMakeType_TypeBad() throws GeneralException {
        TypeOfRate actual=TypeOfRate.makeType("mkvkrvkpv");
        TypeOfRate expected=TypeOfRate.MOBILE;
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testMakeType_TypeNull() throws GeneralException {
        String s=null;
        TypeOfRate actual=TypeOfRate.makeType(s);
        TypeOfRate expected=TypeOfRate.MOBILE;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testTypeOfRate_RateMobile() throws GeneralException {
        Rate rate= RateFactory.creator(TypeOfRate.MOBILE,arr);
        String actual="MOBILE";
        String expected=TypeOfRate.typeOfRate(rate);
        Assert.assertEquals(actual,expected);
    }

=======
package test;

import by.javatr.task.creator.RateFactory;
import by.javatr.task.entity.Rate;
import by.javatr.task.entity.typeOfRate.TypeOfRate;
import by.javatr.task.exception.GeneralException;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.RtMethodGenerator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TypeOfRateTest {
    String[] arr={"Mobile","new","1","2","3"};

    @Test
    public void testMakeType_TypeGood() throws GeneralException {
        TypeOfRate actual=TypeOfRate.makeType("Mobile");
        TypeOfRate expected=TypeOfRate.MOBILE;
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testMakeType_TypeBad() throws GeneralException {
        TypeOfRate actual=TypeOfRate.makeType("mkvkrvkpv");
        TypeOfRate expected=TypeOfRate.MOBILE;
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testMakeType_TypeNull() throws GeneralException {
        String s=null;
        TypeOfRate actual=TypeOfRate.makeType(s);
        TypeOfRate expected=TypeOfRate.MOBILE;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testTypeOfRate_RateMobile() throws GeneralException {
        Rate rate= RateFactory.creator(TypeOfRate.MOBILE,arr);
        String actual="MOBILE";
        String expected=TypeOfRate.typeOfRate(rate);
        Assert.assertEquals(actual,expected);
    }

>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
}