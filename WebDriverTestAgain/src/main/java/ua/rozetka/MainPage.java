package ua.rozetka;

import org.openqa.selenium.WebDriver;

public class MainPage {
	WebDriver driver;
	
	public void MainPage(WebDriver driver){
		this.driver= driver;		
	}
	
	
	public String getTitleManePage() {
		return driver.getTitle();
	}
}
