package ua.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PhTvElectronics {
	
	WebDriver driver;
	
	@FindBy(xpath="test")
	WebElement link;
	
	public PhTvElectronics(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void GoToSmartTVElect(){
		try{
		link.click();
		System.out.println("Link for test 2 passed");
	}
		catch(Exception e){
			System.out.println("Link for test 2 failed");
		}
	}
	
	public String getTitleFromPage(){
		String title = driver.getTitle();
		return title;		
	}

}
