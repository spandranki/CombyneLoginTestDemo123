package testCombyneObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectsForLoginFunctionality {

	private static WebElement element = null;

	public static WebElement EmailField(WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//input[@class='Input_input__3544m'])[1]"));
		return element;
	}
	
	public static WebElement Password(WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//input[@class='Input_input__3544m'])[2]"));
		return element;
	}
	
	public static WebElement Next(WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//input[@class='Button_main__1QNdq Button_gold__30nsa Button_large__2i37X'])"));
		return element;
	}
	
	
	public static WebElement ForgotPassword(WebDriver driver) {
		
		element = driver.findElement(By.className("Onboard_take-to-marketplace__3876D"));
		return element;
	}	
	public static WebElement ForgotPasswordEmail(WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//input[@class='Input_input__bw3sO'])"));
		return element;
	}
	public static WebElement Submit(WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//input[@class='Button_main__3EpAh Button_primary-color__2EBHA Button_large__1pBGn Button_primary-font__1iBs8'])"));
		return element;
	}
	
	public static WebElement BackToLogin(WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//*[@class='RecovPasswdForm_back-login__BXgeI'])"));
		return element;
	}
	
	public static WebElement CreateAnAccount(WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//*[@class='Onboard_back-login__13hnR'])"));
		return element;
	}
	
	public static WebElement FirstName(WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//input[@class='Input_input__3544m'])[1]"));
		return element;
	}
		
	public static WebElement LastName(WebDriver driver) {
	
	element = driver.findElement(By.xpath("(//input[@class='Input_input__3544m'])[2]"));
	return element;
	
	}

	public static WebElement EmailAddress(WebDriver driver) {
	
	element = driver.findElement(By.xpath("(//input[@class='Input_input__3544m'])[3]"));
	return element;
	
	}
	
	public static WebElement CreateAccountNext(WebDriver driver) {
		
	element = driver.findElement(By.xpath("(//input[@class='Button_main__1QNdq Button_gold__30nsa Button_large__2i37X'])"));
	return element;
	
	}
	
	public static WebElement TermsOfUse(WebDriver driver) {
		
	element = driver.findElement(By.xpath("(//a[@href='/terms-of-use'])"));
	return element;
	
	}
	
	public static WebElement PrivacyPolicy(WebDriver driver) {
		
	element = driver.findElement(By.xpath("(//a[@href='/privacy-policy'])"));
	return element;
	
	}
	
	public static WebElement LoginLink(WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//*[@id=\"ui\"]/div/div[1]/form/div/div[6]/span)"));
		return element;
		
		}
	
	public static WebElement ContactUs(WebDriver driver) {
		
		element = driver.findElement(By.xpath("(//a[@href='mailto:help@combyne.ag'])"));
		return element;
		
		}
	
}

