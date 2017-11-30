package ua.rozetka;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IsElementPresent {
	
	WebDriver driver;

	public IsElementPresent(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isElemenPresentInaPage(WebElement a){
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> list = new ArrayList<WebElement>();
		list.add(a);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(list.size() == 0) {
			System.out.println("xpath is incorrect");
			return false;
		} else {
			System.out.println("xpath is correct");
			return list.get(0).isDisplayed();
		}
}
}
