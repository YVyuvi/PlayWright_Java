package com.PlaywrightSessions;

import com.microsoft.playwright.*;

public class Dayy17_Mouse {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));

		Page page = browser.newPage();

		page.navigate("https://testautomationpractice.blogspot.com/");

		// Mouse hover
		page.locator("//button[@class='dropbtn']").hover();
		page.locator("//a[text()='Laptops']").click();

		// Doublr Click
		page.locator("//button[text()='Copy Text']").dblclick();
		System.out.println(page.locator("#field2").inputValue());

		// Drag and Drop
		// page.locator("#draggable").dragTo(page.locator("#droppable"));
		// System.out.println(page.locator("//div[@id=\"droppable\"]//p").innerText());
		page.locator("#draggable").hover();
		page.mouse().down();
		page.locator("#droppable").hover();
		page.mouse().up();
		System.out.println(page.locator("//div[@id=\"droppable\"]//p").innerText());

	}

}
