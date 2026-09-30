package com.PlaywrightSessions;

import com.microsoft.playwright.*;

public class Dynamic_Webtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();

		page.navigate("https://testautomationpractice.blogspot.com/");
//		page.locator("input#input-username").fill("demo");
//		page.locator("input#input-password").fill("demo");
//		page.locator("//button[@type='submit']").click();
//		page.locator("text=' Customers'").click();
//		page.locator("//a[text()='Customers']").click();

		Locator row = page.locator("table#taskTable tr");

		String s = row.locator(":scope", new Locator.LocatorOptions().setHasText("System")).locator("td").first()
				.textContent();

		System.out.println(s);

		row.locator(":scope").allTextContents().forEach(e -> System.out.println(e));

	}

}
