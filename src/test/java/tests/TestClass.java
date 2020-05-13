package tests;

import org.testng.annotations.Test;
import pages.TestPageClass;

public class TestClass extends TestBaseClass {

    @Test
    public void basicTest () {

        TestPageClass object = new TestPageClass(driver);

        object.searchForTv();
        object.assertCreateAccount();
    }
}