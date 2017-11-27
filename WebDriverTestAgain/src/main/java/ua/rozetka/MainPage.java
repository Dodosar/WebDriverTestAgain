package ua.rozetka;

import org.openqa.selenium.WebDriver;

public class MainPage {
	WebDriver driver;

	
	public MainPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public String getTitleManePage() {
		return driver.getTitle();
	}
}
