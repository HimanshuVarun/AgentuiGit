package AgentuiLatest.AgentuiLatest ;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.relevantcodes.extentreports.LogStatus;


public class Break_and_Back extends Home_page
{
	public static void break_() throws Exception
	{
		Logger log=Logger.getLogger("Break test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start break test case");
		Thread.sleep(2000);
		//BREAK 
		if( isElementPresent(By.name("recess_btn")))
		{
			log.info("in  break condtion");
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.document.getElementById('takeBreak').click()");
			//  driver.findElement(By.name("recess_btn")).click();	
			System.out.println("click on break");
			log.info("Cliclk on break button ");
			Thread.sleep(500);
		}
		else
		{
			log.info("Break button not found");
			screen(driver," Break button not found ");
			System.out.println("Break button not found");
		}
	}
	public static void  BreakExtent()
	{

		Logger log=Logger.getLogger(" extent report Break test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start brak test case extent report method");
		if(break_type.equals("BREAK"))
		{
			logger = extent.startTest("Break ");
			//Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Break  test case is pass ");
			logger.log(LogStatus.PASS, " break_type from agen_live table  ::\t"+break_type);
			if(is_paused.equals("1"))
			{

				logger.log(LogStatus.PASS, " is_paused from agent_live table ::\t"+is_paused);
				// logger.log(LogStatus.PASS, "pause_duration from agent_live table ::\t"+pause_duration);
			}
			else
			{

				logger.log(LogStatus.FAIL, " is_paused from agent_live table ::\t"+is_paused);
				//logger.log(LogStatus.FAIL, "pause_duration from agent_live table ::\t"+pause_duration);
			}

		}
		else
		{
			logger = extent.startTest("Break ");
			//Assert.assertTrue(true);
			logger.log(LogStatus.FAIL, "Break  test case is fail ");
			logger.log(LogStatus.FAIL, " break_type from agen_live table  ::\t"+break_type);
			if(is_paused.equals("1"))
			{

				logger.log(LogStatus.PASS, " is_paused from agent_live table ::\t"+is_paused);
				// logger.log(LogStatus.PASS, "pause_duration from agent_live table ::\t"+pause_duration);
			}
			else
			{

				logger.log(LogStatus.FAIL, " is_paused from agent_live table ::\t"+is_paused);
				// logger.log(LogStatus.PASS, "pause_duration from agent_live table ::\t"+pause_duration);
			}

			System.out.println("Break  test case is fail because some data not available in data base(some column missing in table campaign)");
		}
	}
	public static void back() throws Exception
	{

		Logger log=Logger.getLogger("Back test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start back test case");
		Thread.sleep(2000);
		if( isElementPresent(By.name("back_btn")))
		{ 
			JavascriptExecutor js1=(JavascriptExecutor)driver;
			js1.executeScript("window.document.getElementById('backBreak').click()");
			// driver.findElement(By.name("back_btn")).click();	
			System.out.println("Back from break");
		}
		else
		{
			screen(driver," Back button not found ");
			System.out.println("Back button not found");
		}
	}
	public static void  BackExtent()
	{
		Logger log=Logger.getLogger(" extent report Break test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start back test case extent report method");
		if(pause_duration>0)//&&break_count>0
		{
			logger = extent.startTest("Back_from_break ");
			//Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Back _from_break test case is pass ");
			logger.log(LogStatus.PASS, "pause_duration from agent_live table ::\t"+pause_duration);
			if(is_paused.equals("0"))
			{
				logger.log(LogStatus.PASS, " is_paused from agent_live table ::\t"+is_paused);
				logger.log(LogStatus.PASS, "break_count from agent_live table ::\t"+break_count);
			}
			else
			{
				logger.log(LogStatus.FAIL, " is_paused from agent_live table ::\t"+is_paused);
			}
			if(break_type.equals(""))
			{
				logger.log(LogStatus.PASS, " break_type from agent_live table  ::\t"+break_type);
			}
			else
			{
				logger.log(LogStatus.FAIL, " break_type from agen_live table  ::\t"+break_type);
			}
		}
		else
		{
			logger = extent.startTest("Break_from_break ");
			//Assert.assertTrue(true);
			logger.log(LogStatus.FAIL, "Back_from_break  test case is fail ");
			logger.log(LogStatus.FAIL, "pause_duration from agent_live table ::\t"+pause_duration);
			//logger.log(LogStatus.FAIL, "break_count from agent_live table ::\t"+break_count);
			if(is_paused.equals("0"))
			{
				logger.log(LogStatus.PASS, " is_paused from agent_live table ::\t"+is_paused);
				logger.log(LogStatus.PASS, "break_count from agent_live table ::\t"+break_count);
			}
			else
			{
				logger.log(LogStatus.FAIL, " is_paused from agent_live table ::\t"+is_paused);
			}
			if(break_type.equals(""))
			{
				logger.log(LogStatus.PASS, " break_type from agent_live table  ::\t"+break_type);
			}
			else
			{
				logger.log(LogStatus.FAIL, " break_type from agen_live table  ::\t"+break_type);
			}

		}
	}
}
