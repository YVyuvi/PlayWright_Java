package com.PlaywrightSessions;

import com.microsoft.playwright.*;
//import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Dayy19_Waits {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		page.navigate("https://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html",
				new Page.NavigateOptions().setTimeout(60000));

		// page.setDefaultNavigationTimeout(60000);
		page.setDefaultTimeout(5000);

		page.locator("//button[text()='Click me to start timer']").click();

		page.locator("//p[text()='WebDriver']")
				.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(20000));

		System.out.println("Is Visible?" + page.locator("//p[text()='WebDriver']").isVisible());

		// page.waitForLoadState(LoadState.NETWORKIDLE);

		page.close();
		browser.close();

	}

}
