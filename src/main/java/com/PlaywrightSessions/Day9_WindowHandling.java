package com.PlaywrightSessions;

import java.util.List;

import com.microsoft.playwright.*;

public class Day9_WindowHandling {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		BrowserContext brcx = browser.newContext();
		Page page = brcx.newPage();

		page.navigate("https://freelance-learn-automation.vercel.app/login");

		Page newpage = brcx.waitForPage(() -> {
			page.locator("//a[contains(@href, 'facebook')]").first().click();
		});

		newpage.locator("#email").fill("abcde");

		page.bringToFront();
		page.waitForTimeout(2000);
		newpage.bringToFront();
		page.waitForTimeout(2000);
		page.bringToFront();
		page.waitForTimeout(2000);
		newpage.bringToFront();
		page.waitForTimeout(2000);
		newpage.close();

		// page.bringToFront();
		Locator alllinks = page.locator("//div[@class='social']//a");
		for (int i = 0; i < alllinks.count() - 1; i++) {
			alllinks.nth(i).click();
		}

		List<Page> allpages = brcx.pages();

		for (Page p : allpages) {
			String title = p.title();
			System.out.println(title);
			if (title.contains("Facebook")) {
				p.bringToFront();
				p.locator("#email").fill("abcde");
				break;
			}
		}

		/*
		 * for (int i = 0; i < allpages.size(); i++) { String title =
		 * allpages.get(i).title(); System.out.println(title); if
		 * (title.contains("Facebook")) { allpages.get(i).bringToFront();
		 * allpages.get(i).locator("#email").fill("abcde"); break; } }
		 */

		brcx.close();

	}

}
