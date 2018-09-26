	package GUI;


import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import pomClasses.GUIFunctions;
import pomClasses.ReadWriteExcel;

public class AVIS_Walkup_Rentals {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Downloads\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("disable-infobars"); 
		WebDriver driver=new ChromeDriver(options);		
		driver.get("https://uat.ccrgservices.com/wizardgui/ui/wizard.jsf?mnemonic=JFK");
		GUIFunctions functions = new GUIFunctions(driver);
		//functions.link(tokenURL, thinClient);
		/* Login */
		functions.login("qa.user", "Avis2018#");
	
		//driver.findElement(By.xpath("//input[@name='username']")).sendKeys("qa.user");
		//driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("Avis2018#");
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		//Thread.sleep(5000);
		//driver.navigate().refresh();
		
		//ReadWriteExcel rwe = new ReadWriteExcel("C:\\Downloads\\Selenium\\AVIS\\TestData\\AVIS_GUITestData_WalkUp_Rental_CheckOut.xlsx");
		//String TestCaseName = rwe.getCellData("INPUT_DATA", 1, 4);
		//System.out.println("Test case name is :" +TestCaseName);
		Thread.sleep(5000);
		//.setCellData("Walkup_Rental", 1,29,TestCaseName);
		driver.findElement(By.xpath("//input[@id='rateShopCommandButton']")).click();
		driver.findElement(By.xpath("//input[@id='resRateLookupDlg:rateLookupForm:pickupDate_hid']")).sendKeys("10/22/18");
		driver.findElement(By.xpath("//input[@id='resRateLookupDlg:rateLookupForm:pickupTime']")).sendKeys("03:31 PM");
		driver.findElement(By.xpath("//input[@id='resRateLookupDlg:rateLookupForm:returnDate_hid']")).sendKeys("10/23/18");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='resRateLookupDlg:rateLookupForm:returnTime']")).sendKeys("12:35 PM");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='form-horizontal']//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12']")).click();
		driver.findElement(By.xpath("//input[@id='resRateLookupDlg:rateLookupForm:wizardNumber']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='resRateLookupDlg:rateLookupForm:coupon']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='resRateLookupDlg:rateLookupForm:qty']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='resRateLookupDlg:rateLookupForm:rateShop']")).click();
		Thread.sleep(9000);
		
		String Car_val =driver.findElement(By.xpath("//*[@id='resRateLookupDlg:rateLookupForm:groups_data']")).getAttribute("innerText"); 
		String[] temp_Car_Val = Car_val.split("\\n");
	     int len_tempCar= temp_Car_Val.length;
	     String Excel_ValCar = "F"; /// This is hardcoded y
	     for (int i=1;i< len_tempCar;i++){
	          System.out.println(temp_Car_Val[i]);
	          String[] Ary_Cls_name = temp_Car_Val[i].split("-");
	          String Cls_name = Ary_Cls_name[0].trim();
	        //  System.out.println(Cls_name);
	          if (Excel_ValCar.equals(Cls_name) ){
	              System.out.println(i);
	              int j=i-1;
	              String Rate = "//input[@value='standard,"+j+"']";
	            		//input[@value='standard,0']
	              driver.findElement(By.xpath(Rate)).click();
	            		  break;
	              
	          }
	                
	     }
		
		
		driver.findElement(By.xpath("//input[@id='resRateLookupDlg:rateLookupForm:checkOutButton']")).click();
		// walk up
		//driver.findElement(By.xpath("//input[@id='walkupCommandwalkup']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='walkUpDialog:walkUpDailogForm:walkuplastname']")).sendKeys("adddsk");
		driver.findElement(By.xpath("//input[@id='walkUpDialog:walkUpDailogForm:walkupfirstname']")).sendKeys("kdddadl");
		// if wizard number needs to be given as input  
		//driver.findElement(By.xpath("//input[@id='walkUpDialog:walkUpDailogForm:walkupwizardnumber']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='walkUpDialog:walkUpDailogForm:walkupContinue']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseCountry']")).sendKeys("US");
		driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseState']")).sendKeys("NY");
		driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseNumber']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:dateOfBirth']")).sendKeys("08/23/89");
		driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:company']")).sendKeys("abg");
		//Address 1
		driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address1']")).sendKeys("12,eiro");
		//Address 2
		driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address2']")).sendKeys("12,eiro");
		//Address 3
		driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address3']")).sendKeys("Parsippany,NJ,07054,US");
		//Contact Info
		driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:contactInfo']")).sendKeys("24566446");
		//E-Mail 
		driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:wizconEmailInput']")).sendKeys("abgs@abg.com");
		//Freq.Travel
		driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:ftnType']")).sendKeys("");
		//Number
		driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:ftNumber']")).sendKeys("");
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		   js.executeScript("window.scrollBy(0,400)");
		   Thread.sleep(2000);
		
	   WebElement CheckOut_lstCOCCDC = driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccType"));
           Select MOPDropDownList    = new Select(CheckOut_lstCOCCDC);
           MOPDropDownList.selectByVisibleText("American Express");
              Thread.sleep(3000);
           driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccNumber")).sendKeys("371508953893008"); 
              Thread.sleep(3000);            
              driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccExpireMonth")).sendKeys("12"); 
              Thread.sleep(3000);
              driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccExpireYear")).sendKeys("21"); 
              Thread.sleep(3000);            
              WebElement CheckOut_MOPReason = driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:creditCard:swipe:paymentReason"));
           Select MOPReasonDropDownList  = new Select(CheckOut_MOPReason);
           MOPReasonDropDownList.selectByVisibleText("No reader/reader not working");
           Thread.sleep(3000);
           
           // Vehicle Selection
           driver.findElement(By.xpath("//div[@ng-show='!isOffline']//input[@id='menulist:checkoutContainer:checkoutForm:mvaOrParkingSpace']")).sendKeys("64459010");
           driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:mileage']")).sendKeys("1200");
           driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:checkoutSpace']")).sendKeys("");
           driver.findElement(By.xpath("//input[@id='footerForm:continueVehicleButton']")).click();
           Thread.sleep(10000);
           
           //driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptTable:0:repromptValue")).sendKeys("0");
           driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptSubmitButton")).click();
           
           Thread.sleep(10000);
          /* driver.findElement(By.id("footerForm:completeCheckoutButton")).click();
          driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptSubmitButton")).click();               
           Thread.sleep(7000); */

        /*   if("American Express".equals("American Express"))
           {
                driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptTable:0:repromptValue")).sendKeys("1234");
                driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptSubmitButton")).click();
                Thread.sleep(7000);
           }
           else
           {
                driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptTable:0:repromptValue")).sendKeys("123");
                driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptSubmitButton")).click();
                Thread.sleep(7000);
           }*/
		   Thread.sleep(10000);
		   
           driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptTable:0:repromptValue")).sendKeys("1234");
           driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptSubmitButton")).click();

           String strCOLNFNGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteName")).getText();
           Thread.sleep(7000);
           System.out.println(" Last Name First Name value is " + strCOLNFNGetText);
           String strCOVehicleModelGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteVehicle")).getText();
           Thread.sleep(7000);
           System.out.println(" Vehicle Model value is " + strCOVehicleModelGetText);
           String strCOResNoGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteResNum")).getText();
           Thread.sleep(7000);
           System.out.println(" Reservation No value is " + strCOResNoGetText);
           String strCOMVAGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteMVA")).getText();
           Thread.sleep(7000);
           System.out.println(" MVA No value is " + strCOMVAGetText);
           String strCORANoGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteRANumber")).getText();
           Thread.sleep(7000);
           System.out.println(" RA Number value is " + strCORANoGetText);
           String strCOLicensePlateNoGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteLicensePlate")).getText();
           Thread.sleep(7000);
           System.out.println(" License Plate Number value is " + strCOLicensePlateNoGetText);
           String strCOEstimatedCostGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteEstimatedCost")).getText();
           Thread.sleep(7000);
           System.out.println(" Estimated Cost value is " + strCOEstimatedCostGetText);
           String strCOSystemMsgGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteOut")).getText();
           Thread.sleep(7000);
           System.out.println(" CheckOut Complete System Message value is " + strCOSystemMsgGetText);
           
           driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteDoneButton")).click();
           Thread.sleep(7000);

           
           
          
		
		String ScreenShotPath = "C:\\Users\\yeliyura\\Desktop\\AvcExport";
		String testcasename ="TC1_walkup_dd";
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File( ScreenShotPath +testcasename+ ".pgn"));
        //sdf.format(d)+
        
        
		
		

	}

}
