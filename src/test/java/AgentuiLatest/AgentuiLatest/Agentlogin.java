package AgentuiLatest.AgentuiLatest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class Agentlogin extends Home_page
{
	public static void login() throws Exception
	{
		try {
			AgentId=Hs.getRow(1).getCell(3).getStringCellValue();
			driver.findElement(By.name("agent_id")).clear();
			driver.findElement(By.name("agent_id")).sendKeys(AgentId);	
			Thread.sleep(2000);
			if(isElementPresent(By.name("updateIP")))
			{
				driver.findElement(By.name("updateIP")).click();
			}
		}
		catch(TimeoutException e)
		{
			//System.out.println("time out exception "+e.getMessage());
			System.out.println("time out exception in agent login try block");
			//	e.printStackTrace();
		}
		Thread.sleep(5000);
		// driver.navigate().refresh();
		Data();
		agent_state_before_login=agent_state;
		dialer_type_before_pre=dialer_type;
		automode1=autoMode;
		System.out.println(agent_state_before_login);
	}

	public static void AgentLoginExtent()
	{
		Logger log=Logger.getLogger("Agent Login  test case extent report");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("Start AgentLogin  test case extent report method ");
		if(AgentId.equals(Agentid))
		{
			logger = extent.startTest("AgentLogin");
			//Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Agent login  test case is pass");
			logger.log(LogStatus.PASS, "Agent_Id From excel is ::\t"+AgentId);
			logger.log(LogStatus.PASS, "Agent_Id From Data base is ::\t"+Agentid);

			if(dialer_type.equals("PROGRESSIVE"))
			{
				logger.log(LogStatus.PASS, " dialer_type from data base ::\t"+dialer_type); 
			}
			else
			{
				logger.log(LogStatus.FAIL, " dialer_type from data base ::\t"+dialer_type); 
			}
			if(agent_state.equals("CLOSURE"))
			{
				logger.log(LogStatus.PASS, " agent_state from data base  ::\t"+agent_state);
			}
			else
			{
				logger.log(LogStatus.FAIL, " agent_state from data base ::\t"+agent_state); 
			}
			if(campaign_id1.equals(campaign_id))
			{
				logger.log(LogStatus.PASS, " Campaign_id from Agent_live table ::\t"+campaign_id);
				logger.log(LogStatus.PASS, " Campaign_id from Agent table ::\t"+campaign_id1);
			}
			else
			{
				logger.log(LogStatus.FAIL, " Campaign_id from Agent_live table ::\t"+campaign_id);
				logger.log(LogStatus.FAIL, " Campaign_id from Agent table ::\t"+campaign_id1);
			}


		}
		else
		{
			logger = extent.startTest("AgentLogin ");
			logger.log(LogStatus.FAIL, "Agent not successfully Login");
			logger.log(LogStatus.FAIL, "Agent_Id From excel is ::\t"+AgentId);
			logger.log(LogStatus.FAIL, "Agent_Id From Data base is ::\t"+Agentid);

			if(dialer_type.equals("PROGRESSIVE"))
			{
				logger.log(LogStatus.PASS, " dialer_type from data base ::\t"+dialer_type); 
			}
			else
			{
				logger.log(LogStatus.FAIL, " dialer_type from data base ::\t"+dialer_type); 
			}
			if(agent_state.equals("CLOSURE"))
			{
				logger.log(LogStatus.PASS, " agent_state from data base  ::\t"+agent_state);
			}
			else
			{
				logger.log(LogStatus.FAIL, " agent_state from data base ::\t"+agent_state); 
			}
			if(campaign_id1.equals(campaign_id))
			{
				logger.log(LogStatus.PASS, " Campaign_id from Agent_live table ::\t"+campaign_id);
				logger.log(LogStatus.PASS, " Campaign_id from Agent table ::\t"+campaign_id1);
			}
			else
			{
				logger.log(LogStatus.FAIL, " Campaign_id from Agent_live table ::\t"+campaign_id);
				logger.log(LogStatus.FAIL, " Campaign_id from Agent table ::\t"+campaign_id1);
			}
		}
	}
}
