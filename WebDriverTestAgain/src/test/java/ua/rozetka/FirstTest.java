package ua.rozetka;

import org.testng.annotations.Test;

public class FirstTest extends WebDriverSettings {

	RozetkaSite objRozetka;

	@Test(priority = 0)
	public void MainPage() {
		objRozetka = new RozetkaSite(driver);
		System.out.println("Step 1: Check Title on Main Page");
		objRozetka.mainPage().open().and().CheckTheTitle();
	}

	@Test(priority = 1)
	public void SecondPage() {
		System.out.println("Step 2: Click to link Page of All SmatPhones");
		objRozetka.electronics().clickOnXpath().then().CheckTheTitle();
		

	}

}
