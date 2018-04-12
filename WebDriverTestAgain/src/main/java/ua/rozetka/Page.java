package ua.rozetka;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import ua.Elements.Elements;
import ua.Elements.TitleNames;

public class Page {
	protected String url = "";
	protected TitleNames title;
	protected WebDriver driver;
	protected WebElement link;
	protected WebElement stock; 
		
	
	

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	protected WebElement GetLink()
	{
		return link;
	}	

	
	public WebDriver getDriver() {
		return driver;
	}

	public Page open() {
		driver.get(url);
		pause(1);
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
	
	public Page clickOnXpath() {
		isElemenPresentInaPage(GetLink());
		GetLink().click();		
		return this;
	}

	public Page clickON(WebElement element) {
		isElemenPresentInaPage(element);
		element.click();
		return this;
	}

	public String getTitlePage() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	public void CheckTheTitle() {
		try {		
			AssertJUnit.assertTrue(getTitlePage().equals(
					title.toString()));
			title = null;
			System.out.println("Title Correct");
		} catch (Exception e) {
			System.out.println("Title Incorrect");
		}
	}
		
    protected WebElement getElement(String elementName){
        return driver.findElement(By.xpath(getXPath(elementName)));
    }

    private String getXPath(String elementName) {
		// TODO Auto-generated method stub    	
		return Elements.getEntryForElementName(elementName).getXPath();
	}

	protected List<WebElement> getElements(String elementName){
        return driver.findElements(By.xpath(getXPath(elementName)));
    }
	
	
	public static void pause(int time){
		 try {
	            Thread.sleep(time*1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}

}
