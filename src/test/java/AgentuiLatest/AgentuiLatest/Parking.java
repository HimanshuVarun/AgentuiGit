
package AgentuiLatest.AgentuiLatest ;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;
public class Parking extends Home_page
{
	public static  String number1,add_agent,Disposition,parkCall;
	public static int call_count_excel,f;
	public static void park() throws InterruptedException
	{
		Logger log=Logger.getLogger("Make call test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start parking test case");
		Thread.sleep(2000);
		if(isElementPresent(By.name("switchPreview")))
		{

			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.document.getElementById('progressiveMode').click()");
			driver.findElement(By.name("switchPreview")).click();	
			System.out.println("click on Preview");
		}
		else
		{
			screen(driver," preview button not found ");
			System.out.println("preview button not found");
		}

		Hs=Hw.getSheet("Sheet1");
		call_count_excel=Hs.getLastRowNum();
		System.out.println("total number in excel\t "+call_count_excel);
		number1=Hs.getRow(1).getCell(1).getStringCellValue();
		System.out.println("phone number from excel sheet"+number1);
		Disposition=Hs.getRow(1).getCell(2).getStringCellValue();
		//Make a new call
		if(isElementPresent(By.name("makeNewCall")))
		{
			//Thread.sleep(1000);
			driver.findElement(By.name("makeNewCall")).click();
			//	System.out.println("click on ready button");
			//  String number=Hs.getRow(1).getCell(1).getStringCellValue();
			driver.findElement(By.name("manualPhoneNo")).clear();
			driver.findElement(By.name("manualPhoneNo")).sendKeys(number1);
			//driver.findElement(By.name("manualDial")).click();
			Thread.sleep(4000);	
			driver.findElement(By.cssSelector("input.phoneDialButtonBackground:nth-child(3)")).click();
		}
		else
		{
			screen(driver," Makecall button not found ");
			System.out.println("make call button nou found");
		}
		if(isElementPresent(By.name("call_park")))
		{
			//Thread.sleep(1000);
			driver.findElement(By.name("call_park")).click();
			System.out.println("click on park call button");

		}
		else
		{
			screen(driver," park call button not found ");
			System.out.println("park call button not found");
		}
		if(isElementPresent(By.id("backBreak")))
		{
			JavascriptExecutor js1=(JavascriptExecutor)driver;
			js1.executeScript("window.document.getElementById('backBreak').click()");
		}


		//disconnect call
		/*  if(isElementPresent(By.name("disconnect")))
           {
				 driver.findElement(By.name("disconnect")).click();
				 System.out.println("click on disconnect button");
				 Thread.sleep(2000);
		   }
           else
  		 {
  			 screen(driver," Disconnect button not found ");
  			 System.out.println("disconnect button not found");
  		 }*/

	}

	public static void  parkExtent()//&&phone_no.equals(number1)&&p_no_f_extended.equals(number1)&&p_f_d_lookup.equals(number1)&&p_no_F_d_state.equals(number1)
	{
		Logger log=Logger.getLogger("call park test case extent report method");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start call park  test case extent report method");
		parkCall=callPark;
		if(call_park_f_campaign.equals("1")&&callPark!=null)
		{
			logger = extent.startTest("Call parking ");
			logger.log(LogStatus.PASS, "park id from call_park table ::\t"+callPark);
			logger.log(LogStatus.PASS, "parking state from campaign table  ::\t"+call_park_f_campaign);
		}
		else
		{
			logger = extent.startTest("Call parking ");
			logger.log(LogStatus.FAIL, "parking state from campaign table  ::\t"+call_park_f_campaign);
			if(parkCall==null)
			{
				logger.log(LogStatus.FAIL, "Data not avilable in call_park table ::\t");
			}
			else
			{
				logger.log(LogStatus.FAIL, "park id from call_park table ::\t"+callPark);

			}
		}
	}
}

