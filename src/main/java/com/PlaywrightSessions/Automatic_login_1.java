package com.PlaywrightSessions;

import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class Automatic_login_1 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brcx = browser.newContext();

		Page page = brcx.newPage();
		page.navigate("https://omb-test.chq.ei/omb/main");
		page.click("#userID");
		page.fill("#userID", "qae-ebcsysadmin");
		page.fill("#password", "qainternal!");
		page.click(".signin-button-div");

		brcx.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
	}

}
