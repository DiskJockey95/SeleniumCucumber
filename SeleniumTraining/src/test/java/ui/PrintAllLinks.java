package ui;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllLinks {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =  new ChromeDriver();
		
		driver.get("https://google.ca");
		driver.manage().window().maximize();
		
		List<WebElement> elements = driver.findElementsByTagName("a");
//		List<WebElement> elements = driver.findElementsByXPath("//a");
		System.out.println(elements.size());
		
		for(WebElement element: elements) {
			System.out.println(element.getAttribute("href"));
			System.out.println(element.getText());
		}		
		driver.close();
		
	}
}
