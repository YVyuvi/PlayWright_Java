package com.PlaywrightSessions;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Stress_Testing {

	@Test(invocationCount = 10, threadPoolSize = 10)
	public void test1() {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext brcx = browser
				.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("Videos")));

		// BrowserContext brcx = browser.newContext(new
		// Browser.NewContextOptions().setRecordVideoSize(1000,500).setRecordVideoDir(Paths.get("Videos")));
		Page page = brcx.newPage();

		page.navigate("https://omb-test.chq.ei/omb/Login.jsp");
		page.locator("#userID").fill("qae-ebcsysadmin");
		page.locator("#password").fill("qainternal!");
		page.locator("#loginbutton").click();

		page.locator("//frame[@name='mainContent']")
				.waitFor(new Locator.WaitForOptions().setTimeout(1000).setState(WaitForSelectorState.VISIBLE));

		page.frameLocator("//frame[@name='mainContent']").locator("//a[@title='Logout']").scrollIntoViewIfNeeded();
		page.frameLocator("//frame[@name='mainContent']").locator("//a[@title='Logout']").click();

		if (page.title().contains("Expeditors - Order Management Booking Login")) {
			System.out.println("Passed");
		}

		page.close();
		brcx.close();
		browser.close();
	}
}
