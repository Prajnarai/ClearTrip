package Testcases.ClearTrip;


import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlightTest{
	WebDriver driver;
	Properties prop;
	Logger log = Logger.getLogger(FlightTest.class);
	@Test
	public void location() throws InterruptedException {
		log.debug("Location() started");
		Flights flights = new Flights(driver);
		flights.flightBook();
		flights.calendar();
		flights.selectFlights();
		log.debug("Location() ended");
	}
	
	@BeforeTest
	public void pageNavigation() throws IOException {
		
		Base base = new Base();
		 try {
			 base.loadProperties();
			base.initialiseBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 driver=base.getDriver();
		 prop=base.getProp();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
	}

}
