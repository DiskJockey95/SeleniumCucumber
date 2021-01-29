package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.sugarcrm.com/request-demo/");
		driver.manage().window().maximize();
		pause();
		Actions actions = new Actions(driver);
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(checkboxes.size());
		
		WebElement checkbox = driver.findElement(By.name("interest_market_c"));
		
		WebElement radio = driver.findElement(By.id("doi0"));
		actions.moveToElement(radio);
		actions.perform();
		pause();
		
		checkbox.click();
		pause();
		
		checkbox.click();
		pause();
		
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
