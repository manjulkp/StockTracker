package stepdefinitions;

import org.junit.Assert;

import base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.MyPortfolioPage;

public class MyPortfolioSteps extends TestBase {
	private MyPortfolioPage portfolioPage;
	private HomePage homePage;

	@Before()
	public void intializePage() {
		portfolioPage = new MyPortfolioPage(TestBase.driver);
		homePage = new HomePage(TestBase.driver);
	}

	@Given("the application is launched")
	public void the_application_is_launched() {
		Assert.assertTrue("The Page is not launched", homePage.isHomePageLaunched());
		homePage.launchMyPortfolio();
	}

	@When("the user adds a ticker with units")
	public void the_user_adds_a_ticker_with_units() {
		portfolioPage.enterTickerDetails(testDataDetails.get("TestData.TickerAdd.name_1"),
				testDataDetails.get("TestData.TickerAdd.units_1"));
	}

	@Then("verify that the ticker is added")
	public void verify_that_the_ticker_is_added() {
		Assert.assertTrue("The ticker is not added", portfolioPage.getLabelsList());
	}

	@Then("verify that the ticker is updated")
	public void verify_that_the_ticker_is_updated() {
		Assert.assertTrue("The ticker is not added", portfolioPage.getLabelsListAfterUpdate());
	}

	@When("the user delete the ticker")
	public void the_user_delete_the_ticker() {
		portfolioPage.delete(1);
	}

	@Then("the ticker is not present")
	public void the_ticker_is_not_present() {
		Assert.assertFalse("The ticker is not deleted", portfolioPage.verifyItemDeleted());
	}

	@When("the user adds a ticker with negative units")
	public void the_user_adds_a_ticker_with_negative_units() {
		portfolioPage.enterTickerDetails(testDataDetails.get("TestData.TickerAdd.name_negativecase"),
				testDataDetails.get("TestData.TickerAdd.units_negativecase"));
	}

	@Then("verify that the ticker is not added")
	public void verify_that_the_ticker_is_not_added() {
		Assert.assertFalse("The ticker is not added", portfolioPage.verifyItemDeleted());
	}

	@When("the user tries to add the same ticker with same units")
	public void the_user_tries_to_add_the_same_ticker_with_same_units() {
		portfolioPage.enterTickerDetails(testDataDetails.get("TestData.TickerAdd.name_samecase"),
				testDataDetails.get("TestData.TickerAdd.units_samecase"));
	}

	@Then("verify that the ticker is added previously is not changed")
	public void verify_that_the_ticker_is_added_previously_is_not_changed() {
		Assert.assertTrue("The ticker is not added", portfolioPage.getLabelsList());
	}

	@When("the user adds a second type of ticker with units")
	public void the_user_adds_a_second_type_of_ticker_with_units() {
		portfolioPage.enterTickerDetails(testDataDetails.get("TestData.TickerAdd.name_2"),
				testDataDetails.get("TestData.TickerAdd.units_2"));
	}

	@When("the user delete all added ticker")
	public void the_user_delete_all_added_ticker() {
		portfolioPage.deleteAllItem();
	}

	@When("the user adds the ticker with more units")
	public void the_user_adds_the_ticker_with_more_units() {
		portfolioPage.enterTickerDetailsUpdate(testDataDetails.get("TestData.TickerAdd.name_1"),
				testDataDetails.get("TestData.TickerAdd.units_more"));
	}

	@When("the user adds the ticker with less units")
	public void the_user_adds_the_ticker_with_less_units() {
		portfolioPage.enterTickerDetailsUpdate(testDataDetails.get("TestData.TickerAdd.name_1"),
				testDataDetails.get("TestData.TickerAdd.units_less"));
	}
	
	@When("the user launch view portfolio")
	public void the_user_launch_view_portfolio() {
	   homePage.launchMyPortfolio();
	}
}
