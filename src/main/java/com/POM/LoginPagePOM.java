package com.POM;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPagePOM {

	private Locator userName;
	private Locator password;
	private Locator loginButton;

	public LoginPagePOM(Page page) {

		userName = page.getByPlaceholder("Enter Email");
		password = page.getByPlaceholder("Enter Password");
		loginButton = page.getByText("Sign in").last();
	}

	public LoginPagePOM enterUserName(String name) {
		userName.fill(name);
		return this;
	}

	public LoginPagePOM enterPassword(String pass) {
		password.fill(pass);
		return this;
	}

	public LoginPagePOM clickLoginButton() {
		loginButton.click();
		return this;
	}

	public LoginPagePOM doLogin(String user, String Pass) {
		return enterUserName(user).enterPassword(Pass).clickLoginButton();
	}

}
