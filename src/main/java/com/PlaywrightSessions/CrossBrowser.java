package com.PlaywrightSessions;

import java.util.regex.Pattern;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class CrossBrowser {

	Playwright pw;
	Browser browser;
	Page page;

	@Parameters("BrowserName")
	@BeforeMethod
	public void setup(@Optional("safari") String browserName) {
		pw = Playwright.create();
		BrowserType bt = null;
		if (browserName.equalsIgnoreCase("chrome")) {
			bt = pw.chromium();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			bt = pw.firefox();
		} else if (browserName.equalsIgnoreCase("safari")) {
			bt = pw.webkit();
		}
		browser = bt.launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
	}

	@Test
	public void test() {

		page.navigate("https://freelance-learn-automation.vercel.app/login");
		PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");

		// page.locator("#email1").fill("admin@email.com");
		// page.locator("xpath=//input[@name='email1']").fill("admin@email.com");
		// page.locator("css=input[name='email1']").fill("admin@email.com");
		page.getByPlaceholder("Enter Email").fill("admin@email.com");
		page.getByPlaceholder("Enter Password").fill("admin@123");
		// page.getByText("Sign in").nth(1).click();
		page.getByText("Sign in").last().click();

		PlaywrightAssertions.assertThat(page.locator(".welcomeMessage")).containsText("Welcome");
		String title = page.title();
		System.out.println("Title is : " + title);

		String url = page.url();
		System.out.println("URL is : " + url);

		page.getByAltText("menu").click();
		page.getByText("Sign out").click();

		PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("login"));
	}

	@AfterMethod
	public void teardown() {
		page.close();
		browser.close();
		pw.close();
	}
}
