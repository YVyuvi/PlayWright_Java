package com.PlaywrightSessions;

import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class Dayy13_VideoRecording {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(3000));

		// BrowserContext brcx = browser.newContext(new
		// Browser.NewContextOptions().setRecordVideoDir(Paths.get("Videos")));

		BrowserContext brcx = browser.newContext(
				new Browser.NewContextOptions().setRecordVideoSize(1000, 500).setRecordVideoDir(Paths.get("Videos")));
		Page page = brcx.newPage();

		page.navigate("https://testautomationpractice.blogspot.com/");

		page.onDialog(dialog -> {
			String text = dialog.message();
			System.out.println(text);
			dialog.accept("Hello");
			// dialog.dismiss();
		});

		page.click("//button[text()='Simple Alert']");
		System.out.println(page.textContent("p#demo"));

		page.click("//button[text()='Confirmation Alert']");
		System.out.println(page.textContent("p#demo"));

		page.click("//button[text()='Prompt Alert']");
		System.out.println(page.textContent("p#demo"));

		page.close();
		brcx.close();
		browser.close();
	}

}
