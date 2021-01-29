package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.singaporeair.com/en_UK/ca/home#/book/bookflight");
		driver.manage().window().maximize();
		pause();
		
		List<WebElement> radiobuttons = driver.findElements(By.xpath("//*[@name='book-flight-radio']"));
		System.out.println(radiobuttons.size());
		
		WebElement radio1 = driver.findElement(By.id("bookFlights"));
		WebElement radio2 = driver.findElement(By.id("redeemFlights"));
		
		radio1.click();
		System.out.println(radio1.isSelected());
		System.out.println(radio2.isSelected());
		pause();
		
		radio2.click();
		System.out.println(radio1.isSelected());
		System.out.println(radio2.isSelected());
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
