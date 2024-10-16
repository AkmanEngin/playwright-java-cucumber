package com.isone.step_defs;

import com.isone.pages.HomePage;
import com.isone.utilities.ConfigurationReader;
import com.isone.utilities.Driver;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class HomePageStepDefs {

    HomePage homePage;

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Page page = Driver.getInstance().getBrowser().newPage();
        homePage = new HomePage(page);
        homePage.navigateTo(ConfigurationReader.getProperty("url"));

    }

    @Then("user should be able to see title {string}")
    public void user_should_be_able_to_see_title(String expectedTitle) {
        Assert.assertEquals(expectedTitle, homePage.getPage().title());
    }


}
