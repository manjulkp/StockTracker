$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/featurefile/GetValuation.feature");
formatter.feature({
  "name": "MyPortfolio feature",
  "description": "  As a user ,I can add ,delete ticker",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@getevaluation"
    }
  ]
});
formatter.scenario({
  "name": "User can add a new ticker with valid units",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@getevaluation"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the application is launched",
  "keyword": "Given "
});
formatter.match({
  "location": "MyPortfolioSteps.the_application_is_launched()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to Portfolio Value",
  "keyword": "When "
});
formatter.match({
  "location": "GetEvaluationSteps.the_user_navigates_to_Portfolio_Value()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the value is zero",
  "keyword": "Then "
});
formatter.match({
  "location": "GetEvaluationSteps.verify_that_the_value_is_zero()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user launch view portfolio",
  "keyword": "When "
});
formatter.match({
  "location": "MyPortfolioSteps.the_user_launch_view_portfolio()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user adds a ticker with units",
  "keyword": "When "
});
formatter.match({
  "location": "MyPortfolioSteps.the_user_adds_a_ticker_with_units()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the ticker is added",
  "keyword": "Then "
});
formatter.match({
  "location": "MyPortfolioSteps.verify_that_the_ticker_is_added()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to Portfolio Value",
  "keyword": "When "
});
formatter.match({
  "location": "GetEvaluationSteps.the_user_navigates_to_Portfolio_Value()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the value of that day is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "GetEvaluationSteps.verify_that_the_value_of_that_day_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user launch view portfolio",
  "keyword": "When "
});
formatter.match({
  "location": "MyPortfolioSteps.the_user_launch_view_portfolio()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user delete the ticker",
  "keyword": "And "
});
formatter.match({
  "location": "MyPortfolioSteps.the_user_delete_the_ticker()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the ticker is not present",
  "keyword": "Then "
});
formatter.match({
  "location": "MyPortfolioSteps.the_ticker_is_not_present()"
});
formatter.result({
  "status": "passed"
});
});