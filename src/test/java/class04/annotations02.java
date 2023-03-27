package class04;

import org.testng.annotations.*;

public class annotations02 {
    @BeforeTest
    public void beforeTest(){
        System.out.println("i am before test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("i am a before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println(" i am after class");
    }
    @BeforeMethod
    public void before(){
        System.out.println("i am before Method");
    }
    @AfterMethod
    public void after(){
        System.out.println("i am after Method");
    }
    @Test
    public void TestA(){
        System.out.println("i am a test A");
    }
    @Test
    public void TestB(){
        System.out.println("i am a test B");
    }

}
