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
		link.click();
	}
	
	public String getTitleFromPage(){
		String title = driver.getTitle();
		return title;		
	}

}
