package ua.rozetka;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {
	protected String url = "";
	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public Page open() {
		driver.get(url);
		System.out.println("open page " + url);
		return this;
	}

	public boolean isElemenPresentInaPage(WebElement a) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> list = new ArrayList<WebElement>();
		list.add(a);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (list.size() == 0) {
			System.out.println("xpath is incorrect");
			return false;
		} else {
			System.out.println("xpath is correct");
			return list.get(0).isDisplayed();
		}

	}

	public Page then() {
		return this;
	}
	
	public Page and() {
		return this;
	}	
	
	public Page clickON(WebElement element){
		isElemenPresentInaPage(element);
		driver.findElements(By.xpath(getXpath(element)));
		return this;
	}

	private String getXpath(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}


}
