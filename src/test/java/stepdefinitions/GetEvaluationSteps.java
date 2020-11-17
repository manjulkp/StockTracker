package stepdefinitions;

import java.math.BigDecimal;

import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.MyPortfolioPage;
import pages.PortfolioValuePage;

public class GetEvaluationSteps extends TestBase {
	private MyPortfolioPage portfolioPage;
	private HomePage homePage;
	private PortfolioValuePage portfolioValuePage;

	@Before()
	public void intializePage() {
		portfolioPage = new MyPortfolioPage(TestBase.driver);
		homePage = new HomePage(TestBase.driver);
		portfolioValuePage = new PortfolioValuePage(TestBase.driver);
	}
	
	@Then("verify that the value is zero")
	public void verify_that_the_value_is_zero() {
		Assert.assertTrue(portfolioValuePage.getValue().equals("0.00"),"The value is not 0.00");
	}

	@Then("verify that the value of that day is displayed")
	public void verify_that_the_value_of_that_day_is_displayed() {
		String amount = portfolioValuePage.getValue();
		amount = amount.replaceAll("[,]", " "); 
		BigDecimal value =  new BigDecimal(amount);
		Assert.assertTrue(value.compareTo(BigDecimal.ZERO) > 0, "The value is zero ..please check");	
	}

	
	@When("the user navigates to Portfolio Value")
	public void the_user_navigates_to_Portfolio_Value() {
		portfolioPage.launchGetValuationScreen();
	}


}
