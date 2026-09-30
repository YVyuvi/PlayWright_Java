package com.PlaywrightSessions;

import java.util.List;
import java.util.regex.Pattern;

import com.microsoft.playwright.*;

public class Dayy10_Frame {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(3000));
		Page page = browser.newPage();

		page.navigate("https://ui.vision/demo/webtest/frames/");
		List<Frame> allframes = page.frames();
		System.out.println(allframes.size());

		page.frameLocator("//frame[@src='frame_1.html']").locator("//input[@name='mytext1']").fill("abhghjd");

		FrameLocator frame2 = page.frameLocator("//frame[@src='frame_2.html']");
		frame2.locator("//input[@name='mytext2']").fill("abhghjd");

		page.frameLocator("//frame[@src='frame_3.html']").frameLocator("iframe")
				.locator("(//div[@class='uHMk6b fsHoPb'])[1]").click();

		page.frameByUrl(Pattern.compile("frame_4")).locator("//input[@name='mytext4']").fill("addfasas");

	}

}
