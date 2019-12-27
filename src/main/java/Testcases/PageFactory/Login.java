package Testcases.PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	 WebDriver driver;
	//Using page object factory
	@FindBy(id ="userAccountLink")
	WebElement link; 
	
	@FindBy(id ="SignIn")
	WebElement login;
	
	@FindBy(name="email")
	WebElement Email;
	
	@FindBy(name="password")
	WebElement Pass;
	
	@FindBy(id="signInButton")
	WebElement Submit;
	
	
	public WebElement Account() {
		return link;
		
	}

	public Login(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}
	public WebElement Sign_in() {
		return login;
		
	}
	public WebElement Email() {
		return Email;
		
	}
	public WebElement Password() {
		return Pass;
		
	}
	public WebElement Submit() {
		return Submit;
	}
	
	
	
		
		
		
		
	}


