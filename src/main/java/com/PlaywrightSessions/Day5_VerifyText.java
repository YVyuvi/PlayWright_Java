package com.PlaywrightSessions;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Day5_VerifyText {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page page = browser.newPage();

		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.getByText("Sign in").last().click();
		String expected = "Email and Password is required";

		// opt 1
		String actual1 = page.locator(".errorMessage").textContent();
		System.out.println(actual1);

		// opt 2
		String actual2 = page.locator(".errorMessage").innerText();
		System.out.println(actual2);

		// opt 3
		String actual3 = (String) page.evaluate("document.getElementsByClassName(\"errorMessage\")[0].textContent");
		System.out.println(actual3);

		PlaywrightAssertions.assertThat(page.locator(".errorMessage")).hasText(expected);
		PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText(Pattern.compile("required"));

		page.close();
		browser.close();

	}

}
