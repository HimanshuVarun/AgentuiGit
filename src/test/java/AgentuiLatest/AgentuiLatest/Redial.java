package AgentuiLatest.AgentuiLatest ;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;


public class Redial extends Home_page
{

	public static void redial() throws Exception
	{
		Logger log=Logger.getLogger("Redial button test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start redial button   test case");
		Thread.sleep(2000);
		if(isElementPresent(By.name("redialNumFree")))
		{
			driver.findElement(By.name("redialNumFree")).click();
			System.out.println("click on redial button");

		}
		else
		{
			screen(driver,"Redial button not found");
			System.out.println("Redial button not found");

		}

		Thread.sleep(4000);


		//disconnect call
		if(isElementPresent(By.name("disconnect")))
		{
			driver.findElement(By.name("disconnect")).click();
			System.out.println("click on disconnect button");
			Thread.sleep(5000);
		}
		else
		{
			screen(driver,"Disconnect button not found in Redial test case");
		}



	}

	public static void  RedialExtent()
	{
		Logger log=Logger.getLogger("Redial button test case extent report");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start redial button   test case extent report method ");
		if(rd_flag==1)
		{
			logger = extent.startTest("Redial_call ");
			//Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Redial test case is pass ");
			logger.log(LogStatus.PASS, " rd_flag  from agent_live table ::\t"+rd_flag);
			if(agent_state.equals("FREE"))
			{
				logger.log(LogStatus.PASS, " agent_state after Discconnect from agent_live table ::\t"+agent_state);
			}
			else
			{
				logger.log(LogStatus.FAIL, " agent_state after Discconnect from agent_live table ::\t"+agent_state);
			}
		}
		else
		{
			logger = extent.startTest("Redial_call ");
			//Assert.assertTrue(true);
			logger.log(LogStatus.FAIL, "Redial_call  test case is fail ");
			logger.log(LogStatus.FAIL, " rd_flag  from agent_live table ::\t"+rd_flag);
			if(agent_state.equals("FREE"))
			{
				logger.log(LogStatus.PASS, " agent_state after Discconnect from agent_live table ::\t"+agent_state);
			}
			else
			{
				logger.log(LogStatus.FAIL, " agent_state after Discconnect from agent_live table ::\t"+agent_state);
			}

		}
	}
}
