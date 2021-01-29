package ui;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		pause();
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div[5]/div/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[1]/div/a")).click();
		pause();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterate = windows.iterator();
		
		String parentWindow = iterate.next();
		String childWindow = iterate.next();
		
		System.out.println(parentWindow);
		System.out.println(childWindow);
		
		driver.switchTo().window(childWindow);
		
		driver.findElement(By.name("UserFirstName")).sendKeys("first");
		driver.findElement(By.name("UserLastName")).sendKeys("last");
		pause();
		
		driver.close();
		driver.switchTo().window(parentWindow);
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
