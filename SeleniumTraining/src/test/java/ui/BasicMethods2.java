package ui;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicMethods2 {

	public static String browser = "Chrome";

	public static void main(String[] args) {

		WebDriver driver = null;
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
		
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		driver.manage().window().maximize();
		
		WebElement dropDown = driver.findElement(By.id("multi-select"));
		Select select = new Select(dropDown);
		
		select.selectByValue("California");
		pause();
		select.selectByIndex(5);
		pause();
		List<WebElement> allItems = select.getAllSelectedOptions();
		System.out.println(allItems.size());
		
		select.deselectAll();
		pause();
		
		select.selectByValue("California");
		pause();
		select.selectByIndex(5);
		pause();
		select.deselectByIndex(5);
		pause();
		allItems = select.getAllSelectedOptions();
		System.out.println(allItems.size());
		
		driver.close();
	}

	private static void pause() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
