package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortfolioValuePage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "portfolio-report")
	private WebElement portfolioReport;

	@FindBy(id = "portfolio-value")
	private WebElement portfolioValue;
	
	public PortfolioValuePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 100);
		PageFactory.initElements(driver, this);
	}

	public String getValue() {
		this.wait.until(ExpectedConditions.visibilityOf(this.portfolioValue));
		return portfolioValue.getText();
	}

	public boolean isGetValuationScreenLaunched() {
		return portfolioReport.isDisplayed();
	}

}
