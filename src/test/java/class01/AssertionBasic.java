package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertionBasic {
    public static WebDriver driver;
    //pre-conditions
    @BeforeMethod
    public void SetupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    //post condition
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    //testcase
    // enetr username :Admin
    //enter password :khdfdhdjfh
    // click login button
    //verify that the message invalid credentials is displayed
    //verify that password text box is displayed on the screen
    @Test
    public void invalidCredentials(){
        // locate the WebElement username and sen keys
        WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("Admin");

        // locate the WebElement password and send keys
        WebElement password=driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("abracadabra");

        // locate login button and click login
        WebElement loginBtn=driver.findElement(By.xpath("//input[@name='Submit']"));
        loginBtn.click();

        //verifying error message
        WebElement error = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errorMsg = error.getText();
        // check if the error message is correct
        String expectedError= "Invalid credentials";

     /*   if(errorMsg.equalsIgnoreCase(expectedError)){
            System.out.println("test passed");
        }
        else{
            System.out.println("test failed");
        }
*/
        // assert the value
        Assert.assertEquals(expectedError,errorMsg);
        System.out.println("i am here");

        // finding password again as it is discarted when we clicked on login button because the DOM refreshed
        // password text box is displayed
        password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        boolean pswrDisplayed = password.isDisplayed();
        //verify that the text box is displayed
        Assert.assertTrue(pswrDisplayed);

    }

}
