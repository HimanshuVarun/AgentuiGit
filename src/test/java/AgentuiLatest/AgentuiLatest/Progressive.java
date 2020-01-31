package AgentuiLatest.AgentuiLatest ;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;
public class Progressive extends Home_page
{
	public static void pro() throws Exception
	{
		Logger log=Logger.getLogger("Progressive button test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start pogressive button   test case");
		Thread.sleep(2000);
		if(isElementPresent(By.name("switchProgressive")))
		{
			driver.findElement(By.name("switchProgressive")).click();
			System.out.println("click on progressive");
		}
		else
		{
			screen(driver," Progressive button not found ");
			System.out.println("Progressive button not found");
		}
	}
	public static void  ProgeressiveExtent()
	{
		Logger log=Logger.getLogger("Progressive button test case extent report");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start pogressive button   test case extent report method");
		if(dialer_type.equals("PROGRESSIVE"))
		{
			logger = extent.startTest("PROGRESSIVE");
			//Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Progressive  test case is pass ");
			logger.log(LogStatus.PASS, " autoMode  from agent_live table ::\t"+autoMode);
			logger.log(LogStatus.PASS, " dialer_type from agent live table  before click on PROGRESSIVE button ::\t"+dialer_type_before_pre);
			logger.log(LogStatus.PASS, " dialer_type from agent live table ::\t"+dialer_type);
			logger.log(LogStatus.PASS, " Campaign id from agent table ::\t"+campaign_id1);
			logger.log(LogStatus.PASS, " Campaign id from agent_live table ::\t"+campaign_id);
		}
		else
		{
			logger = extent.startTest("PROGRESSIVE ");
			//Assert.assertTrue(true);
			//  logger.log(LogStatus.FAIL, " dialer_type from agent live table  before click on preview button ::\t"+dialer_type_before_pre);
			logger.log(LogStatus.FAIL, " dialer_type from agent live table  ::\t"+dialer_type);
		}
	}
}
