package AgentuiLatest.AgentuiLatest ;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;


public class Ready_button extends Home_page
{
	static String Readybutton="";
	public static void ready() throws Exception
	{
		Logger log=Logger.getLogger("Ready button test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start ready button   test case");
		driver.switchTo().frame("crm");
		System.out.println("enter in frame");
		Thread.sleep(2000);
		//Ready the agent
		if(isElementPresent(By.name("readyMode")))
		{
			driver.findElement(By.name("readyMode")).click();
			System.out.println("click on ready button");
			Readybutton="Ready";
		}
		else
		{
			screen(driver," Ready button not found ");
			System.out.println("ready button not found");

		}

	}

	public static void ReadyExtent()
	{
		Logger log=Logger.getLogger("Ready button test case extent report");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start ready button   test case extent report method ");
		if(Readybutton.equals("Ready"))
		{
			logger = extent.startTest("Ready_button ");
			//Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Ready_button  test case is pass ");
			if(agent_state.equals("FREE"))
			{
				logger.log(LogStatus.PASS, " agent_state from data base Before click on ready Button::\t"+agent_state_before_login);
				logger.log(LogStatus.PASS, " agent_state from data base After click on ready Button ::\t"+agent_state);
			}
			else
			{
				logger.log(LogStatus.FAIL, " agent_state from data base Before click on ready Button::\t"+agent_state_before_login);
				logger.log(LogStatus.FAIL, " agent_state from data base After click on ready Button ::\t"+agent_state);
			}
			if(dialer_type.equals("PROGRESSIVE")||dialer_type.equals("PREVIEW"))
			{
				logger.log(LogStatus.PASS, " dialer_type from data base ::\t"+dialer_type);
			}
			else
			{
				logger.log(LogStatus.FAIL, " dialer_type from data base ::\t"+dialer_type);
			}
			if(campaign_id1.equals(campaign_id))
			{
				logger.log(LogStatus.PASS, " Campaign id from agent table ::\t"+campaign_id1);
				logger.log(LogStatus.PASS, " Campaign id from agent_live table ::\t"+campaign_id);
			}
			else
			{
				logger.log(LogStatus.FAIL, " Campaign id from agent table ::\t"+campaign_id1);
				logger.log(LogStatus.FAIL, " Campaign id from agent_live table ::\t"+campaign_id);
			}

		}
		else
		{
			logger = extent.startTest("Ready_button ");
			//Assert.assertTrue(true);
			logger.log(LogStatus.FAIL, "Ready_button not found ");
			if(agent_state.equals("FREE"))
			{
				logger.log(LogStatus.PASS, " agent_state from data base Before click on ready Button::\t"+agent_state_before_login);
				logger.log(LogStatus.PASS, " agent_state from data base After click on ready Button ::\t"+agent_state);
			}
			else
			{
				logger.log(LogStatus.FAIL, " agent_state from data base Before click on ready Button::\t"+agent_state_before_login);
				logger.log(LogStatus.FAIL, " agent_state from data base After click on ready Button ::\t"+agent_state);
			}
			if(dialer_type.equals("PROGRESSIVE")||dialer_type.equals("PREVIEW"))
			{
				logger.log(LogStatus.PASS, " dialer_type from data base ::\t"+dialer_type);
			}
			else
			{
				logger.log(LogStatus.FAIL, " dialer_type from data base ::\t"+dialer_type);
			}
			if(campaign_id1.equals(campaign_id))
			{
				logger.log(LogStatus.PASS, " Campaign id from agent table ::\t"+campaign_id1);
				logger.log(LogStatus.PASS, " Campaign id from agent_live table ::\t"+campaign_id);
			}
			else
			{
				logger.log(LogStatus.FAIL, " Campaign id from agent table ::\t"+campaign_id1);
				logger.log(LogStatus.FAIL, " Campaign id from agent_live table ::\t"+campaign_id);
			}
		}

	}

}
