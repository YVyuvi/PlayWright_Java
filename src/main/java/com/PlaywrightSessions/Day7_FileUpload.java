package com.PlaywrightSessions;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
//import java.nio.file.Paths;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;

public class Day7_FileUpload {

	public static void main(String[] args) throws InterruptedException {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();

		page.navigate("https://testautomationpractice.blogspot.com/");

		// Single File
		page.locator("input#singleFileInput")
				.setInputFiles(Path.of(System.getProperty("user.dir") + "/Files/applogin.json"));
		// page.setInputFiles("input#singleFileInput", Paths.get("applogin.json"));
		page.click("(//button[@type='submit'])[1]");
		System.out.println(page.textContent("p#singleFileStatus"));
		Thread.sleep(1500);

		// Remove Files
		page.locator("input#singleFileInput").setInputFiles(new Path[0]);
		// page.setInputFiles("input#singleFileInput", new Path[0]);
		Thread.sleep(1500);
		page.click("(//button[@type='submit'])[1]");
		System.out.println(page.textContent("p#singleFileStatus"));

		// Multiple Files
		page.locator("input#multipleFilesInput")
				.setInputFiles(new Path[] { Path.of(System.getProperty("user.dir") + "/Files/applogin.json"),
						Path.of(System.getProperty("user.dir") + "/Files/login.json") });
		// page.setInputFiles("input#multipleFilesInput", new Path[] {
		// Paths.get("applogin.json"), Paths.get("pom.xml") });
		page.click("(//button[@type='submit'])[2]");
		System.out.println(page.textContent("p#multipleFilesStatus"));
		Thread.sleep(1500);
		page.setInputFiles("input#multipleFilesInput", new Path[0]);
		page.click("(//button[@type='submit'])[2]");
		System.out.println(page.textContent("p#multipleFilesStatus"));

		// Create File and Upload
		page.setInputFiles("input#singleFileInput",
				new FilePayload("Sample.text", "text/plain", "This is sample".getBytes(StandardCharsets.UTF_8)));
		page.click("(//button[@type='submit'])[1]");
		System.out.println(page.textContent("p#singleFileStatus"));

		// WO Input Tag
		FileChooser filechooser = page.waitForFileChooser(() -> page.locator("input#singleFileInput").click());
		filechooser.setFiles(Path.of(System.getProperty("user.dir") + "/Files/applogin.json"));
		Thread.sleep(1500);

		FileChooser filechooser2 = page.waitForFileChooser(() -> page.locator("input#multipleFilesInput").click());
		Path files[] = { Path.of(System.getProperty("user.dir") + "/Files/applogin.json"),
				Path.of(System.getProperty("user.dir") + "/Files/login.json") };
		filechooser2.setFiles(files);
		Thread.sleep(1500);

		browser.close();

	}

}
