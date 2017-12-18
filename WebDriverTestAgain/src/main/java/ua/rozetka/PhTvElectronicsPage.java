package ua.rozetka;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhTvElectronicsPage extends Page{

	WebDriver driver;
	WebDriverWait wait;
	
	
	@FindBy(xpath = "//a[contains(@href,'telefony-tv-i-ehlektronika')]")
	WebElement link;
	
	@FindBy(xpath = "//*[@id='content-inner-block']//header/h1")
	WebElement titleForSecondPage;

	public PhTvElectronicsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30, 500);

	}
	
	

	public void GoToSmartTVElect() {
		try {
			link.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content-inner-block']//header/h1")));
			System.out.println("Test Passed");
		} catch (NullPointerException e) {
			System.out.println(e.toString());
			System.out.println("Test Failed");
		}
	}

	public String getTitleFromPage() {
		String title = driver.getTitle();
		return title;
	}

}
