package stepDefinations;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
public class LoginSteps {
	WebDriver driver;
	LoginPage lp ;
	SearchPage sp ;
	Thread thread = new Thread();
	//List<HashMap<String, String>> datamap;
	@Given("the user navigates to the zigwheels page")
	public void websiteStarting() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Goto The Website");
		lp= new LoginPage(BaseClass.getDriver());
		//sp.setSearch(null);
	    
	}
	@When("the user clicks on the login button")
	public void clickLogin() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		lp.loginButtonClick();
		Thread.sleep(3000);
	}


	@And("clicks on the google")
	public void clickGoogle() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		BaseClass.getLogger().info("Clicking on google button");
		lp.googleButtonClick();
		Thread.sleep(3000);
		
	}
	@Then("the user enters the value as {string}")
	public void errorMessageCapture(String email) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		lp.SwitchTab();
		Thread.sleep(2000);
		lp.setEmail(email);
	}
	@Then("captures the error message")
	public void Errormessaage() {
		BaseClass.getLogger().info("Capturing results");
		System.out.print(lp.getErrorMessage());
	}

}
