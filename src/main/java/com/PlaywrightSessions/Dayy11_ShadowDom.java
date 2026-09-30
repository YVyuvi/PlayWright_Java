package com.PlaywrightSessions;

import com.microsoft.playwright.*;

public class Dayy11_ShadowDom {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(3000));
		Page page = browser.newPage();

		page.navigate("https://selectorshub.com/xpath-practice-page/");

		// No xpath only css selectors
		// shadow root should be open

		// App 1
		Locator shadowroot = page.locator("#userName");
		Locator element = shadowroot.locator("#kils");
		element.fill("abcde");

		// App 2

		page.locator("#userName #kils").fill("fghij");

		browser.close();
	}

}
