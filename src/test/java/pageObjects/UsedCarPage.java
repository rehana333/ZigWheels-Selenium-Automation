package pageObjects;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsedCarPage extends BasePage {

	public UsedCarPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//*[@id=\"headerNewVNavWrap\"]/nav/ul/li[5]/span")
	WebElement icon;
	@FindBy(xpath="//a[@title='Used Cars']")
	WebElement usedCarOption;
	@FindBy(xpath="//*[@id=\"popularCityList\"]/li[7]/a")
	WebElement desiredCity;
	@FindBy(xpath = "//ul[@class = 'zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']/li/label")
	List<WebElement> popularCars;
	public void selectUsedCarIcon() {
		icon.click();
		usedCarOption.click();
	}
	public void selectDesiredCity() {
		desiredCity.click();
	}
	public void popularCarList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	            By.xpath("//ul[@class = 'zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']/li/label")));
		for(WebElement e : popularCars) {
			String CarNames= e.getText();
			System.out.println(CarNames);
		}
	}
}
