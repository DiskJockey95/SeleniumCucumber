package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEventsDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://extendsclass.com/text-compare.html");
		driver.manage().window().maximize();
		pause();

		WebElement text1 = driver.findElement(By.xpath("//*[@id=\"dropZone\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[7]/pre/span"));
		Actions action = new Actions(driver);
		
		action.keyDown(text1, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		pause();
		
		WebElement text2 = driver.findElement(By.xpath("//*[@id=\"dropZone2\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[5]/pre"));
		action.keyDown(text2, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
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
