package com.isone.pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {


    private final Page page;
//    private final Locator searchField;

    public HomePage(Page page) {
        this.page = page;
//        this.searchField = page.locator("#searchfield");
    }

    public void navigateTo(String url) {
        page.navigate(url);
    }

    public void search(String word) {
        page.fill("input[name='q']", word);

    }


    public static HomePage openLoginPage(Browser browser, String url) {
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate(url);
        return new HomePage(page);
    }

    public void close() {
        page.close();
    }
    public  Page getPage(){

        return page;
    }

}
