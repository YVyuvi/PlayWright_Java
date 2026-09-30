package com.PlaywrightSessions;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.*;

public class Maximize {

	public static void main(String[] args) {

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screensize.getWidth();
		int height = (int) screensize.getHeight();

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brcx = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		Page page = brcx.newPage();

		page.navigate("https://testautomationpractice.blogspot.com/");
	}

}
