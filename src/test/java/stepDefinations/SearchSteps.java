package stepDefinations;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.SearchPage;
public class SearchSteps {
	WebDriver driver;
	SearchPage sp ;
	//List<HashMap<String, String>> datamap;
	@Given("the user is on the zigwheels page")
	public void websiteOpening() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Opening the website");
		sp = new SearchPage(BaseClass.getDriver());
		//sp.setSearch(null);
	    
	}
	@When("the user clicks on the search button")
	public void the_user_clicks_on_the_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Clickinh the search area");
		sp.clickSearch();
	}


	@And("the user enters the search value\\({string})")
	public void the_user_enters_the_search_value(String searchValue) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("entering searchvalue");
		sp.setSearch(searchValue);
		sp.setCompanyName();
	}

	
	@Then("check the results based on conditions")
	public void resultPrint() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Capturing results");
		sp.returnResult();
	}

}
