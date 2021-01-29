package ui;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicExercise {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.bbc.co.uk");
		System.out.println(driver.getCapabilities().getBrowserName());
		System.out.println(driver.getCapabilities().getVersion());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		pause();
		driver.manage().window().maximize();
		driver.navigate().refresh();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		pause();
		driver.get("https://google.ca");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		pause();
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		pause();
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
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
