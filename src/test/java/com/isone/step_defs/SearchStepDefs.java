package com.isone.step_defs;

import com.isone.pages.HomePage;
import com.isone.pages.SearchPage;
import com.isone.utilities.ConfigurationReader;
import com.isone.utilities.Driver;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;


public class SearchStepDefs {


    SearchPage searchPage;

    @Given("user enters {string} into the search bar")
    public void userEntersIntoTheSearchBar(String searchTerm) {
        // Write code here that turns the phrase above into concrete actions
        Page page = Driver.getInstance().getBrowser().newPage();
        searchPage = new SearchPage(page);
        searchPage.navigateToSearchPage(ConfigurationReader.getProperty("url"));
        searchPage.enterSearchTerm(searchTerm);
    }

    @When("user clicks on the search button")
    public void userClicksOnTheSearchButton() {
        searchPage.clickSearchButton();
    }

    @Then("user should see search results for {string}")
    public void userShouldSeeSearchResultsFor(String searchResult) {

    }

    @Then("user should see {string} in the top {int} results")
    public void userShouldSeeInTheTopResults(String searchResult, int resultsCount) {
        for(int i=0; i < resultsCount; i++){
            String actualResult = searchPage.verifySearchResult(i);
            assertTrue( "Search results does not contain the searched result. " + "Actual: " + actualResult + " Expected: " + searchResult, actualResult.toLowerCase().contains(searchResult.toLowerCase()));
        }
    }
}
