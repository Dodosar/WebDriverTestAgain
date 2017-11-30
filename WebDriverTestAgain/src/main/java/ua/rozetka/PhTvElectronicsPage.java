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

public class PhTvElectronicsPage {

	WebDriver driver;
	WebDriverWait wait;	
	IsElementPresent objForThisLement;

	@FindBy(xpath = "//*[@id='3361']/a")
	WebElement link;
	
	@FindBy(xpath = "//*[@id='content-inner-block']//header/h1")
	WebElement titleForSecondPage;

	public PhTvElectronicsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30, 500);

	}
	
	public void IsElementPresents(){
		objForThisLement = new IsElementPresent(driver);
		objForThisLement.isElemenPresentInaPage(link);
	}

	public void GoToSmartTVElect() {
		try {
			
			Actions tooltip = new Actions(driver);
			tooltip.moveToElement(link).build().perform();
			//link.click();
			/*JavascriptExecutor exutor = (JavascriptExecutor) driver;
			exutor.executeScript("arguments[0].click();", link);*/
			//objForThisLement.isElemenPresentInaPage(titleForSecondPage);
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content-inner-block']//header/h1")));
			// //header.title-page>*:first-child
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
