package ui;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshotsDemo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		File screenshotFile;

		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		takeScreenShot(screenshotFile);
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div[5]/div/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[1]/div/a")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterate = windows.iterator();
		
		String parentWindow = iterate.next();
		String childWindow = iterate.next();
		
		System.out.println(parentWindow);
		System.out.println(childWindow);
		
		driver.switchTo().window(childWindow);
		
		driver.findElement(By.name("UserFirstName")).sendKeys("first");
		driver.findElement(By.name("UserLastName")).sendKeys("last");
		screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		takeScreenShot(screenshotFile);
		
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.close();
	}

	private static void takeScreenShot(File screenshotFile) {
		Date now = new Date();
		String fileName = now.toString().replace(" ", "-").replace(":", "-");
		try {
			FileUtils.copyFile(screenshotFile, new File(".//screenshot/" + fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
