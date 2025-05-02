package pageObjects;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class SearchPage extends BasePage
{   
	WebDriver driver;
	Thread thread = new Thread();
	String bikeName;
	String expectedLaunchDate;
	String priceExpected;
	double originalPrice;
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}	
		@FindBy(xpath="//*[@id=\'headerSearch\']")
		WebElement searchBox;
		@FindBy(xpath="//*[@id=\"ui-id-1\"]/li[1]/a")
		WebElement search1;
		@FindBy(xpath="//*[@id=\'makeId\']")
		WebElement companyButton;
		@FindBy(xpath = "//tbody/tr/td[2]")
		List<WebElement> priceList;
		@FindBy(xpath = "//span[normalize-space()='Read More']")
		WebElement clickReadMore;
		
		public void clickSearch() {
			searchBox.click();
		}
		public void setSearch(String searchValue) throws InterruptedException
		{
			searchBox.clear();
			searchBox.sendKeys(searchValue);
			Thread.sleep(2000);
			search1.click();
		}
		public void setCompanyName() {
			Select select = new Select(companyButton);
			select.selectByVisibleText("Honda");		
		}
		public void returnResult() throws InterruptedException {
		        //Thread.sleep(2000);
			clickReadMore.click();
			for (WebElement priceElement : priceList) {
				try {
					priceExpected = priceElement.getText();
					originalPrice = convertPrice(priceExpected);
		            if (originalPrice < 400000.0) {
		                // Find bike name and launch date elements (adjust XPaths if needed)
		            	WebElement bikeNameElement = priceElement.findElement(By.xpath(".//preceding-sibling::td[1]"));
		            	bikeName = bikeNameElement.getText();
		                WebElement launchDateElement = priceElement.findElement(By.xpath(".//following-sibling::td[1]"));
		                expectedLaunchDate = launchDateElement.getText();
		                System.out.println("Bike Name: " + bikeName);
		                System.out.println("Expected Price: " + priceExpected);
		                System.out.println("Expected Launch Date: " + expectedLaunchDate);
		                System.out.println("------------------------");
		            }
				}
		        catch (NoSuchElementException e) {
		        	System.err.println("Error: Element not found for price: " + priceElement.getText());
		        }
			}
		}
		public static Double convertPrice(String input) {
	        // Handle cases with spaces and commas
	        input = input.replaceAll("[\\s,]", "");

	        // Remove "Rs." prefix if present
	        if (input.toLowerCase().startsWith("rs.")) {
	            input = input.substring(3);
	        }

	        // Enhanced pattern for number extraction (handles decimals, optional space, and unit)
	        Pattern pattern = Pattern.compile("^([0-9]+(\\.[0-9]+)?)\\s*(lacs|lakh)?$", Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(input);

	        if (matcher.find()) {
	            double number = Double.parseDouble(matcher.group(1));
	            String unit = matcher.group(3);

	            if (unit != null) { // Unit is present (optional)
	                if (unit.equalsIgnoreCase("lacs") || unit.equalsIgnoreCase("lakh")) {
	                    return number * 100000;
	                } else {
	                    throw new IllegalArgumentException("Invalid unit: " + unit);
	                }
	            } else {
	                return number; // No unit, return number as is
	            }
	        } else {
	            throw new IllegalArgumentException("Invalid price format. Expected format: 'number' or 'number (lacs|lakh)'");
	        }
	    }
}