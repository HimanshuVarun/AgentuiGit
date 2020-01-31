package AgentuiLatest.AgentuiLatest ;

import java.io.PrintStream;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
public class Test_Base extends Home_page
{ 
	@BeforeTest                                                   
	public void before() throws Exception                          
	{
		Logger log=Logger.getLogger("Test_czentrix");
		PropertyConfigurator.configure("Log4j.Properties");  
		log.info("start open browser test case");
		System.out.println("Start Browser test case");
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/STMExtentReport.html",true);
		extent.addSystemInfo("Host name", "software Testing Material");
		extent.addSystemInfo("Environment", "Automation Testing");
		extent.addSystemInfo("User Name", "Himanshu");
		Home_page.openBrowser();
		logger = extent.startTest("openbrowser");
		//Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "browser test case is pass");
		//  screen(driver, "Browser start");
	}
	@Test(priority=1) 
	public void AgentLogin() throws Exception 
	{
		System.out.println("Start agent login test case");
		Agentlogin.login();
		System.out.println("Call extent report method");
		Agentlogin.AgentLoginExtent();
	}
	@Test(priority=2)
	public void Ready_button() throws Exception
	{
		System.out.println("start ready button test  case");
		Ready_button.ready();
		System.out.println("call data base method in ready button ");
		Data();
		System.out.println("call extent report  method in ready button");
		Ready_button.ReadyExtent();
		System.out.println("Ready_button test case  is closed");
	}
	@Test(priority=3)
	public void preview_test() throws Exception
	{
		System.out.println("start preview button test  case");
		Preview_button.pre_();
		System.out.println("call data base method in preview button");
		Thread.sleep(1000);
		Data();
		System.out.println("call preview button extent report in preview button");
		Preview_button.PreviewExtent();
		System.out.println("close  preview button test case ");
	}
	@Test(priority=4)
	public void progressive_test() throws Exception 
	{
		System.out.println("start progressive button test  case");
		Progressive.pro();
		System.out.println("call data base method in progressive test case");
		//	Thread.sleep(1000);
		Data();
		System.out.println("call progressive button extent report in progressive button");
		Progressive.ProgeressiveExtent();
		System.out.println("close  progressive button test case");
	}
	@Test(priority=5)
	public void break_Test() throws Exception
	{
		System.out.println("start break button test  case");
		Break_and_Back.break_();
		System.out.println("call data base method in break test  case");
		Data();
		System.out.println("call extent report method in break test  case");
		Break_and_Back.BreakExtent();
	}

	@Test(priority=6)
	public void back_Test() throws Exception
	{
		System.out.println("start back button test  case");
		Break_and_Back.back();
		System.out.println("call data base method in back button test  case");
		Thread.sleep(1000);
		Data();
		System.out.println("call extent report method in back test  case");
		Break_and_Back.BackExtent();
	}
	@Test(priority=7)
	public void auto_mode() throws Exception
	{
		System.out.println("start auto button test  case");
		Switch_auto.switch_();
		System.out.println("call data base method in auto button test  case");
		Data();
		System.out.println("call extent report method in auto button test  case");
		Switch_auto.SwitchToAutoExtent();
	}
	@Test(priority=8)
	public void Reset_auto() throws Exception
	{
		System.out.println("start reset button test  case");
		Switch_auto.back_auto();
		System.out.println("call data base method in reset button test case");
		Data();
		System.out.println("call extent report method in reset button test case");
		Switch_auto.ResetAutoModeExtent();
	}

	@Test(priority=9)	
	public void Call_test() throws Exception
	{
		System.out.println("start make call button test  case");
		Make_call.call();  
		System.out.println("call data base method in make call test case");
		//Thread.sleep(1000);
		Data();
		System.out.println("call extent report method in make call test case");
		Make_call.MakeCallExtent();
	}	

	//@Test(priority=9)	
	public void parking() throws Exception
	{
		System.out.println("start parking button test  case");
		Parking.park();
		System.out.println("call data base method in parking test case");
		Data();
		System.out.println("call extent report method in parking test case");
		Parking.parkExtent();
	}	


	//@Test(priority=10)	
	public void unPark() throws Exception
	{
		System.out.println("start unPark button test  case");
		UnparkCall.unPark();
		System.out.println("call data base method in unPark test case");
		System.out.println("call extent report method in unPark test case");
		//UnparkCall.unparkExtent();
	}	
	@Test(priority=10)
	public void Redial() throws Exception
	{
		System.out.println("start Redial button test  case");
		Redial.redial();
		System.out.println("call data base method in Redial test case");
		Data();
		System.out.println("call extent report method in Redial test case");
		Redial.RedialExtent();
	}

	@Test(priority=11)
	public void log() throws Exception
	{
		Logout.logout();
		Thread.sleep(1000);
		Data();
		Logout.LogoutExtent();
	}


}
