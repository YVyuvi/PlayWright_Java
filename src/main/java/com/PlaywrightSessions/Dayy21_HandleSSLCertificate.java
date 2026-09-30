package com.PlaywrightSessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Browser.NewContextOptions;

public class Dayy21_HandleSSLCertificate {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

		NewContextOptions contextOptions = new Browser.NewContextOptions();
		contextOptions.setIgnoreHTTPSErrors(true);

		BrowserContext brcx = browser.newContext(contextOptions);

		Page page = brcx.newPage();

		page.navigate("https://expired.badssl.com/");

	}

}
