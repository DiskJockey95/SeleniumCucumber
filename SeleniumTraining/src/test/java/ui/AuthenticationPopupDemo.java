package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopupDemo {

	public static String browser = "chrome";
	public static String user = "admin";
	public static String pass = "admin";
	public static WebDriver driver = null;

	public static void main(String[] args) {

		DesiredCapabilities handleSSLError = new DesiredCapabilities();
		handleSSLError.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		handleSSLError.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.merge(handleSSLError);
			driver = new FirefoxDriver(ffOptions);

		} else if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions cOptions = new ChromeOptions();
			cOptions.merge(handleSSLError);
			driver = new ChromeDriver(cOptions);

		} else if (browser.equals("edge")) {

			WebDriverManager.edgedriver().setup();

			EdgeOptions eOptions = new EdgeOptions();
			eOptions.merge(handleSSLError);
			driver = new EdgeDriver(eOptions);

		}

		driver.get("https://" + user + ":" + pass + "@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();

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
