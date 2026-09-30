package com.PlaywrightSessions;

import java.util.List;

import com.microsoft.playwright.*;

public class Day2_Locator {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext brcx = browser.newContext();
		Page page = brcx.newPage();
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");

		// single element
		Locator btn1 = page.locator("text=Company").first();
		btn1.hover();
		btn1.click();

		// multiple element
		Locator btn2 = page.locator("text=Book a Free Demo").last();
		int count = btn2.count();
		System.out.println(count);
		btn2.hover();
		// btn2.click();

		Locator options = page.locator("//select[@id='Form_getForm_Country']/option");
		System.out.println(options.count());

		// opt1
		for (int i = 0; i < options.count(); i++) {
			String country = options.nth(i).textContent();
			System.out.println(country);
		}

		// opt2
		List<String> lists = options.allTextContents();
		for (String list : lists) {
			System.out.println(list);
		}

		// opt3
		lists.forEach(ele -> System.out.println(ele));

		browser.close();
		playwright.close();

	}

}
