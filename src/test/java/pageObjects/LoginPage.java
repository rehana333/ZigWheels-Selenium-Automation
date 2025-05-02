package pageObjects;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"forum_login_title_lg\"]")
	WebElement loginButton;
	@FindBy(xpath="//*[@id=\"myModal3-modal-content\"]/div[1]/div/div[3]/div[6]/div")
	WebElement googleButton;
	
	@FindBy(xpath = ("//*[@id=\'identifierId\']"))
	WebElement inputEmail;
	@FindBy(xpath = ("//*[@id=\"identifierNext\"]/div/button/span"))
	WebElement nextButton;
	@FindBy(xpath = ("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div[1]/form/span/section/div/div/div[1]/div/div[2]/div[2]/div"))
	WebElement errorMessage;
	
	public void loginButtonClick() throws InterruptedException {
		loginButton.click();
	}
	
	public void googleButtonClick() {
        // Wait for page title to indicate full load (assuming it changes)

        // Now wait for Google button to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"myModal3-modal-content\"]/div[1]/div"))));
        googleButton.click();
    }
	public void SwitchTab() {
		// Get the current window handle (current tab)
		String originalWindow = driver.getWindowHandle();
		// Get all window handles (all open tabs)
		Set<String> allWindows = driver.getWindowHandles();

		// Switch to the new tab (iterate through handles to find the new one)
		for (String windowHandle : allWindows) {
		    if (!originalWindow.equals(windowHandle)) {
		        driver.switchTo().window(windowHandle); 
		        break; 
		    }
		}
	}
	public void setEmail(String email) {
		inputEmail.sendKeys(email);
		nextButton.click();
	}
	public  String getErrorMessage() {
		String Message = errorMessage.getText();
//		System.out.println(Message);
		return Message;
		
		
	}
	
}
	

