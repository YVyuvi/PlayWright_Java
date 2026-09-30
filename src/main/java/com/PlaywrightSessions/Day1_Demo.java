package com.PlaywrightSessions;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Day1_Demo {

	public static void main(String[] args) {
		try {
			Playwright playwright = Playwright.create();
			BrowserType bt = playwright.chromium();
			// BrowserType bt = playwright.firefox();
			// BrowserType bt = playwright.webkit();

			Browser browser = bt.launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();

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
		} finally {
			// browser.close();
			// playwright.close();
		}

	}

}
