package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home;
import pageObjects.Login;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_Login extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void test_Login()
	{
		
		
		logger.info("***Starting TC002_Login....***");
		
		try {
			
		//HomePage
		Home hp=new Home(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Loginpage
		Login lp=new Login(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAcc
		MyAccount myacc=new MyAccount(driver);
		boolean targetPage=myacc.isMyAccountExists();
		Assert.assertEquals(targetPage, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		logger.info("***Ending TC002_Login....***");
	}	

}
