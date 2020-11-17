package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "portfolio-report")
	private WebElement portfolioReport;

	@FindBy(linkText = "View Portfolio")
	private WebElement viewPortfolio;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public boolean isHomePageLaunched() {
		return portfolioReport.isDisplayed();
	}

	public void launchMyPortfolio() {
		 viewPortfolio.click();
	}

}
