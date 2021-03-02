package testing;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.util.Objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TestHotelTest {
WebDriver driver;


@Before

public void setup() {
	System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
	driver = new ChromeDriver();
	}
	

//@After
public void teardown() {
	driver.quit();
}

 @Test
public void TestLardeur() throws Exception {

	driver.get("http://192.168.105.76:9999/HotelWebapp-1.0-SNAPSHOT");
	
	//passer les cookies
	driver.findElement(By.xpath("//select[@name='ville']")).click();
	//Thread.sleep(10000);
	driver.findElement(By.xpath("//select[@name='ville']/option[@value='Londres']")).click();
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	

	
	assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'Hôtels disponibles à ')]")).isDisplayed());
	System.out.print("Hôtels disponibles à Londres");
	

}
}
