package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSteps {
	
	WebDriver driver = null;

	@Given("I am on the google search page")
	public void i_am_on_the_google_search_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.ca");
		driver.manage().window().maximize();
	}

	@When("I enter something in the search bar")
	public void i_enter_something_in_the_search_bar() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("cucumber");
	}

	@When("I click search")
	public void i_click_search() {
		driver.findElement(By.name("q")).submit();
	}

	@Then("I should see the results on the next page")
	public void i_should_see_the_results_on_the_next_page() {
		if(driver.findElement(By.id("result-stats")).getText().contains("results"))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		driver.close();
		driver.quit();
	}
}
