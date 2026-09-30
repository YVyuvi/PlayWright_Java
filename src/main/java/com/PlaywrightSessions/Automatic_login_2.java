package com.PlaywrightSessions;

import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class Automatic_login_2 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext brcx = browser
				.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("applogin.json")));

		Page page = brcx.newPage();
		page.navigate("https://omb-test.chq.ei/omb/main");

	}

}
