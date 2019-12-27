package Testcases.ClearTrip;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Testcases.PageFactory.Login;

public class HomeTest {

	WebDriver driver;
	Properties prop;
	Logger log = Logger.getLogger(HomeTest.class);
	@BeforeTest
	public void pageNavigation() throws Exception {
		Base base = new Base();
		
		base.loadProperties();
		base.initialiseBrowser();
		driver=base.getDriver();
		prop=base.getProp();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test
	public void loginOnTours() throws IOException {
		
		String Username = prop.getProperty("user");
		String Password = prop.getProperty("password");
		Login login = new Login(driver);

		login.Account().click();
		login.Sign_in().click();
		driver.switchTo().frame(driver.findElement(By.id("modal_window")));

		login.Email().sendKeys(Username);
		log.info("Entered username");
		login.Password().sendKeys(Password);
		log.info("Entered password");
		login.Submit().click();
		log.error("Invalid logins");

	}

/*	@AfterTest
	public void cleanUp() {
		if (driver != null) {
			driver.quit();
		}
	} */
}
