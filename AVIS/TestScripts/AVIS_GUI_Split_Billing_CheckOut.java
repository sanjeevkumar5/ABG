/**
'#############################################################################################################################
'## SCRIPT NAME:                           GUI_Split_Billing_CheckOut_AVIS
'## BRAND:                                 AVIS
'## DESCRIPTION:                           Split Billing Checkout.
'## FUNCTIONAL AREA :                      Checkout
'## PRECONDITION:                          All the required Test Data should be available in Test Data Sheet.
'## OUTPUT:                                Split billing checkout should be successful.
'#############################################################################################################################
 **/

package methods;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pomClasses.ReadWriteExcel;

public class GUI_Split_Billing_CheckOut_AVIS
{
   
   public void clickLogout(ChromeDriver driver)
   {
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  String clickLogoutIcon = "document.getElementById('headerLogOutButton').click()";
	  jse.executeScript(clickLogoutIcon);
	  String clickLogoutBtn = "document.getElementById('logoutForm:yesLogoutButton').click()";
	  jse.executeScript(clickLogoutBtn);
   }
   
   public static void main(String[] args) throws IOException, Exception, FileNotFoundException
   {   
	  // Read input from excel
	  // need to find the no of iterations / iterations count.
	  
	  String Temp = "Location";
	  
	  ChromeDriver driver = null;
	  
	  ReadWriteExcel rwe  = new ReadWriteExcel("C:\\GitHub\\ABG\\AVIS\\TestData\\InternetGUI\\GUI_Split_Billing_CheckOut_AVIS_USA.xlsx");
      
	  int intRowCount = rwe.intRowCount;
	  
	  System.out.println(" Total row count in Split Billing test data sheet is : " + intRowCount);
	  
	  for (int k=1;k<=intRowCount;k++)
	  {

         String Execute = rwe.getCellData("INPUT_DATA",k,2);
         
		 if (Execute.equals("Y"))
         {
			
			String outSTA = rwe.getCellData("INPUT_DATA", k, 10);
			
			System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Selenium\\WebDrivers\\ChromeDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     		System.out.println(" Current iteration : " + k);
/*			String tokenURL = rwe.getCellData("INPUT_DATA", k, 6); //For HWY-ATR ThinClient.
			driver.get(tokenURL);
	        Thread.sleep(2000);
			String WindowHandle = driver.getWindowHandle();
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_T);
			ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(500);*/
			String clientURL = rwe.getCellData("INPUT_DATA", k, 7);
			
			try
			{
			   String thinClient = clientURL+outSTA;
			   driver.get(thinClient);
			   //Assert.assertTrue(driver.getTitle().equals("Login")); // Check whether ThinClient page with title Login is loaded.
			   //Assert.assertTrue(driver.getTitle().equals("Access Manager Login")); // Check whether Internet GUI login page with title Access Manager Login is loaded.
			   Assert.assertTrue(driver.getTitle().contains("Login"));
			}
			catch(Exception e)
			{
			   System.out.println(" Login page not found. ");
			}
                
			//Login to GUI using Internet GUI URL.
			    
			String strUserName = rwe.getCellData("INPUT_DATA", k, 8);
			String strPassword = rwe.getCellData("INPUT_DATA", k, 9);
			driver.findElement(By.name("username")).sendKeys(strUserName);
			driver.findElement(By.name("PASSWORD")).sendKeys(strPassword);
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			Thread.sleep(10000);
            
			String pageTitle = driver.getTitle();
		    if(pageTitle.equals("Avis Budget Group"))
			{
			   System.out.println(pageTitle);
			}
		    else
			{
			   driver.navigate().refresh();
		    }

		    //Reading values from Excel.
			
		    //String strRETURNSTATION              = rwe.getCellData("INPUT_DATA", k, 34);
		    String strRETURNDATE                 = rwe.getCellData("INPUT_DATA", k, 35);
		    //String strRETURNTIME                 = rwe.getCellData("INPUT_DATA", k, 36);
     	    String strLastName                   = rwe.getCellData("INPUT_DATA", k, 16);
     	    String strFirstName                  = rwe.getCellData("INPUT_DATA", k, 17);		       
		    String strDRLICCountry               = rwe.getCellData("INPUT_DATA", k, 18);
		    String strDRLICState                 = rwe.getCellData("INPUT_DATA", k, 19);
		    String strDRLICNo                    = rwe.getCellData("INPUT_DATA", k, 20);
		    String strDRDOB                      = rwe.getCellData("INPUT_DATA", k, 21);
		    String strDRCompany                  = rwe.getCellData("INPUT_DATA", k, 22);
		    String strDRAddressLine1             = rwe.getCellData("INPUT_DATA", k, 23);
		    String strDRAddressLine2             = rwe.getCellData("INPUT_DATA", k, 24);
		    String strDRAddressLine3             = rwe.getCellData("INPUT_DATA", k, 25);
		    String strDRContactInfo              = rwe.getCellData("INPUT_DATA", k, 26);
		    String strDREmailID                  = rwe.getCellData("INPUT_DATA", k, 27);
		    //String strCOMOP                      = rwe.getCellData("INPUT_DATA", k, 28);
		    String strCOCCDC                     = rwe.getCellData("INPUT_DATA", k, 29);
		    String strCARDNO                     = rwe.getCellData("INPUT_DATA", k, 30);
		    String strCOMM                       = rwe.getCellData("INPUT_DATA", k, 31);
		    String strCOYY                       = rwe.getCellData("INPUT_DATA", k, 32);
		    String strMOPREASON                  = rwe.getCellData("INPUT_DATA", k, 33);
		    String strCARGROUP                   = rwe.getCellData("INPUT_DATA", k, 38);
		    //String strREMARKS                    = rwe.getCellData("INPUT_DATA", k, 43);
		    String strCOMVA                      = rwe.getCellData("INPUT_DATA", k, 44);
		    String strCOMILEAGE                  = rwe.getCellData("INPUT_DATA", k, 45);
		    String strCO_SB_MOP                  = rwe.getCellData("INPUT_DATA", k, 47);
		    String strCO_SB_CCDC                 = rwe.getCellData("INPUT_DATA", k, 48);
		    String strCO_SB_CARD_NO              = rwe.getCellData("INPUT_DATA", k, 49);
		    String strCO_SB_CARD_EXP_MM          = rwe.getCellData("INPUT_DATA", k, 50);
		    String strCO_SB_CARD_EXP_YY          = rwe.getCellData("INPUT_DATA", k, 51);
		    String strCO_SB_MOP_REASON           = rwe.getCellData("INPUT_DATA", k, 52);
		    String strCO_SB_DIFF_ADDRESS_OPTION  = rwe.getCellData("INPUT_DATA", k, 53);
		    String strCO_SB_DIFF_ADDR1           = rwe.getCellData("INPUT_DATA", k, 54);
		    String strCO_SB_DIFF_ADDR2           = rwe.getCellData("INPUT_DATA", k, 55);
		    String strCO_SB_DIFF_ADDR3           = rwe.getCellData("INPUT_DATA", k, 56);
		    String strCO_SB_NO_OF_DAYS_OPTION    = rwe.getCellData("INPUT_DATA", k, 57);
		    //String strCO_SB_UPSELL_OPTION        = rwe.getCellData("INPUT_DATA", k, 58);
		    //String strCO_SB_TANDM_POINTS_OPTION  = rwe.getCellData("INPUT_DATA", k, 59);
		    String strCO_SB_DOLLAR_AMOUNT_OPTION = rwe.getCellData("INPUT_DATA", k, 60);
		    
		    driver.findElement(By.xpath("//input[@id='rateShopCommandButton']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='resRateLookupDlg:rateLookupForm:returnDate_hid']")).sendKeys(strRETURNDATE);
		    Thread.sleep(1000);
		    String strRETURNTIME =  driver.findElement(By.xpath("//input[@id='resRateLookupDlg:rateLookupForm:pickupTime']")).getAttribute("value");
		    System.out.println(" return time " + strRETURNTIME);
		    driver.findElement(By.xpath("//input[@id='resRateLookupDlg:rateLookupForm:returnTime']")).sendKeys(strRETURNTIME);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//div[@class='form-horizontal']//div[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='resRateLookupDlg:rateLookupForm:rateShop']")).click();
		    Thread.sleep(3000);
		    
		    String Car_val = driver.findElement(By.xpath("//*[@id='resRateLookupDlg:rateLookupForm:groups_data']")).getAttribute("innerText"); 
	        String[] temp_Car_Val = Car_val.split("\\n");
	        int len_tempCar= temp_Car_Val.length;
	        String Excel_ValCar = strCARGROUP;
	        
	        for (int i=1;i< len_tempCar;i++)
	        {
	           System.out.println(temp_Car_Val[i]);
	           String[] Ary_Cls_name = temp_Car_Val[i].split("-");
	           String Cls_name = Ary_Cls_name[0].trim();
	           System.out.println(Cls_name);
	           
	           if (Excel_ValCar.equals(Cls_name))
	           {
	              System.out.println(i);
	              int j=i-1;
	              String Rate = "//input[@value='standard,"+j+"']";
	              driver.findElement(By.xpath(Rate)).click();
	              break;
	                   
	           }
	                     
	        }
            
		    //driver.findElement(By.xpath("//input[@name='radioRate' and @type='radio']")).click();;
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='resRateLookupDlg:rateLookupForm:checkOutButton']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='walkUpDialog:walkUpDailogForm:walkuplastname']")).sendKeys(strLastName);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='walkUpDialog:walkUpDailogForm:walkupfirstname']")).sendKeys(strFirstName);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='walkUpDialog:walkUpDailogForm:walkupContinue']")).click();
		    Thread.sleep(10000);
		    driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseCountry']")).sendKeys(strDRLICCountry);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseState']")).sendKeys(strDRLICState);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseNumber']")).sendKeys(strDRLICNo);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:dateOfBirth']")).sendKeys(strDRDOB);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:company']")).sendKeys(strDRCompany);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address1']")).sendKeys(strDRAddressLine1);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address2']")).sendKeys(strDRAddressLine2);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address3']")).sendKeys(strDRAddressLine3);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:contactInfo']")).sendKeys(strDRContactInfo);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:wizconEmailInput']")).sendKeys(strDREmailID);
		    Thread.sleep(3000);
            WebElement CheckOut_lstCOCCDC = driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccType"));
            Select MOPDropDownList        = new Select(CheckOut_lstCOCCDC);
            MOPDropDownList.selectByVisibleText(strCOCCDC);
		    Thread.sleep(3000);
            driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccNumber")).sendKeys(strCARDNO); 
		    Thread.sleep(3000);            
		    driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccExpireMonth")).sendKeys(strCOMM); 
		    Thread.sleep(3000);
		    driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccExpireYear")).sendKeys(strCOYY); 
		    Thread.sleep(3000);            
		    WebElement CheckOut_MOPReason = driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:creditCard:swipe:paymentReason"));
            Select MOPReasonDropDownList  = new Select(CheckOut_MOPReason);
            MOPReasonDropDownList.selectByVisibleText(strMOPREASON);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:mvaOrParkingSpace']")).sendKeys(strCOMVA);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:mileage']")).clear();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:mileage']")).sendKeys(strCOMILEAGE);
            Thread.sleep(5000);
		    driver.findElement(By.xpath("//input[@id='footerForm:continueVehicleButton']")).click();
		    Thread.sleep(7000);
		    driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptSubmitButton")).click();		    
		    Thread.sleep(7000);
		    
		    // ########################Split Billing Flow ############################## //
		    
		    driver.findElement(By.xpath("//input[@id='footerForm:splitBillingButton']")).click();		    
		    Thread.sleep(7000);
		    
		    if(strCOCCDC.equals("American Express"))
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
		    }
		    
		    WebElement CheckOut_SB_MOP         = driver.findElement(By.id("splitBillingForm:paymentMethod"));
            Select CheckOut_SB_MOPDropDownList = new Select(CheckOut_SB_MOP);
            CheckOut_SB_MOPDropDownList.selectByVisibleText(strCO_SB_MOP);
            Thread.sleep(10000);
            WebElement CheckOut_SB_lstCOCCDC         = driver.findElement(By.id("splitBillingForm:splitBillingSwipe:ccType"));
            Select CheckOut_SB_lstCOCCDCDropDownList = new Select(CheckOut_SB_lstCOCCDC);
            CheckOut_SB_lstCOCCDCDropDownList.selectByVisibleText(strCO_SB_CCDC);
            Thread.sleep(10000);
            driver.findElement(By.id("splitBillingForm:splitBillingSwipe:ccNumber")).sendKeys(strCO_SB_CARD_NO); 
		    Thread.sleep(5000);            
		    driver.findElement(By.id("splitBillingForm:splitBillingSwipe:ccExpireMonth")).sendKeys(strCO_SB_CARD_EXP_MM); 
		    Thread.sleep(5000);
		    driver.findElement(By.id("splitBillingForm:splitBillingSwipe:ccExpireYear")).sendKeys(strCO_SB_CARD_EXP_YY); 
		    Thread.sleep(5000);            
		    WebElement CheckOut_SB_MOPReason         = driver.findElement(By.id("splitBillingForm:splitBillingSwipe:paymentReason"));
            Select CheckOut_SB_MOPReasonDropDownList = new Select(CheckOut_SB_MOPReason);
            CheckOut_SB_MOPReasonDropDownList.selectByVisibleText(strCO_SB_MOP_REASON);
            Thread.sleep(5000);
		    driver.findElement(By.id("splitBillingForm:checkoutAuth")).sendKeys("OK/12345"); 
		    Thread.sleep(5000);
		    driver.findElement(By.id("splitBillingForm:checkinAuth")).sendKeys("OK/12345"); 
		    Thread.sleep(5000);
		    
		    if (strCO_SB_DIFF_ADDRESS_OPTION.equals("Yes"))
		    {
			    driver.findElement(By.xpath("splitBillingForm:sameAsPrimaryAddress")).click();		    
			    Thread.sleep(7000);
		    }
		    else
		    {
			    driver.findElement(By.xpath("//input[@id='splitBillingForm:address1']")).sendKeys(strCO_SB_DIFF_ADDR1);
			    Thread.sleep(3000);
			    driver.findElement(By.xpath("//input[@id='splitBillingForm:address2']")).sendKeys(strCO_SB_DIFF_ADDR2);
			    Thread.sleep(3000);
			    driver.findElement(By.xpath("//input[@id='splitBillingForm:address3']")).sendKeys(strCO_SB_DIFF_ADDR3);
			    Thread.sleep(3000);
		    }
			    
			if (strCO_SB_NO_OF_DAYS_OPTION.equals("Yes"))
			{
				driver.findElement(By.id("splitBillingForm:splitBillingNumberOfDays")).click();		    
				Thread.sleep(7000);
				//String strSplitBillingTotalDaysGetText = driver.findElement(By.xpath("//input[@id='splitBillingForm:splitBillingTotalDays']")).getText();
				String strSplitBillingTotalDaysGetText = driver.findElement(By.id("splitBillingForm:splitBillingTotalDays")).getText();
				System.out.println(" Split Billing Total Days Value " + strSplitBillingTotalDaysGetText);
				int strSplitBillingTotalDaysGetText2 = Integer.parseInt(strSplitBillingTotalDaysGetText);
				int strSplitBillingTotalDaysGetText3 = strSplitBillingTotalDaysGetText2/2;
				System.out.println(" strSplitBillingTotalDaysGetText3 value is " +strSplitBillingTotalDaysGetText3);
				String strSplitBillingTotalDaysGetText4 =  Integer.toString(strSplitBillingTotalDaysGetText3);
				//driver.findElement(By.xpath("//input[@id='splitBillingForm:splitBillingSecondCardDays']")).sendKeys(strSplitBillingTotalDaysGetText4);
				driver.findElement(By.id("splitBillingForm:splitBillingSecondCardDays")).sendKeys(strSplitBillingTotalDaysGetText4);
				Thread.sleep(7000);
			}
			//if (strCO_SB_UPSELL_OPTION.equals("Yes"))
			//{
			   //driver.findElement(By.xpath("//input[@id='splitBillingForm:splitBillingUpsell']")).click();		    
			   //Thread.sleep(7000);
			//}
			//if (strCO_SB_TANDM_POINTS_OPTION.equals("Yes"))
			//{
				//driver.findElement(By.xpath("//input[@id='splitBillingForm:splitBillingLoyalty']")).click();		    
				//Thread.sleep(7000);
			//}
			if (strCO_SB_DOLLAR_AMOUNT_OPTION.equals("Yes"))
			{
				//driver.findElement(By.xpath("//input[@id='splitBillingForm:splitBillingDollarAmount']")).click();
				driver.findElement(By.id("splitBillingForm:splitBillingDollarAmount")).click();
				Thread.sleep(7000);
				//String strSplitBillingTotalAmountGetText = driver.findElement(By.xpath("//input[@id='splitBillingForm:splitBillingTotalAmount']")).getText();
				String strSplitBillingTotalAmountGetText = driver.findElement(By.id("splitBillingForm:splitBillingTotalAmount")).getText();
				System.out.println(" Split Billing Total Amount value " + strSplitBillingTotalAmountGetText);
                String[] splitVal = strSplitBillingTotalAmountGetText.split("$");
                System.out.println(splitVal[1] + " found. ");
				int strSplitBillingTotalAmountGetText2 = Integer.parseInt(splitVal[1]);
				int strSplitBillingTotalAmountGetText3 = strSplitBillingTotalAmountGetText2/2;
				System.out.println(" strSplitBillingTotalAmountGetText3 value is " +strSplitBillingTotalAmountGetText3);
				String strSplitBillingTotalAmountGetText4 =  Integer.toString(strSplitBillingTotalAmountGetText3);
				//driver.findElement(By.xpath("//input[@id='splitBillingForm:splitBillingSecondCardAmount']")).sendKeys(strSplitBillingTotalAmountGetText4);
				driver.findElement(By.id("splitBillingForm:splitBillingSecondCardAmount")).sendKeys(strSplitBillingTotalAmountGetText4);
				Thread.sleep(7000);
		    }
            
		    //driver.findElement(By.xpath("//input[@id='splitBillingForm:splitBillingSaveButton']")).click();
		    driver.findElement(By.id("splitBillingForm:splitBillingSaveButton")).click();
		    Thread.sleep(7000);
		    driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptTable:0:repromptValuePassword")).sendKeys("yes");
		    Thread.sleep(7000);
		    driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptSubmitButton")).click();
		    Thread.sleep(7000);
		    
		    // ########################Split Billing Flow ############################## //
		    
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
		    
            //Log out and close tabs.
            
            //GUI_Split_Billing_CheckOut_AVIS Avis = new GUI_Split_Billing_CheckOut_AVIS();
            
            //Avis.clickLogout(driver);
            //Thread.sleep(1000);
            //driver.close();
            //driver.quit();

	     } //End of Execute Condition: Execute.equals("Y").
      } //End of For loop.
   } // End of public static void main.
} // End of GUI_Split_Billing_CheckOut_AVIS Class.