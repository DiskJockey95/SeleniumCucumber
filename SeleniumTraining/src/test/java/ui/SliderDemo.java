package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/slider/#colorpicker");
		driver.manage().window().maximize();

		pause();

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));

		WebElement slider1 = driver.findElement(By.xpath("//*[@id=\"red\"]/span"));
		WebElement slider2 = driver.findElement(By.xpath("//*[@id=\"green\"]/span"));
		WebElement slider3 = driver.findElement(By.xpath("//*[@id=\"blue\"]/span"));

		Actions action = new Actions(driver);
		action.dragAndDropBy(slider1, -250, 0).perform();
		
		pause();
		
		action.dragAndDropBy(slider2, 50, 0).perform();
		
		pause();
		
		action.dragAndDropBy(slider3, -80, 0).perform();

		pause();

		driver.switchTo().parentFrame();

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
