package ua.rozetka;

import org.testng.annotations.Test;

public class FirstTest extends WebDriverSettings{

	RozetkaSite objRozetka;	

	@Test(priority = 0)
	public void f(){
		objRozetka = new RozetkaSite(driver);
		System.out.println("Step 1: Check Title on Main Page");
		objRozetka.mainPage().open().
			and().CheckTheTitle();		
	}

		@Test(priority = 1)
		public void SecondPage() {
		System.out.println("Step 2: Click to link Page of All SmatPhones");
		objRozetka.electronics().GoToSmartTVElect();
		
		/*try {
			System.out.println(objRozetka.electronics().getTitleFromPage());
			AssertJUnit.assertTrue(objRozetka.electronics().getTitleFromPage()
					.equals(TitleNames.SMARTPAGE.toString()));
			System.out.println("Test Passed");
		} catch (Exception e) {
			System.out.println("Test Failed");
		}*/
	}

}
