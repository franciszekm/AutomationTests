import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;




public class ChromeWebTest {
    @Test
    public void demoTest() {

        //Webdriver settings
        System.setProperty("webdriver.chrome.driver","/Users/f/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        /* Login on Wikipedia with invalid login TC
        * TC scenario: Verify if a user will be able to login with a invalid login and valid password.
        * TC expected result: User is not able to login and information is printed on screen
        *
        * Preconditions: Given data:
        * Valid Login: "TestAutomationUser"
        * Valid Password: "ZXCasd123!@#"
        * */

        //Step 1 - open Wikipedia main page
        //Expected Result - main page is open
        driver.navigate().to("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");

        //Step 2 - click on "zaloguj sie" button
        //Expected Result - Zaloguj się page is open
        WebElement login = driver.findElement(By.id("pt-login"));
        login.click();

        //Step 3 - Put invalid login to the Login(TextField)
        //Expected Result - Login is in textfield
        WebElement userLogin = driver.findElement(By.id("wpName1"));
        userLogin.sendKeys("FakeLogin");

        //Step 4 - Put valid password to the Password(TextField)
        //Expected Result - password is in textfield

        WebElement password = driver.findElement(By.id("wpPassword1"));
        password.sendKeys("ZXCasd123!@#");

        //Step 5 - Click Zaloguj Sie button
        //Expected Result - Page is loading. Alert box with information about wrong login is shown
        WebElement loginButton = driver.findElement(By.id("wpLoginAttempt"));
        loginButton.click();

        //Finding box with error information
        String errorBox = driver.findElement(By.xpath("//*[@id=\"userloginForm\"]/form/div[1]")).getText();
        String expected = "Podany login lub hasło są nieprawidłowe. Spróbuj jeszcze raz.";

        //Compare if error on webpage is equal to string with error in documentation
        if (errorBox.equals(expected)){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!\nTest passed succesfully\n!!!!!!!!!!!!!!!!!!!!!!!!");
        } else {
            System.out.println("Test failed");
        }
    }

    @Test
    public void demoTest2(){

        //Webdriver settings
        System.setProperty("webdriver.chrome.driver","/Users/f/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();


        /* Login on Wikipedia with valid login and password TC
         * TC scenario: Verify if a user will be able to login with a valid email address and valid password.
         * TC expected result: User is able to login
         *
         * Preconditions: Given data:
         * Valid Login: "TestAutomationUser"
         * Valid Password: "ZXCasd123!@#"
         * */


        //Step 1 - open Wikipedia main page
        //Expected Result - main page is open
        driver.navigate().to("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");

        //Step 2 - click on "zaloguj sie" button
        //Expected Result - Zaloguj się page is open
        WebElement login = driver.findElement(By.id("pt-login"));
        login.click();

        //Step 3 - Put invalid login to the Login(TextField)
        //Expected Result - Login is in textfield
        WebElement userLogin = driver.findElement(By.id("wpName1"));
        userLogin.sendKeys("TestAutomationUser");


        //Step 4 - Put valid password to the Password(TextField)
        //Expected Result - password is in textfield

        WebElement password = driver.findElement(By.id("wpPassword1"));
        password.sendKeys("ZXCasd123!@#");

        //Step 5 - Click Zaloguj Sie button
        //Expected Result - Welcome page is loading. Page loaded. Logged user name is displayed.
        WebElement loginButton = driver.findElement(By.id("wpLoginAttempt"));
        loginButton.click();

        //user name is displayed in element
        String userName = driver.findElement(By.xpath("//*[@id=\"pt-userpage\"]/a/span")).getText();
        String expecteduserName = "TestAutomationUser";

        //Compare if error on webpage is equal to string with error in documentation
        if (userName.equals(expecteduserName)){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!\nTest passed succesfully\n!!!!!!!!!!!!!!!!!!!!!!!!");
        } else {
            System.out.println("Test failed");
        }

    }
}
