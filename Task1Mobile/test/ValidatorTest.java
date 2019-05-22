<<<<<<< HEAD
package test;

import by.javatr.task.creator.Validator;
import by.javatr.task.exception.GeneralException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidatorTest {
    @Test
    public void testparseOfInt_Type1() throws GeneralException {
       int actual= Validator.parseOfInt("1");
       int expected=1;
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testparseOfInt_TypeNegative() throws GeneralException {
        int actual= Validator.parseOfInt("-1");
        int expected=0;
        Assert.assertEquals(actual,expected);
    }

    @Test(expectedExceptions = GeneralException.class)
    public void testparseOfInt_TypeStingNotFormat() throws GeneralException {
        int actual= Validator.parseOfInt("d");
        int expected=0;
        Assert.assertEquals(actual,expected);
    }
=======
package test;

import by.javatr.task.creator.Validator;
import by.javatr.task.exception.GeneralException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidatorTest {
    @Test
    public void testparseOfInt_Type1() throws GeneralException {
       int actual= Validator.parseOfInt("1");
       int expected=1;
        Assert.assertEquals(actual,expected);
    }
    @Test(expectedExceptions = GeneralException.class)
    public void testparseOfInt_TypeNegative() throws GeneralException {
        int actual= Validator.parseOfInt("-1");
        int expected=0;
        Assert.assertEquals(actual,expected);
    }

    @Test(expectedExceptions = GeneralException.class)
    public void testparseOfInt_TypeStingNotFormat() throws GeneralException {
        int actual= Validator.parseOfInt("d");
        int expected=0;
        Assert.assertEquals(actual,expected);
    }
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
}