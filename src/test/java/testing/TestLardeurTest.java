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

//import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TestLardeurTest {
WebDriver driver;
private String BROWSER=System.getProperty("browser");

@Before

public void setup() {
	//URL e=this.getClass().getClassLoader().getResource("driver.chromedriver.exe");
	//File file = new File(((URL)Objects.requireNonNull(e)).getFile());
	if 	(BROWSER.equalsIgnoreCase("chrome"))	{
	System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
	driver = new ChromeDriver();
	}
	else if (BROWSER.equalsIgnoreCase("gecko"))	{
			System.setProperty("webdriver.gecko.driver","src/main/resources/driver/geckodriver.exe");
	}
	}

//@After
public void teardown() {
	driver.quit();
}

 @Test
public void TestLardeur() throws Exception {

	driver.get("https://fr.wowhead.com");
	
	//passer les cookies
	driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//div[@class='notifications-dialog-buttons']/button[text()='Refuser']")).click();
	
	//saisir une recherche et la valider
	WebElement element = driver.findElement(By.xpath("//*[@name='q']"));
	element.click();
	element.clear();
	element.sendKeys("Lardeur");
	driver.findElement(By.xpath("//a[@class='header-search-button fa fa-search']")).click();
	
	assertTrue(driver.findElement(By.xpath("//div[@class='text']/h2[contains(text(),'Premiers Résultats pour: ')]")).isDisplayed());
	System.out.print("Premiers Résultats pour: Lardeur");
	
	//cliquer sur la tete de mort "lardeur"
	driver.findElement(By.xpath("//a[@class='top-results-result-cover'][@href='/npc=448/lardeur']")).click();
	
	//cliquer sur un butin
	

}
 
 public void ecrireChampTxt (WebElement e, String s) {
		e.clear();
		e.sendKeys(s);

}
}
