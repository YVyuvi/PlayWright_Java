package com.PlaywrightSessions;

import com.github.javafaker.Faker;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Day4_Dropdown_CheckBox {

	public static void main(String[] args) {

		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page page = browser.newPage();

		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.locator("xpath=//a[@class='subLink']").click();
		PlaywrightAssertions.assertThat(page.locator(".submit-btn")).isDisabled();

		page.getByPlaceholder("Name").fill(new Faker().name().fullName());
		// page.locator("#email").fill(System.currentTimeMillis() + "@gmail.com");
		page.locator("#email")
				.fill(new Faker().name().firstName() + "_" + new Faker().name().lastName() + "@gmail.com");
		// page.pause();
		page.locator("xpath=//input[@type='password']").fill(new Faker().number().toString());

		page.locator("xpath=//label[text()='Java']/preceding::input[1]").click();
		PlaywrightAssertions.assertThat(page.locator("xpath=//label[text()='Java']/preceding::input[1]")).isChecked();

		page.getByText("Female").click();

		page.locator("#state").selectOption("Tamil Nadu");
		String hobbies[] = { "Playing", "Singing" };
		page.locator("#hobbies").selectOption(hobbies);

		PlaywrightAssertions.assertThat(page.locator(".submit-btn")).isEnabled();
		page.locator(".submit-btn").click();

		page.waitForTimeout(2000);

	}

}
