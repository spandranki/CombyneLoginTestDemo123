package testCombyneScripts;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testCombyneObjects.ObjectsForLoginFunctionality;

public class LoginScripts {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	//Test Case1 - User is able to login with valid credentials
	@Test(priority=0)
	public void test1() throws InterruptedException {


		driver.get("https://demo.combyne.ag/login");				  
		driver.manage().window().maximize();
		ObjectsForLoginFunctionality.EmailField(driver).sendKeys("sameera.pandranki7@gmail.com");
		ObjectsForLoginFunctionality.Password(driver).sendKeys("Test@1234");
		ObjectsForLoginFunctionality.Next(driver).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String Expected="";	//Assuming the expected as null i.e no error message
		String Actual = driver.findElement(By.xpath("(//*[@class='Input_caption__3AYcS'])")).getText();
		System.out.println(Actual);
		if(Actual.contentEquals(Expected)) {

			System.out.println("Test case1 Passed");
		}
		else {

			System.out.println("Test Case1 Failed");			
		}

		Thread.sleep(5000);


	}

	//Test Case2 - 	User is able to navigate to Forgot Password page
	@Test(priority=1)
	public void test2() throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.combyne.ag/login");				  
		driver.manage().window().maximize();
		ObjectsForLoginFunctionality.ForgotPassword(driver).click();
		ObjectsForLoginFunctionality.ForgotPasswordEmail(driver).sendKeys("sameera.pandranki7@gmail.com");
		ObjectsForLoginFunctionality.Submit(driver).click();

		String Expected="";
		String Actual = driver.findElement(By.xpath("(//*[@class='Input_error-message__26I3v Input_ctr-error__1Oy3O'])")).getText();
		System.out.println(Actual);
		if(Actual.contentEquals(Expected)) {

			System.out.println("Test case2 Passed");
		}
		else {

			System.out.println("Test Case2 Failed");			
		}

		Thread.sleep(5000);


	}

	//Test case4 - Verify user is able to navigate to Login page upon clicking back to login from Forgot Password page
	@Test(priority=2)
	public void test4() throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.combyne.ag/login/recover-account");				  
		driver.manage().window().maximize();
		String ActualRecoveryPageTitle=driver.findElement(By.cssSelector(".RecovPasswdForm_title__7ZdwX")).getText().trim();
		Assert.assertTrue(ActualRecoveryPageTitle.equals("Trouble Logging in?"),"Recovery page title is not as expected!!");

		ObjectsForLoginFunctionality.BackToLogin(driver).click();
		String ExpectedTitle = "Combyne";				//Home/Login page title
		String ActualTitle = driver.getTitle();

		if(ActualTitle.contentEquals(ExpectedTitle)) {

			System.out.println("Test Case4 Passed");
		}
		else {

			System.out.println("Test case4 Failed");
		}

		Thread.sleep(5000);


	}


	//Test case5 - Verify user is able to navigate to Create account page upon clicking on Create an Account Link
	@Test(priority=3)
	public void test5() throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.combyne.ag/login");				  
		driver.manage().window().maximize();
		ObjectsForLoginFunctionality.CreateAnAccount(driver).click();
		String ExpectedTitle = "Combyne";
		String ActualTitle = driver.getTitle();
		Assert.assertTrue(ExpectedTitle.equals(ActualTitle), "Title is not as expected!!");

		Thread.sleep(5000);

	}


	//Test case6 - Verify user is able to fill in the fields and submit in create an account page
	@Test(priority=4)
	public void test6() throws InterruptedException { 


		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.combyne.ag/onboard/details");				  
		driver.manage().window().maximize();	
		ObjectsForLoginFunctionality.FirstName(driver).sendKeys("Sameera");
		ObjectsForLoginFunctionality.LastName(driver).sendKeys("Pandranki");
		ObjectsForLoginFunctionality.EmailAddress(driver).sendKeys("sameera.pandranki7@gmail.com");
		ObjectsForLoginFunctionality.CreateAccountNext(driver).click();

		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		String Expected="";
		String Actual = driver.findElement(By.xpath("(//*[@class='Input_caption__3AYcS'])")).getText();
		System.out.println(Actual);
		if(Actual.contentEquals(Expected)) {

			System.out.println("Test case6 Passed");
		}
		else {

			System.out.println("Test Case6 Failed");			
		}

		Thread.sleep(5000);


	}


	//Test case8 - Verify user is able to click on terms of use and privacy policy link on create an account page
	@SuppressWarnings({ "unused", "unchecked" })
	@Test(priority=5)
	public void test8() throws InterruptedException { 


		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.combyne.ag/onboard/details");				  
		driver.manage().window().maximize();

		ObjectsForLoginFunctionality.TermsOfUse(driver).click();
		String child1=driver.getWindowHandle();

		@SuppressWarnings("rawtypes")
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		System.out.println(tabs.size());
		Thread.sleep(5000);   //wait time to view Terms of Use page
		driver.switchTo().window((String) tabs.get(0));		    
		Thread.sleep(3000);		    
		ObjectsForLoginFunctionality.PrivacyPolicy(driver).click();
		Thread.sleep(5000);   //wait time to view Privacy policy page
		System.out.println("Test Case8 Passed");


	}


	//Test case9 - Verify user is able to navigate to login page upon clicking login from account creation page
	@Test(priority=6)
	public void test9() throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.combyne.ag/onboard/details");			  
		driver.manage().window().maximize();
		ObjectsForLoginFunctionality.LoginLink(driver).click();

		String ExpectedTitle = "Combyne"; 	//home/login page title
		String ActualTitle = driver.getTitle();

		if(ActualTitle.contentEquals(ExpectedTitle)) {

			System.out.println("Test Case9 Passed");
		}
		else {

			System.out.println("Test case9 Failed");
		}

		Thread.sleep(5000);


	}


	//Test case10 - Verify user is able to see mail draft to default recipient upon clicking contact us link
	@Test(priority=7)
	public void test10() throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.combyne.ag/login");
		driver.manage().window().maximize();
		String parent = driver.getWindowHandle();

		ObjectsForLoginFunctionality.ContactUs(driver).click();

		Thread.sleep(3000);

		driver.switchTo().window(parent);

		System.out.println("Test Case10 Passed");	



	}

	//Test case11 - Verify user is thrown with an error message when an invalid email is entered
	@Test(priority=8)
	public void test11() throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.combyne.ag/login");
		driver.manage().window().maximize();
		ObjectsForLoginFunctionality.EmailField(driver).sendKeys("invalidemail@gmail.com");
		ObjectsForLoginFunctionality.Password(driver).sendKeys("Invalid@1234");
		ObjectsForLoginFunctionality.Next(driver).click();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		String Expected="Whoops! That email is not associated with an account.";	
		String Actual = driver.findElement(By.xpath("(//*[@class='Input_caption__3AYcS'])")).getText();
		System.out.println(Actual);
		if(Actual.contentEquals(Expected)) {

			System.out.println("Test case11 Passed");
		}
		else {

			System.out.println("Test Case11 Failed");			
		}

		Thread.sleep(5000);



	}

	//Test case12 - Verify user is thrown with and error upon entering a valid but unregistered email id
	@Test(priority=9)
	public void test12() throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.combyne.ag/login");
		driver.manage().window().maximize();
		ObjectsForLoginFunctionality.EmailField(driver).sendKeys("sameera.pandranki7@gmail.com");
		ObjectsForLoginFunctionality.Password(driver).sendKeys("Test@1234");
		ObjectsForLoginFunctionality.Next(driver).click();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		String Expected="Whoops! That email is not associated with an account.";	
		String Actual = driver.findElement(By.xpath("(//*[@class='Input_caption__3AYcS'])")).getText();
		System.out.println(Actual);
		if(Actual.contentEquals(Expected)) {

			System.out.println("Test case12 Passed");
		}
		else {

			System.out.println("Test Case12 Failed");			
		}

		Thread.sleep(5000);



	}


	//Test case16 - Verify user is not able to go to market place page after login failure
	@Test(priority=10)
	public void test16() throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.combyne.ag/login");
		driver.manage().window().maximize();
		ObjectsForLoginFunctionality.EmailField(driver).sendKeys("sameera.pandranki7@gmail.com");
		ObjectsForLoginFunctionality.Password(driver).sendKeys("Test@1234");
		ObjectsForLoginFunctionality.Next(driver).click();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		String ExpectedTitle="Create Account - Onboarding Page"; //Assuming as a new user login fail, he should be directed to on-boarding/Account creation page
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		if(ActualTitle.contentEquals(ExpectedTitle)) {

			System.out.println("Test case16 Passed");
		}
		else {

			System.out.println("Test Case16 Failed");			
		}

		Thread.sleep(5000);


	}


}