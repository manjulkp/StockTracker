package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyPortfolioPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "new_ticker")
	private WebElement ticker;

	@FindBy(name = "new_units")
	private WebElement units;

	@FindBy(linkText = "add")
	private WebElement add;

	@FindBy(xpath = "//table//child::tr[@data-test='portfolio-item']/child::*")
	private List<WebElement> items;

	@FindBy(xpath = "//table//child::a[contains(text(),'delete')]")
	private WebElement delete;

	@FindBy(linkText = "Get Valuation")
	private WebElement getValuation;

	List<String> storeTicker = new ArrayList<>();
	List<String> tickerItemAdded = new ArrayList<>();
	List<WebElement> deleteElement = new ArrayList<>();

	public MyPortfolioPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 100);
		PageFactory.initElements(driver, this);
	}

	public void launchGetValuationScreen() {
		getValuation.click();
	}

	public void enterTickerDetails(String ticker, String units) {
		this.ticker.sendKeys(ticker);
		this.units.sendKeys(units);
		this.wait.until(ExpectedConditions.visibilityOf(this.ticker));
		if (tickerItemAdded.contains(ticker) == false) {
			tickerItemAdded.add(ticker);
			tickerItemAdded.add(units);
		}
		add.click();
		this.wait.until(ExpectedConditions.visibilityOf(this.delete));
	}

	public void enterTickerDetailsUpdate(String ticker, String units) {
		tickerItemAdded.clear();
		this.ticker.sendKeys(ticker);
		this.units.sendKeys(units);

		tickerItemAdded.add(ticker);
		tickerItemAdded.add(units);

		add.click();
		this.wait.until(ExpectedConditions.visibilityOf(this.delete));
	}

	public boolean getLabelsList() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (WebElement ele : items) {
			if (ele.getText().equals("delete") == false && storeTicker.contains(ele.getText()) == false) {
				storeTicker.add(ele.getText());

			}
		}
		return storeTicker.equals(tickerItemAdded);
	}

	public boolean getLabelsListAfterUpdate() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		storeTicker.clear();

		for (WebElement ele : items) {
			if (ele.getText().equals("delete") == false) {
				storeTicker.add(ele.getText());
			}
		}
		return storeTicker.equals(tickerItemAdded);
	}

	public void delete(int count) {
		for (WebElement ele : items) {
			if (ele.getText().equals("delete")) {
				deleteElement.add(ele);
			}
		}
		int i = 0;
		while (i < count) {
			deleteElement.get(i).click();
			okAlert();
			i++;
		}
		storeTicker.clear();
		tickerItemAdded.clear();
	}

	private void okAlert() {
		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();

		// Displaying alert message
		System.out.println(alertMessage);

		// Accepting alert
		alert.accept();
	}

	public int getAddedItemCount() {
		return deleteElement.size();
	}

	public boolean verifyItemDeleted() {
		try {
			driver.findElement(By.xpath("//td[contains(text(),'" + delete + "')]"));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void deleteAllItem() {
		for (WebElement ele : items) {
			if (ele.getText().equals("delete")) {
				deleteElement.add(ele);
			}
		}
		int i = 0;
		while (i < deleteElement.size()) {
			deleteElement.get(i).click();
			okAlert();
			i++;
		}
		storeTicker.clear();
		tickerItemAdded.clear();
	}

}
