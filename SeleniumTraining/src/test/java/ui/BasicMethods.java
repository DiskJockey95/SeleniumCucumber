package ui;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicMethods {

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
		
		driver.get("https://www.saucedemo.com");
		
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		//System.out.println(driver.getPageSource());
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
		
		List<WebElement> webElements = driver.findElements(By.xpath("//div[@class=\"inventory_list\"]/div"));
		System.out.println(webElements);
		
		driver.navigate().to("https://www.sugarcrm.com");
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		
		driver.findElement(By.xpath("//*[@id=\"mega-menu-item-44\"]/a/span")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		
		//driver.switchTo().frame(0);
		
		driver.close();
	}
}
