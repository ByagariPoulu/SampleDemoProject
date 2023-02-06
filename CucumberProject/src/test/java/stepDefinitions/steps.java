package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;

public class steps {

	public WebDriver driver;
	public LoginPage lp;


	@Given("^User Launch Chrome browser$")
	public void user_Launch_Chrome_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Poulu\\eclipse-workspace\\CucumberProject\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		lp= new LoginPage(driver);

	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url) throws Throwable {
		driver.get(url);
	}

	@When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String uname, String pwd) throws Throwable {

		lp.setUserName(uname);
		lp.setPassword(pwd);
	}

	@When("^Click on Login$")
	public void click_on_Login() throws Throwable {

		lp.clickLogin();
	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_Title_should_be(String title) throws Throwable {

		if(driver.getPageSource().contains("Login was unsuccessful."))
		{
			driver.close();
			Assert.assertTrue(false); //import Assert from org.junit
		}
		else
		{
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("^User click on Logout link$")
	public void user_click_on_Logout_link() throws Throwable {

		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {

		driver.quit();
	}

}
	

