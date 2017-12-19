package ua.rozetka;

import org.openqa.selenium.WebDriver;

public class MainPage extends Page {
	WebDriver driver;

	/**
	 * @param driver
	 */
	public MainPage(WebDriver driver) {
		super(driver);
		url = "http://rozetka.com.ua/";
		title = TitleNames.MAINPAGE;
		// TODO Auto-generated constructor stub
	}

}
