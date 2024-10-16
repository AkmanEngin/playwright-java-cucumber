package com.isone.pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SearchPage {


    private Page page;
    private final Locator searchField;
    private final Locator searchButton;
    private final Locator sustainabilitySearchResult;
//    private final Locator searchResult;
    private final Locator searchResults;


    public SearchPage(Page page) {
        this.page = page;
        this.searchField = page.locator("#searchfield");
        this.sustainabilitySearchResult = page.locator("//a[@eventid='152696']");
//        this.searchResult = page.locator("//a[@class = 'isonetooltip tooltipstered']");
        this.searchResults = page.locator("//table[contains(@id,'documentsTable')]//tbody//td[1]");
        this.searchButton = page.locator("#submitbutton");
    }

    public void navigateToSearchPage(String url) {
        page.navigate(url);
    }

    public void enterSearchTerm(String searchTerm) {
        this.searchField.fill(searchTerm);
    }

    public void clickSearchButton() {
        this.searchButton.click();
    }
    public String verifySearchResult(int i) {
        return this.searchResults.nth(i).textContent();
    }

}