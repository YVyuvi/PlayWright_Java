package com.PlaywrightSessions;

//import java.util.List;

import com.microsoft.playwright.*;

public class Day3_Selectors {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();

		// 1.Text Selector
		/*
		 * page.navigate("https://automationexercise.com/login"); String s1 =
		 * page.locator("text=Login to your account").textContent();
		 * System.out.println(s1);
		 * 
		 * String s2 = page.locator("'Login to your account'").textContent();
		 * System.out.println(s2);
		 * 
		 * String s3 =
		 * page.locator("h2:has-text('Login to your account')").textContent();
		 * System.out.println(s3);
		 * 
		 * String s4 =
		 * page.locator("div.login-form h2:has-text('Login to your account')").
		 * textContent(); System.out.println(s4);
		 * 
		 * String s5 =
		 * page.locator("div h2:has-text('Login to your account')").textContent();
		 * System.out.println(s5);
		 */

		// 2.ShadowDom Selector
		/*
		 * page.navigate("https://books-pwakit.appspot.com/");
		 * page.locator("book-app[apptitle='BOOKS'] #input").fill("books"); String s =
		 * page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
		 * System.out.println(s);
		 */

		// 3.Frame Selector
		/*
		 * page.navigate(
		 * "https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/"
		 * );
		 * page.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();
		 * page.frameLocator("#frame-one748593425").locator("#RESULT_TextField-8").fill(
		 * "Hello"); String s =
		 * page.frameLocator("#frame-one748593425").locator("text=Contact information").
		 * textContent(); System.out.println(s);
		 */

		// 4.Visible Element
		/*
		 * page.navigate("https://www.amazon.com/"); List<String> lists =
		 * page.locator("a:visible").allInnerTexts(); for (int i = 0; i < lists.size();
		 * i++) { String link = lists.get(i); System.out.println(link); }
		 * 
		 * int i = page.locator("xpath=//img >> visible=true").count();
		 * System.out.println(i);
		 */

		// 5. Select Elements that contains other ele
		/*
		 * page.navigate("https://www.orangehrm.com/en/30-day-free-trial"); Locator
		 * options =
		 * page.locator("select#Form_getForm_Country:has(option[value='India'])");
		 * options.allInnerTexts().forEach(ele -> System.out.println(ele));
		 */

		// 6. Selecting ele that matching with one of the conditions
		/*
		 * page.navigate("https://automationexercise.com/");
		 * page.locator("//a[text()=' Products'] | //a[text()=' Items']").click();
		 * page.locator("a:has-text('Products')], a:has-text('Items')").click();
		 */

		// 7. Relative CSS Selector
		/*
		 * page.navigate("https://selectorshub.com/xpath-practice-page/");
		 * page.locator("input:left-of(:text('Joe.Root'))").first().click();
		 * System.out.println(page.locator("td:right-of(:text('Joe.Root'))").first().
		 * textContent());
		 * System.out.println(page.locator("a:above(:text('Joe.Root'))").first().
		 * textContent());
		 * System.out.println(page.locator("a:below(:text('Joe.Root'))").first().
		 * textContent());
		 * System.out.println(page.locator("a:near(:text('Joe.Root'))").first().
		 * textContent());
		 */

		// 8.Nth Element
		/*
		 * page.navigate("https://www.bigbasket.com/");
		 * System.out.println(page.locator("div.pr-4 li a >> nth=0").textContent());
		 * System.out.println(page.locator("div.pr-4 li a >> nth=-1").textContent());
		 */

		// 9. React Selectors
		/*
		 * page.navigate("https://www.netflix.com/in/");
		 * page.locator("_react=p[name='email']").fill("abcde");
		 */

		// 10. Xpath
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		page.locator("xpath=//input[textbox='value']").fill("abcde");

		browser.close();
		playwright.close();

	}

}
