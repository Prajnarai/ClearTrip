package Testcases.ClearTrip;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HotelTest{
	WebDriver driver;
	Properties prop;
	
	@Test
	public void hotelBookings() throws InterruptedException {
		Hotels hotel = new Hotels();
		hotel.setDriver(driver);
		hotel.location();
			hotel.checkIn();
		hotel.checkOut();
		hotel.traveller();		
	}
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

}
