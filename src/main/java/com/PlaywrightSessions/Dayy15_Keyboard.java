package com.PlaywrightSessions;

import com.microsoft.playwright.*;

public class Dayy15_Keyboard {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		page.navigate("https://testautomationpractice.blogspot.com/");

		page.locator("#name").fill("abcde");

		// app 2
		page.keyboard().press("Control+A");
		page.keyboard().press("Control+C");
		page.keyboard().press("Tab");
		page.keyboard().press("Control+V");

		// app 1
		/*
		 * page.keyboard().down("Control"); 
		 * page.keyboard().press("a");
		 * page.keyboard().up("Control");
		 * 
		 * page.keyboard().down("Control"); 
		 * page.keyboard().press("c");
		 * page.keyboard().up("Control");
		 * 
		 * page.keyboard().press("Tab");
		 * 
		 * page.keyboard().down("Control"); 
		 * page.keyboard().press("v");
		 * page.keyboard().up("Control");
		 */

	}

}
