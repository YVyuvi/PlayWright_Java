package com.POM;

import org.testng.annotations.Test;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class LoginPageTest {

	@Test
	public void login() {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");

		// page.getByPlaceholder("Enter Email").fill("admin@email.com");
		// page.getByPlaceholder("Enter Password").fill("admin@123");
		// page.getByText("Sign in").last().click();

		LoginPagePOM lp = new LoginPagePOM(page);
		lp.doLogin("admin@email.com", "admin@123");
		PlaywrightAssertions.assertThat(page.locator(".welcomeMessage")).containsText("Welcome");

	}

}
