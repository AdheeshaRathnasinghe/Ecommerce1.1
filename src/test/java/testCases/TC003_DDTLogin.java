package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home;
import pageObjects.Login;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_DDTLogin extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")
	public void loginDDT(String email, String pwd, String exp)
	{
		logger.info("****Starting TC003_DDTLogin****");
		try {
			//HomePage
			Home hp=new Home(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//Loginpage
			Login lp=new Login(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			
			//MyAcc
			MyAccount myacc=new MyAccount(driver);
			boolean targetPage=myacc.isMyAccountExists();
			
			
			
			/*Data is valid - Login success - test pass - Logout
			 *              - Login failed  - test fail 
			 *              
			 Data is invalid - Login success - test fail - Logout
			 *               - Login failed  - test pass
			 */
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					myacc.clickLogout();
					Assert.assertTrue(true);	
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					myacc.clickLogout();
					Assert.assertTrue(false);	
				}
				
				else
				{
					Assert.assertTrue(true);
				}
			}
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****Ending TC003_DDTLogin****");
	}
	
}


