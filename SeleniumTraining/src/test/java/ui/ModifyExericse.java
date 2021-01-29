package ui;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ModifyExericse {

	public static String browser = "Chrome";
	public static WebDriver driver = null;

	@Before
	public void setup() {
		
		if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}
	
	@Test
	public void openGoogleAndSeeThatSearchIsVisible() {
		driver.get("https://google.ca");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.name("q"));
		Assert.assertTrue(element.isDisplayed());
	}
	
	@Test
	public void openGoogleAndFindSearchSendingSeleniumAsKey() {
		driver.get("https://google.ca");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("selenium");
		element.sendKeys(Keys.RETURN);
		assert(driver.getTitle().equals("selenium - Google Search"));
		
	}
	
	@After
	public void close() {
		driver.close();
	}
}
