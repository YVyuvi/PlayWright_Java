package com.PlaywrightSessions;

import com.microsoft.playwright.*;

public class Dayy16_Sliders {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));

		Page page = browser.newPage();

		page.navigate("https://testautomationpractice.blogspot.com/");

		// Left Slider
		page.locator("(//span[contains(@class, 'ui-slider-handle')])[1]").focus();
		for (int i = 0; i < 5; i++) {
			page.keyboard().press("ArrowLeft");
		}

		// Right Slider
		page.locator("(//span[contains(@class, 'ui-slider-handle')])[2]").focus();
		for (int i = 0; i < 10; i++) {
			page.keyboard().press("ArrowRight");
		}
	}

}
