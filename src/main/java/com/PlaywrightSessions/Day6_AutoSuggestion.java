package com.PlaywrightSessions;

import com.microsoft.playwright.*;

public class Day6_AutoSuggestion {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page = browser.newPage();

		page.navigate("https://www.google.com/");
		page.locator("xpath=//textarea[@id='APjFqb']").fill("playwright");
		Locator locator = page.locator("//ul[@role='listbox']//li");
		System.out.println(locator.count());

		for (int i = 0; i < locator.count(); i++) {
			// String text = locator.nth(i).textContent();
			String text = locator.nth(i).innerText();
			System.out.println(text);
			if (text.contains("python")) {
				locator.nth(i).click();
				break;
			}
		}
	}

}
