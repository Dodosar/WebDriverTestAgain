package ua.rozetka;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

public class Page {
	protected String url = "";
	protected TitleNames title;
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

	public Page clickON(WebElement element) {
		isElemenPresentInaPage(element);
		element.click();
		return this;
	}

	public String getTitleManePage() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	public void CheckTheTitle() {
		try {
			AssertJUnit.assertTrue(and().getTitleManePage().equals(
					title.toString()));
			System.out.println("Test Passed");
		} catch (Exception e) {
			System.out.println("Test Failed");
		}
	}

}
