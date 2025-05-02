package stepDefinations;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.UsedCarPage;
public class UsedCarSteps {
	WebDriver driver;
	UsedCarPage ucp;
	Thread thread = new Thread();
	//List<HashMap<String, String>> datamap;
	@Given("the user lands to the zigwheels page")
	public void websiteStarting() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Goto The Website");
		ucp= new UsedCarPage(BaseClass.getDriver());
		//sp.setSearch(null);
	    
	}
	@When("the user clicks on the More and Used car option")
	public void clickUsedCar() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		ucp.selectUsedCarIcon();
		Thread.sleep(3000);
	}


//	@And("selects the desired city")
//	public void clickCity() throws InterruptedException {
//	    // Write code here that turns the phrase above into concrete actions
//		Thread.sleep(3000);
//		BaseClass.getLogger().info("Clicking on the desired city");
//		ucp.selectDesiredCity();
//		Thread.sleep(3000);
//		
//	}
	@Then("captures the most popular details")
	public void Errormessaage() {
		BaseClass.getLogger().info("Capturing results");
		ucp.popularCarList();
	}

}
