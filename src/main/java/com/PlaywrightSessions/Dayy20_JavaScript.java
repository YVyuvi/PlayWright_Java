package com.PlaywrightSessions;

import com.microsoft.playwright.*;

public class Dayy20_JavaScript {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

		Page page = browser.newPage();

		page.navigate("https://login.yahoo.com/");

		System.out.println(page.locator("#persistent").boundingBox().height);
		System.out.println(page.locator("#persistent").boundingBox().width);

		// page.locator("#persistent").click();

		// page.evaluate("document.getElementById('persistent').click()");

		Locator checkbox = page.locator("#persistent");

		checkbox.evaluate("checkbox => checkbox.click()");

		page.close();
		browser.close();
	}

}
