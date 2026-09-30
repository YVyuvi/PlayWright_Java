package com.PlaywrightSessions;

import com.microsoft.playwright.*;

public class Day8_Alerts {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(3000));
		Page page = browser.newPage();

		page.navigate("https://testautomationpractice.blogspot.com/");

		page.onDialog(dialog -> {
			String text = dialog.message();
			System.out.println(text);
			dialog.accept("Hello");
			// dialog.dismiss();
		});

		page.click("//button[text()='Simple Alert']");
		System.out.println(page.textContent("p#demo"));

		page.click("//button[text()='Confirmation Alert']");
		System.out.println(page.textContent("p#demo"));

		page.click("//button[text()='Prompt Alert']");
		System.out.println(page.textContent("p#demo"));

		browser.close();
	}

}
