package AgentuiLatest.AgentuiLatest ;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.relevantcodes.extentreports.LogStatus;


public class Switch_auto extends Home_page
{
	public static void switch_() throws Exception
	{
		Logger log=Logger.getLogger("Switch to auto mode  test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start Switch to auto mode  test case");
		Thread.sleep(2000);
		if(isElementPresent(By.name("switchPreview")))
		{

			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.document.getElementById('progressiveMode').click()");
			//  driver.findElement(By.name("recess_btn")).click();	
			System.out.println("click on break");
		}
		else
		{
			screen(driver,"Preview button not found in Switch_auto mode test case");
		}

		Thread.sleep(2000);
		if(isElementPresent(By.name("makeAutoCall")))
		{
			driver.findElement(By.name("makeAutoCall")).click();
			System.out.println("click on switch to auto mode");
		}
		else
		{
			screen(driver,"Switch to auto_mode  button not found");
		}
	}
	public static void  SwitchToAutoExtent()
	{
		Logger log=Logger.getLogger("Switch to auto mode  test case extent report");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start Switch to auto mode  test case extent report method ");
		if(autoMode==1)
		{
			logger = extent.startTest("auto_mode");
			//Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "auto_mode  test case is pass ");
			logger.log(LogStatus.PASS, "  autoMode from agent live table before click on  autoMode button ::\t"+ automode1);
			logger.log(LogStatus.PASS, "  autoMode from agent live table after  click  on autoMode ::\t"+ autoMode);
			automode1=autoMode;
		}
		else
		{
			logger = extent.startTest(" autoMode ");
			//Assert.assertTrue(true);
			logger.log(LogStatus.FAIL, "  autoMode  test case is fail because some data not available in data base");
			logger.log(LogStatus.FAIL, "  autoMode from agent live table  before click on  autoMode button ::\t"+ automode1);
			logger.log(LogStatus.FAIL, "  autoMode from agent live table after  click on autoMode ::\t"+ autoMode);
			automode1=autoMode;
			System.out.println("auto mode  test case is fail because some data not available in data base(some column missing in table campaign)");
		}
	}
	public static void back_auto() throws Exception
	{
		Logger log=Logger.getLogger("Back to auto mode  test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start back to auto mode  test case");

		Thread.sleep(2000);
		if(isElementPresent(By.name("resetAutoCall")))
		{
			driver.findElement(By.name("resetAutoCall")).click();
			System.out.println("click on Reset auto mode");
		}
		else
		{
			screen(driver,"Back to auto_mode  button not found");
		} 
	}
	public static void  ResetAutoModeExtent()
	{
		Logger log=Logger.getLogger("Back to auto mode  test case extent report ");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start back to auto mode  test case extent report method ");
		if(autoMode==0)
		{
			logger = extent.startTest("Back_auto_mode");
			//Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "auto_mode  test case is pass ");
			logger.log(LogStatus.PASS, "  autoMode from agent live table  before click on  Reset_auto button ::\t"+ automode1);
			logger.log(LogStatus.PASS, "  autoMode from agent live table::\t"+ autoMode);
		}
		else
		{
			logger = extent.startTest(" Back_auto_Mode ");
			//Assert.assertTrue(true);
			logger.log(LogStatus.FAIL, " autoMode  test case is fail ");
			logger.log(LogStatus.FAIL, "  autoMode from agent live table  before click on  Reset_auto button ::\t"+ automode1);
			logger.log(LogStatus.FAIL, "  autoMode from agent live table ::\t"+ autoMode);
			System.out.println("reset auto  test case is fail because some data not available in data base(some column missing in table campaign)");
		}
	}
}
