package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        
        Random r = new Random();
        
        //Alkuperäinen, onnistunut kirjautuminen
        /*
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        driver.quit();
        */
        
        
        
        
        
        
        
        
        // epäonnistunut kirjautuminen: oikea käyttäjätunnus, väärä salasana
        
        /*
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("peksi");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        driver.quit();
        */
        
        
        
        
        
        
        
        
        // uuden käyttäjätunnuksen luominen
        
        /*
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("ukkris");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("otra");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        driver.quit();
        */
        
        
        
        
        
        
        
        
        // uuden käyttäjätunnuksen luomisen jälkeen tapahtuva uloskirjautuminen sovelluksesta
        
        
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        
    
        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("otra");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("otra");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        sleep(2);
        element.click();
        
        sleep(3);
        
        element = driver.findElement(By.linkText("logout"));
        sleep(2);
        element.click();
        
        sleep(3);
        
        driver.quit();
        
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
