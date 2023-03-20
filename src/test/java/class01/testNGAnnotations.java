package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGAnnotations {

    @BeforeMethod
    public void beforeMethods(){
        System.out.println("i am before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("i am after Method");
    }

    @Test
    public void AfirstTestCase(){
        System.out.println("i am the first test case");
    }

    @Test
    public void BSecondTestCase(){
        System.out.println("i am the second test case");
    }

    @Test
    public void CThirdTestCase(){
        System.out.println("i am the thirds test case");
    }
}
