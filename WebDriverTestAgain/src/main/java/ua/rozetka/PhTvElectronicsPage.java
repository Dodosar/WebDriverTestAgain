package ua.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PhTvElectronicsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//*[@id='3361']/a")
	WebElement link;
	
	
	
	public PhTvElectronicsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30,500);
	}
	
	public void GoToSmartTVElect(){
		try{
		link.click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content-inner-block']//header/h1"))); //header.title-page>*:first-child
		WebElement title = driver.findElement(By.xpath("//*[@id='content-inner-block']//header/h1"));
		System.out.println("test passed");
	}
		catch(Exception e){
			System.out.println("test failed");
		}
	}
	
	public String getTitleFromPage(){
		String title = driver.getTitle();
		return title;		
	}

}
