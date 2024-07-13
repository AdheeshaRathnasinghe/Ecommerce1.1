package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_registration()
	{
		logger.info("******Starting TC001_AccountRegistrationTest********");
		try
		{
		Home hp=new Home(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount");
		hp.clickRegister();
		logger.info("Clicked on Register");
		
		
		RegistrationPage rp=new RegistrationPage(driver);
		rp.setFirstName(randomString().toUpperCase());
		rp.setLastName(randomString().toUpperCase());
		rp.setEmail(randomString()+"@gmail.com");
		rp.setTelephone(randomNumber());
		
		String pwd=randomAlphaNumber();
		rp.setPassword(pwd);
		rp.setConfirmPassword(pwd);
		
		rp.setPrivacyPolicy();
		rp.clickContinue();
		
		logger.info("Validating expected message");
		String conmsg=rp.getConfirmationMsg();
		if(conmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug Logs");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(conmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("******Finish TC001_AccountRegistrationTest********");
		
	}
	

}
