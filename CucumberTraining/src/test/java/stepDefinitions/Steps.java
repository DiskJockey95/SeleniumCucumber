package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {

	WebDriver driver = null;

	@Given("^Open chrome and launch the application$")
	public void openChromeAndLaunchTheApplication1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
	}

	@When("^Enter the correct username and password$")
	public void enterCorrectUsernameAndPassword() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
	}
	
	@Then("^Verify Sucessful Login$")
	public void verifySuccessfulLogin() {
		assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
		driver.close();
	}

	@When("^Enter the incorrect username and password$")
	public void enterIncorrectUsernameAndPassword() {
		driver.findElement(By.id("user-name")).sendKeys("standarduser");
		driver.findElement(By.id("password")).sendKeys("secretsauce");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]")).click();
	}

	@Then("^Verify unsucessful Login$")
	public void verifyUnsuccessfulLogin() {
		assertNotEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
		driver.close();
	}
}
