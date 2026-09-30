package com.PlaywrightSessions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class Dayy18_FileDownload {

	public static void main(String[] args) throws IOException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();

		page.navigate("https://testautomationpractice.blogspot.com/p/download-files_25.html");

		page.locator("//textarea[@id='inputText']")
				.fill("Download objects are dispatched by page via the Page.onDownload(handler) event.\r\n" + "\r\n"
						+ "All the downloaded files belonging to the browser context are deleted when the browser context is closed.\r\n"
						+ "\r\n"
						+ "Download event is emitted once the download starts. Download path becomes available once download completes.");

		page.click("button#generateTxt");
		Download download = page.waitForDownload(() -> {
			page.click("a#txtDownloadLink");
		});
		// download.cancel();
		// System.out.println(download.failure());
		System.out.println(download.suggestedFilename());
		System.out.println(download.url());
		System.out.println(download.page().title());
		System.out.println(download.path().toString());

		String downloadPath = System.getProperty("user.dir") + "/DownloadFiles/" + download.suggestedFilename();
		download.saveAs(Paths.get(downloadPath));

		// Extension Verify
		if (downloadPath.endsWith(".txt")) {
			System.out.println("Extension are Correct");
		} else {
			System.out.println("Extension are InCorrect");
			browser.close();
			return;
		}

		// Size Verify
		if (Files.size(Path.of(downloadPath)) > 0) {
			System.out.println("Size are Correct");
		} else {
			System.out.println("Size are InCorrect");
			browser.close();
			return;
		}

		// Content Verify
		String content = Files.readString(Path.of(downloadPath));
		if (content.contains("objects")) {
			System.out.println("Content are Correct");
		} else {
			System.out.println("Content are InCorrect");
			browser.close();
			return;
		}

		browser.close();

	}

}
