package com.PlaywrightSessions;

//import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class Dayy12_Screenshot {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(3000));
		Page page = browser.newPage();

		page.navigate("https://testautomationpractice.blogspot.com/");

		// byte[] arr = page.screenshot();
		// System.out.println(arr);

		// page.screenshot(new
		// Page.ScreenshotOptions().setPath(Paths.get("Screenshot1.png")));
		// page.screenshot(new
		// Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("Screenshot2.png")));
		Utility.CreateScreenshot(page);

		page.close();
		browser.close();
	}

}
