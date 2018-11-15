/**
 * 
 */
package Payless.TestScripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.gui.report.Extentmanager;
import AVIS.CommonFunctions.GUIFunctions;
import AVIS.CommonFunctions.ReadWriteExcel;
/* /**
 * '#############################################################################################################################
 * '## SCRIPT NAME: GUI_CreateRentals_AVIS '## BRAND: AVIS '## DESCRIPTION:
 * Create Rentals for available Reservation
 * products. '## FUNCTIONAL AREA : Reservation Rates Screen '## PRECONDITION:
 * All the required Test Data should be available in Test Data Sheet. '##
 * OUTPUT: Reservation should be created successfully.
 * 
 * 
 * HISTORY 05-SEP-2018 - GUIFunctions class created for GUI Common
 * functionalities and CR functionality
 * '#############################################################################################################################
 * */ 

public class Payless_GUI_CreateRentals
{
	private static final String NULL = null;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void startReport()
	{

		extent = Extentmanager.GetExtent();
	
	}
	@Test
	public void test() throws Exception 
	{
		
		try {

			ReadWriteExcel rwe = new ReadWriteExcel("C:\\Selenium\\Test_Data\\PAYLESS\\Payless_GUITestData_Rental_CheckOut.xlsx");
			int intRowCount     = rwe.intRowCount;
	//	public static void main(String[] args) throws IOException, Exception, FileNotFoundException 
	//
			System.out.println(" test data row count is " + intRowCount);
		// Read input from excel
		
		for (int k = 1; k <=intRowCount; k++)
		{
			
			
			String Execute = rwe.getCellData("Payless_GUI_Rentals", k, 2);
			if (Execute.equals("Y"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\Selenium\\ChromeDriver\\chromedriver.exe");
				WebDriver driver= new ChromeDriver();
				GUIFunctions functions = new GUIFunctions(driver);
				
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println(" iteration " + k);
				 String ptestcasename 	= rwe.getCellData("Payless_GUI_Rentals", k, 4);
				 String pclientURL   	= rwe.getCellData("Payless_GUI_Rentals", k, 7);
				 String poutSTA      	= rwe.getCellData("Payless_GUI_Rentals", k, 10);
				 String pthinClient  	= pclientURL+poutSTA;
				 String puName       	= rwe.getCellData("Payless_GUI_Rentals", k, 8);
				 String ppswd        	= rwe.getCellData("Payless_GUI_Rentals", k, 9);
				 String pResNo      	= rwe.getCellData("Payless_GUI_Rentals", k, 11);
				 String pCustType		= rwe.getCellData("Payless_GUI_Rentals", k, 12);
				 String pWizardNo		= rwe.getCellData("Payless_GUI_Rentals", k, 13);
				 String pLastName		= rwe.getCellData("Payless_GUI_Rentals", k, 14);
				 String pFirstName		= rwe.getCellData("Payless_GUI_Rentals", k, 15);
				 String pCOCountry 		= rwe.getCellData("Payless_GUI_Rentals", k, 16);
				 String pCOState		= rwe.getCellData("Payless_GUI_Rentals", k, 17);
				 String pCODRLICNO 		= rwe.getCellData("Payless_GUI_Rentals", k, 18);
				 String pCODOB			= rwe.getCellData("Payless_GUI_Rentals", k, 19);
				 String pCOCOMPANY		= rwe.getCellData("Payless_GUI_Rentals", k, 20);
				 String pCOADDR1		= rwe.getCellData("Payless_GUI_Rentals", k, 21);
				 String pCOADDR2		= rwe.getCellData("Payless_GUI_Rentals", k, 22);
				 String pCOADDR3		= rwe.getCellData("Payless_GUI_Rentals", k, 23);
				 String pCOCONTACTINFO  = rwe.getCellData("Payless_GUI_Rentals", k, 24);
				 String pCOEMAIL		= rwe.getCellData("Payless_GUI_Rentals", k, 25);
				 String pCOMOP			= rwe.getCellData("Payless_GUI_Rentals", k, 26);
				 String pCOCCDC			= rwe.getCellData("Payless_GUI_Rentals", k, 27);
				 String pCARDNO			= rwe.getCellData("Payless_GUI_Rentals", k, 28);
				 String pCOMM			= rwe.getCellData("Payless_GUI_Rentals", k, 29);
				 String pCOYY			= rwe.getCellData("Payless_GUI_Rentals", k, 30);
				 String pMOPREASON		= rwe.getCellData("Payless_GUI_Rentals", k, 31);
				 String pRETURNSTATION	= rwe.getCellData("Payless_GUI_Rentals", k, 32);
				 String pRETURNDATE		= rwe.getCellData("Payless_GUI_Rentals", k, 33);
				 String pRETURNTIME		= rwe.getCellData("Payless_GUI_Rentals", k, 34);
				 String pCARGROUP		= rwe.getCellData("Payless_GUI_Rentals", k, 35);
				 String pAWD			= rwe.getCellData("Payless_GUI_Rentals", k, 36);
				 String pCOUPON			= rwe.getCellData("Payless_GUI_Rentals", k, 37);
				 String pFTNTYPE		= rwe.getCellData("Payless_GUI_Rentals", k, 38);
				 String pFTNUMBER		= rwe.getCellData("Payless_GUI_Rentals", k, 39);
				 String pREMARKS		= rwe.getCellData("Payless_GUI_Rentals", k, 40);
				 String pCOMVA			= rwe.getCellData("Payless_GUI_Rentals", k, 41);
				 String pCOMILEAGE		= rwe.getCellData("Payless_GUI_Rentals", k, 42);
				 String pINSURANCE		= rwe.getCellData("Payless_GUI_Rentals", k, 43);
				 String pCOUNTERPRODUCT	= rwe.getCellData("Payless_GUI_Rentals", k, 44);
				 String pADRLASTNAME	= rwe.getCellData("Payless_GUI_Rentals", k, 45);
				 String pADRFIRSTNAME	= rwe.getCellData("Payless_GUI_Rentals", k, 46);
				 String pADRDOB			= rwe.getCellData("Payless_GUI_Rentals", k, 47);
				 String pADRCOUNTRY		= rwe.getCellData("Payless_GUI_Rentals", k, 48);
				 String pADRSTATE		= rwe.getCellData("Payless_GUI_Rentals", k, 49);
				 String pADRDRLICNO		= rwe.getCellData("Payless_GUI_Rentals", k, 50);
				 String pADREXPMM		= rwe.getCellData("Payless_GUI_Rentals", k, 51);
				 String pADREXPYY		= rwe.getCellData("Payless_GUI_Rentals", k, 52);
				 String pADRADDR1		= rwe.getCellData("Payless_GUI_Rentals", k, 53);
				 String pADRADDR2		= rwe.getCellData("Payless_GUI_Rentals", k, 54);
				 String pADRADDR3		= rwe.getCellData("Payless_GUI_Rentals", k, 55);
				 String pADRTELEPHONE1	= rwe.getCellData("Payless_GUI_Rentals", k, 56);
				 String pADRTELEPHONE2  = rwe.getCellData("Payless_GUI_Rentals", k, 57);
				 String pADRCCDC		= rwe.getCellData("Payless_GUI_Rentals", k, 58);
				 String pADRCARDNO		= rwe.getCellData("Payless_GUI_Rentals", k, 59);
				 String pADRCCEXPMM		= rwe.getCellData("Payless_GUI_Rentals", k, 60);
				 String pADRCCEXPYY		= rwe.getCellData("Payless_GUI_Rentals", k, 61);

				 
				 
				 
				 driver.get(pthinClient);
				 functions.login(puName, ppswd);
                 String strPageTitle = driver.getTitle();
				 
				 if(strPageTitle.equals("Avis Budget Group"))
				 {
				    System.out.println(" QA.user logging in... ");
				 }
				 else
				 {
					 driver.navigate().refresh(); 
				 }
				 driver.findElement(By.xpath("//a[@data-target='#menulist\\:checkoutlink']")).click();
				 System.out.println("Clicked on Checkout Button");
				 driver.findElement(By.xpath("//input[@id='searchString']")).click();
				 driver.findElement(By.xpath("//input[@id='searchString']")).sendKeys(pResNo);
				 System.out.println("Entered the existing Reservation");
				 driver.findElement(By.xpath("//input[@id='searchCommandLink']")).click();
				 System.out.println("Clicked on the Search Button");
				 Thread.sleep(20000);
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseCountry']")).click();
				  String Country = driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseCountry']")).getAttribute("value");
				  System.out.println("The country is " + Country);
				  if (Country.isEmpty())
				  {
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseCountry']")).sendKeys(pCOCountry);
				 System.out.println("Entered the Country");
				  }
				  
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseState']")).click();
				 String State =driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseState']")).getAttribute("value");
				 System.out.println("The state is " +State );
				 if (State.isEmpty())
				 {
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseState']")).sendKeys(pCOState);
				 System.out.println("Entered the State");
				 }
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseNumber']")).click();
				 String Licence = driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseNumber']")).getAttribute("value");
				 System.out.println("The Licence entered id " +Licence);
				 if (Licence.isEmpty())
				 {
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseNumber']")).sendKeys(pCODRLICNO);
				 System.out.println("Entered the Licence Number");
				 }
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:dateOfBirth']")).click();
				 String DOB= driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:dateOfBirth']")).getAttribute("value");
				 System.out.println("The Date od Birth entered is "+DOB);
				 if (DOB.isEmpty())
				 {	 
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:dateOfBirth']")).sendKeys(pCODOB);
				 System.out.println("Entered the Date of Birth");
				 }
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:company']")).click();
				 String Company = driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:company']")).getAttribute("value");
				 System.out.println("The Company entered is "+Company);
				 if (Company.isEmpty())
				 {
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:company']")).sendKeys(pCOCOMPANY);
				 System.out.println("Entered the Company");
				 }
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address1']")).click();
				 String Add1 = driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address1']")).getAttribute("value");
				 if (Add1.isEmpty())
				 {
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address1']")).sendKeys(pCOADDR1);
				 System.out.println("Entered the Address 1");
				 }
				 String Add2= driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address2']")).getAttribute("value");
				 if (Add2.isEmpty())
				 {
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address2']")).sendKeys(pCOADDR2);
				 System.out.println("Entered the Address 2");
				 }
				 String Add3 = driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address3']")).getAttribute("value");
				 if (Add3.isEmpty())
				 {
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address3']")).sendKeys(pCOADDR3);
				 System.out.println("Entered the Address 3");
				 }
				 String Contact =driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:contactInfo']")).getAttribute("value");
				 if (Contact.isEmpty())
				 {
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:contactInfo']")).sendKeys(pCOCONTACTINFO);
				 System.out.println("Entered the Contact Info");
				 }
				 if(driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:wizconEmailInput']")).isEnabled())
				 {
				 String Email= driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:wizconEmailInput']")).getAttribute("value");
				 if (Email.isEmpty())
				 {
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:wizconEmailInput']")).sendKeys(pCOEMAIL);
				 System.out.println("Entered the Email");
				 }
				 }
				 if(pFTNTYPE != NULL)
				 {
				 String ftntp= driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:ftnType']")).getAttribute("value");
				 if (ftntp.isEmpty())
				 { 
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:ftnType']")).sendKeys(pFTNTYPE);
				 System.out.println("Entered the FTN Type");
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:ftNumber']")).sendKeys(pFTNUMBER);
				 System.out.println("Entered the FTN Number");
				 }
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:verifiedFTN']")).click();
				 System.out.println("Verified the FTN number");
				 }
				 
				// driver.findElement(By.xpath("//input[@id='glyphicon glyphicon-plus']")).click();
				 
				 Select s= new Select(driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:payMethod")));
				 s.selectByValue(pCOMOP);
				 System.out.println("Entered the Method of Payment");
				 Select s2= new Select(driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccType")));
				 s2.selectByValue(pCOCCDC);
				 System.out.println("Entered the Type of Payment");
				 String CardNumber = driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccNumber']")).getAttribute("value");
				 if (CardNumber.isEmpty())
				 {
					
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccNumber']")).sendKeys(pCARDNO);
				 System.out.println("Entered the Card Number");
				 }
				 String Month = driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccExpireMonth']")).getAttribute("value");
				 if (Month.isEmpty())
				 {
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccExpireMonth']")).sendKeys(pCOMM);
					System.out.println("Entered the Expiry Month");
				 }
				 String year= driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccExpireYear']")).getAttribute("value");
				 if (year.isEmpty())
				 {
					driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccExpireYear']")).sendKeys(pCOYY);
					System.out.println("Entered the Expiry Year");
				 }
				 
					Select s3= new Select(driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:creditCard:swipe:paymentReason")));
					s3.selectByValue(pMOPREASON);
					System.out.println("Entered the Reason for payment");
					//driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:creditCard:mopCCI']")).sendKeys("1234");
					//driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:creditCard:authorization']")).sendKeys("OK/1234");
					//driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:rateCode']")).clear();
					//driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:rateCode']")).sendKeys("GB/C");
					String RateCode = driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:rateCode']")).getAttribute("value");
					rwe.setCellData("Payless_GUI_Rentals", k, 62,RateCode);
					driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:mvaOrParkingSpace']")).sendKeys(pCOMVA);
					System.out.println("Entered the MVA number");
					driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:mileage']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:mileage']")).clear();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:mileage']")).sendKeys(pCOMILEAGE);
					System.out.println("Entered the Mileage");
					if(driver.findElement(By.xpath("//input[@id='footerForm:continueVehicleButton']")).isDisplayed())
					{
					driver.findElement(By.xpath("//input[@id='footerForm:continueVehicleButton']")).click();
					}
					Thread.sleep(7000);
					if(driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptOut")).isDisplayed())
					{
					String OptMSG= driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptOut")).getAttribute("value");
					System.out.println("The Output message in vechicle continue screen is "+ OptMSG);
					if(OptMSG.equals("NET RATE ERROR")) 
					{
					System.out.println("ERROR MESSAGE "+OptMSG+" is Displayed");
					rwe.setCellData("Payless_GUI_Rentals", k, 70, OptMSG);
					rwe.setCellData("Payless_GUI_Rentals", k, 71, "FAIL");
					test.log(Status.FAIL, "Fail");
					String ScreenShotPath = "C:\\Selenium\\Screenshots\\Payless\\Payless_Create_Rentals\\";
					functions.ScreenCapture(ScreenShotPath , ptestcasename);
					System.out.println("The Screenshot is taken");
					driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptCloseButton")).click();
					driver.close();
					break;
					}
					else
						if (OptMSG.equals("START DATE INVALID FOR RATE"))
						{
						System.out.println("ERROR MESSAGE "+OptMSG+" is Displayed");
						rwe.setCellData("Payless_GUI_Rentals", k, 70, OptMSG);
						rwe.setCellData("Payless_GUI_Rentals", k, 71, "FAIL");
						test.log(Status.FAIL, "Fail");
						String ScreenShotPath = "C:\\Selenium\\Screenshots\\Payless\\Payless_Create_Rentals\\";
						functions.ScreenCapture(ScreenShotPath , ptestcasename);
						System.out.println("The Screenshot is taken");
						driver.findElement(By.id("checkoutRepromptDialog:repromptForm:repromptCloseButton")).click();
						driver.close();
						break;	
							
						}
					}
					
				
					Thread.sleep(20000);
					if (driver.findElement(By.xpath("//button[@id='checkoutRepromptDialog:repromptForm:repromptSubmitButton']")).isDisplayed())
					{
 				  	driver.findElement(By.xpath("//button[@id='checkoutRepromptDialog:repromptForm:repromptSubmitButton']")).click();
 				  	System.out.println("Clicked on Continue Button");
					Thread.sleep(20000);
					}
					Thread.sleep(20000);
					if(driver.findElement(By.xpath("//input[@id='footerForm:completeCheckoutButton']")).isDisplayed())
					{
					driver.findElement(By.xpath("//input[@id='footerForm:completeCheckoutButton']")).click();
					System.out.println("Clicked on Complete Checkout Button");
					Thread.sleep(7000);
					}
					
					Thread.sleep(7000);
					try
					{
						
						 if (driver.findElement(By.xpath("//textarea[@id='checkoutRepromptDialog:repromptForm:repromptOut']")).isDisplayed())
								 
						 {
							String str1= driver.findElement(By.xpath("//textarea[@id='checkoutRepromptDialog:repromptForm:repromptOut']")).getText();
							System.out.println("The message displayed is "+str1);
							if (str1.contains("Please enter the Credit ID security code (CVV/CCV)"))
							{
								if(pCOCCDC.equals("CA"))
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
								 if (driver.findElement(By.xpath("//textarea[@id='checkoutRepromptDialog:repromptForm:repromptOut']")).isDisplayed())
								 {
									String str2=driver.findElement(By.xpath("//textarea[@id='checkoutRepromptDialog:repromptForm:repromptOut']")).getText();
									System.out.println("The message displayed is "+str2); 
									if(str2.contains("**MULTIPLE RENTALS**NEEDS MANAGEMENT AUTHORIZATION"))
											{
										driver.findElement(By.xpath("//input[@id='checkoutRepromptDialog:repromptForm:repromptTable:0:repromptValuePassword']")).click();
										 driver.findElement(By.xpath("//input[@id='checkoutRepromptDialog:repromptForm:repromptTable:0:repromptValuePassword']")).sendKeys("YES");
										 driver.findElement(By.xpath("//button[@id='checkoutRepromptDialog:repromptForm:repromptSubmitButton']")).click();
										 Thread.sleep(4000);
											}
								 }
								
								
							}
							else
								if (str1.contains("**MULTIPLE RENTALS**NEEDS MANAGEMENT AUTHORIZATION "))
							{
								driver.findElement(By.xpath("//input[@id='checkoutRepromptDialog:repromptForm:repromptTable:0:repromptValuePassword']")).click();
								 driver.findElement(By.xpath("//input[@id='checkoutRepromptDialog:repromptForm:repromptTable:0:repromptValuePassword']")).sendKeys("YES");
								 driver.findElement(By.xpath("//button[@id='checkoutRepromptDialog:repromptForm:repromptSubmitButton']")).click();
								 Thread.sleep(4000);
							}
					}
						 }
					catch (Exception e)
					{
						e.printStackTrace();
					}
				 
				 // Checkout complete Screen and update in Excel 
					   
					  //tring screenname = driver.findElement(By.xpath("//h5[@class='completeCheckout ng-binding']")).getText();
							   
						Thread.sleep(7000);			                    
					   //String strCOLNFNGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteName")).getText();
					   String strCOLNFNGetText = driver.findElement(By.xpath("//div[@class='form-group']//span[@id='checkoutDialog:checkoutCompleteForm:checkoutCompleteName']")).getText();
		               Thread.sleep(7000);
		               rwe.setCellData("Payless_GUI_Rentals", k, 63, strCOLNFNGetText);
		               System.out.println(" Last Name First Name value is " + strCOLNFNGetText);
		              // String strCOVehicleModelGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteVehicle")).getText();
		               String strCOVehicleModelGetText = driver.findElement(By.xpath("//div[@class='form-group']//span[@id='checkoutDialog:checkoutCompleteForm:checkoutCompleteVehicle']")).getText();
		               Thread.sleep(7000);
		               rwe.setCellData("Payless_GUI_Rentals", k, 64, strCOVehicleModelGetText);
		               System.out.println(" Vehicle Model value is " + strCOVehicleModelGetText);
		               //String strCOResNoGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteResNum")).getText();
		               String strCOResNoGetText = driver.findElement(By.xpath("//div[@class='form-group']//span[@id='checkoutDialog:checkoutCompleteForm:checkoutCompleteResNum']")).getText();
		               Thread.sleep(7000);
		               rwe.setCellData("Payless_GUI_Rentals", k, 65, strCOResNoGetText);
		               System.out.println(" Reservation No value is " + strCOResNoGetText);
		               //String strCOMVAGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteMVA")).getText();
		               String strCOMVAGetText = driver.findElement(By.xpath("//div[@class='form-group']//span[@id='checkoutDialog:checkoutCompleteForm:checkoutCompleteMVA']")).getText();
		               Thread.sleep(7000);
		               rwe.setCellData("Payless_GUI_Rentals", k, 66, strCOMVAGetText);
		               System.out.println(" MVA No value is " + strCOMVAGetText);
		               //String strCORANoGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteRANumber")).getText();
		               String strCORANoGetText = driver.findElement(By.xpath("//div[@class='form-group']//span[@id='checkoutDialog:checkoutCompleteForm:checkoutCompleteRANumber']")).getText();
		               Thread.sleep(7000);
		               rwe.setCellData("Payless_GUI_Rentals", k, 67, strCORANoGetText);
		               System.out.println(" RA Number value is " + strCORANoGetText);
		              // String strCOLicensePlateNoGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteLicensePlate")).getText();
		               String strCOLicensePlateNoGetText = driver.findElement(By.xpath("//div[@class='form-group']//span[@id='checkoutDialog:checkoutCompleteForm:checkoutCompleteLicensePlate']")).getText();
		               Thread.sleep(7000);
		               rwe.setCellData("Payless_GUI_Rentals", k, 68, strCOLicensePlateNoGetText);
		               System.out.println(" License Plate Number value is " + strCOLicensePlateNoGetText);
		               //String strCOEstimatedCostGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteEstimatedCost")).getText();
		               String strCOEstimatedCostGetText = driver.findElement(By.xpath("//div[@class='form-group']//span[@id='checkoutDialog:checkoutCompleteForm:checkoutCompleteEstimatedCost']")).getText();
		               Thread.sleep(7000);
		               rwe.setCellData("Payless_GUI_Rentals", k, 69, strCOEstimatedCostGetText);
		               System.out.println(" Estimated Cost value is " + strCOEstimatedCostGetText);
		               //String strCOSystemMsgGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteOut")).getText();
		               String strCOSystemMsgGetText = driver.findElement(By.xpath("//div[@class='form-group']//textarea[@id='checkoutDialog:checkoutCompleteForm:checkoutCompleteOut']")).getText();
		               Thread.sleep(7000);
		               rwe.setCellData("Payless_GUI_Rentals", k, 70, strCOSystemMsgGetText);
		               System.out.println(" CheckOut Complete System Message value is " + strCOSystemMsgGetText);
		               Thread.sleep(7000);
		               
					
					String ScreenShotPath = "C:\\Selenium\\Screenshots\\Payless\\Payless_Create_Rentals\\";
					functions.ScreenCapture(ScreenShotPath , ptestcasename);
					System.out.println("The Screenshot is taken");	
					Thread.sleep(5000);
					if (driver.findElement(By.xpath("//input[@id='checkoutDialog:checkoutCompleteForm:checkoutCompleteDoneButton']")).isDisplayed())
		               {
						driver.findElement(By.xpath("//input[@id='checkoutDialog:checkoutCompleteForm:checkoutCompleteDoneButton']")).click();
		               System.out.println("Clicked on Done Button");
		               Thread.sleep(7000);
		               }
					String ScreenShotPath2 = "C:\\Selenium\\Screenshots\\Payless\\Payless_Create_Rentals\\";
					functions.ScreenCapture(ScreenShotPath2 , ptestcasename);
					System.out.println("The Screenshot is taken");
					//driver.findElement(By.xpath("//input[@id='headerLogOutButton']")).click();
					//driver.findElement(By.xpath("//button[@id='logoutForm:yesLogoutButton']")).click();
					driver.close();
					Thread.sleep(2000);
					//functions.closeWindows();
					test = extent.createTest(ptestcasename);	
                    if(rwe.getCellData("Payless_GUI_Rentals", k, 64).isEmpty())
                    {
						rwe.setCellData("Payless_GUI_Rentals", k, 71,"FAIL");
				test.log(Status.FAIL, "Fail");
					} else {
						rwe.setCellData("Payless_GUI_Rentals", k, 71, "PASS");
				test.log(Status.PASS, "Pass");
					}
				
			}
		}
		 
		
		
}
	
		finally {
			// TODO: handle finally clause
			extent.flush();
			}	
	
		
	}
}


	
	