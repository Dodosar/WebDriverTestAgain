package ua.rozetka;

import org.openqa.selenium.WebDriver;

public class RozetkaSiteFirstPAge {
	
	WebDriver driver;
	
	
	public RozetkaSiteFirstPAge() {
		this.driver = driver;
	}
	
	public MainPage mainPage() {return new MainPage(driver);}
	
	
}
