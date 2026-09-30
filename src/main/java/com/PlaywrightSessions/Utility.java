package com.PlaywrightSessions;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Page;

public class Utility {

	public static byte[] CreateScreenshot(Page page) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");

		Date date = new Date();

		String CD = formatter.format(date);

		byte arr[] = page.screenshot(
				new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("Screenshot/" + CD + ".png")));
		return arr;
	}

}
