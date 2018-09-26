/**
 * 
 */
package methods;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pomClasses.GUIFunctions;
import pomClasses.ReadWriteExcel;

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

public class GUI_CreateRentals_Avis
{
	private static final String NULL = null;

	public void clickRateshopSearchBtn(ChromeDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String clickSearchJS = "document.getElementById('searchCommandLinkResRateCode').click()";
		jse.executeScript(clickSearchJS);
	}

	public static void main(String[] args) throws IOException, Exception, FileNotFoundException 
	{
		// Read input from excel
		for (int k = 1; k <= 65; k++)
		{
			//GUI_CreateReservation_AVIS avis = new GUI_CreateReservation_AVIS();
			ReadWriteExcel rwe = new ReadWriteExcel("C:\\Selenium\\Test_Data\\AVIS\\AVIS_GUITestData_Rental_CheckOut.xlsx");
			String Execute = rwe.getCellData("AVIS_GUI_Rentals", k, 2);
			if (Execute.equals("Y"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\Selenium\\ChromeDriver\\chromedriver.exe");
				WebDriver driver= new ChromeDriver();
				GUIFunctions functions = new GUIFunctions(driver);
				int a = 62;
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println(" iteration " + k);
				 String testcasename 	= rwe.getCellData("AVIS_GUI_Rentals", k, 4);
				 String clientURL   	= rwe.getCellData("AVIS_GUI_Rentals", k, 7);
				 String outSTA      	= rwe.getCellData("AVIS_GUI_Rentals", k, 10);
				 String thinClient  	= clientURL+outSTA;
				 String uName       	= rwe.getCellData("AVIS_GUI_Rentals", k, 8);
				 String pswd        	= rwe.getCellData("AVIS_GUI_Rentals", k, 9);
				 String ResNo      		= rwe.getCellData("AVIS_GUI_Rentals", k, 11);
				 String CustType		= rwe.getCellData("AVIS_GUI_Rentals", k, 12);
				 String WizardNo		= rwe.getCellData("AVIS_GUI_Rentals", k, 13);
				 String LastName		= rwe.getCellData("AVIS_GUI_Rentals", k, 14);
				 String FirstName		= rwe.getCellData("AVIS_GUI_Rentals", k, 15);
				 String COCountry 		= rwe.getCellData("AVIS_GUI_Rentals", k, 16);
				 String COState			= rwe.getCellData("AVIS_GUI_Rentals", k, 17);
				 String CODRLICNO 		= rwe.getCellData("AVIS_GUI_Rentals", k, 18);
				 String CODOB			= rwe.getCellData("AVIS_GUI_Rentals", k, 19);
				 String COCOMPANY		= rwe.getCellData("AVIS_GUI_Rentals", k, 20);
				 String COADDR1			= rwe.getCellData("AVIS_GUI_Rentals", k, 21);
				 String COADDR2			= rwe.getCellData("AVIS_GUI_Rentals", k, 22);
				 String COADDR3			= rwe.getCellData("AVIS_GUI_Rentals", k, 23);
				 String COCONTACTINFO   = rwe.getCellData("AVIS_GUI_Rentals", k, 24);
				 String COEMAIL			= rwe.getCellData("AVIS_GUI_Rentals", k, 25);
				 String COMOP			= rwe.getCellData("AVIS_GUI_Rentals", k, 26);
				 String COCCDC			= rwe.getCellData("AVIS_GUI_Rentals", k, 27);
				 String CARDNO			= rwe.getCellData("AVIS_GUI_Rentals", k, 28);
				 String COMM			= rwe.getCellData("AVIS_GUI_Rentals", k, 29);
				 String COYY			= rwe.getCellData("AVIS_GUI_Rentals", k, 30);
				 String MOPREASON		= rwe.getCellData("AVIS_GUI_Rentals", k, 31);
				 String RETURNSTATION	= rwe.getCellData("AVIS_GUI_Rentals", k, 32);
				 String RETURNDATE		= rwe.getCellData("AVIS_GUI_Rentals", k, 33);
				 String RETURNTIME		= rwe.getCellData("AVIS_GUI_Rentals", k, 34);
				 String CARGROUP		= rwe.getCellData("AVIS_GUI_Rentals", k, 35);
				 String AWD				= rwe.getCellData("AVIS_GUI_Rentals", k, 36);
				 String COUPON			= rwe.getCellData("AVIS_GUI_Rentals", k, 37);
				 String FTNTYPE			= rwe.getCellData("AVIS_GUI_Rentals", k, 38);
				 String FTNUMBER		= rwe.getCellData("AVIS_GUI_Rentals", k, 39);
				 String REMARKS			= rwe.getCellData("AVIS_GUI_Rentals", k, 40);
				 String COMVA			= rwe.getCellData("AVIS_GUI_Rentals", k, 41);
				 String COMILEAGE		= rwe.getCellData("AVIS_GUI_Rentals", k, 42);
				 String INSURANCE		= rwe.getCellData("AVIS_GUI_Rentals", k, 43);
				 String COUNTERPRODUCT	= rwe.getCellData("AVIS_GUI_Rentals", k, 44);
				 String ADRLASTNAME		= rwe.getCellData("AVIS_GUI_Rentals", k, 45);
				 String ADRFIRSTNAME	= rwe.getCellData("AVIS_GUI_Rentals", k, 46);
				 String ADRDOB			= rwe.getCellData("AVIS_GUI_Rentals", k, 47);
				 String ADRCOUNTRY		= rwe.getCellData("AVIS_GUI_Rentals", k, 48);
				 String ADRSTATE		= rwe.getCellData("AVIS_GUI_Rentals", k, 49);
				 String ADRDRLICNO		= rwe.getCellData("AVIS_GUI_Rentals", k, 50);
				 String ADREXPMM		= rwe.getCellData("AVIS_GUI_Rentals", k, 51);
				 String ADREXPYY		= rwe.getCellData("AVIS_GUI_Rentals", k, 52);
				 String ADRADDR1		= rwe.getCellData("AVIS_GUI_Rentals", k, 53);
				 String ADRADDR2		= rwe.getCellData("AVIS_GUI_Rentals", k, 54);
				 String ADRADDR3		= rwe.getCellData("AVIS_GUI_Rentals", k, 55);
				 String ADRTELEPHONE1	= rwe.getCellData("AVIS_GUI_Rentals", k, 56);
				 String ADRTELEPHONE2   = rwe.getCellData("AVIS_GUI_Rentals", k, 57);
				 String ADRCCDC			= rwe.getCellData("AVIS_GUI_Rentals", k, 58);
				 String ADRCARDNO		= rwe.getCellData("AVIS_GUI_Rentals", k, 59);
				 String ADRCCEXPMM		= rwe.getCellData("AVIS_GUI_Rentals", k, 60);
				 String ADRCCEXPYY		= rwe.getCellData("AVIS_GUI_Rentals", k, 61);

				 
				 
				 
				 driver.get(thinClient);
				 functions.login(uName, pswd);
				 driver.getTitle();
				 if(driver.getTitle()!= "Avis Budget Group")
				 {
				 driver.navigate().refresh();
				 }
				 driver.findElement(By.xpath("//a[@data-target='#menulist\\:checkoutlink']")).click();
				 System.out.println("Clicked on Checkout Button");
				 driver.findElement(By.xpath("//input[@id='searchString']")).click();
				 driver.findElement(By.xpath("//input[@id='searchString']")).sendKeys(ResNo);
				 System.out.println("Entered the existing Reservation");
				 driver.findElement(By.xpath("//input[@id='searchCommandLink']")).click();
				 System.out.println("Clicked on the Search Button");
				 Thread.sleep(10000);
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseCountry']")).click();
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseCountry']")).sendKeys(COCountry);
				 System.out.println("Entered the Country");
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseState']")).click();
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseState']")).sendKeys(COState);
				 System.out.println("Entered the State");
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseNumber']")).click();
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:licenseNumber']")).sendKeys(CODRLICNO);
				 System.out.println("Entered the Licence Number");
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:dateOfBirth']")).click();
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:dateOfBirth']")).sendKeys(CODOB);
				 System.out.println("Entered the Date of Birth");
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:company']")).click();
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:company']")).sendKeys(COCOMPANY);
				 System.out.println("Entered the Company");
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address1']")).click();
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address1']")).sendKeys(COADDR1);
				 System.out.println("Entered the Address 1");
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address2']")).sendKeys(COADDR2);
				 System.out.println("Entered the Address 2");
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:address3']")).sendKeys(COADDR3);
				 System.out.println("Entered the Address 3");
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:contactInfo']")).sendKeys(COCONTACTINFO);
				 System.out.println("Entered the Contact Info");
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:wizconEmailInput']")).sendKeys(COEMAIL);
				 System.out.println("Entered the Email");
				 if(FTNTYPE != NULL)
				 {
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:ftnType']")).sendKeys(FTNTYPE);
				 System.out.println("Entered the FTN Type");
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:ftNumber']")).sendKeys(FTNUMBER);
				 System.out.println("Entered the FTN Number");
				 }
				// driver.findElement(By.xpath("//input[@id='glyphicon glyphicon-plus']")).click();
				 
				 Select s= new Select(driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:payMethod")));
				 s.selectByValue(COMOP);
				 System.out.println("Entered the Method of Payment");
				 Select s2= new Select(driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccType")));
				 s2.selectByValue(COCCDC);
				 System.out.println("Entered the Type of Payment");
				 driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccNumber']")).sendKeys(CARDNO);
				 System.out.println("Entered the Card Number");
					driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccExpireMonth']")).sendKeys(COMM);
					System.out.println("Entered the Expiry Month");
					driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:creditCard:swipe:ccExpireYear']")).sendKeys(COYY);
					System.out.println("Entered the Expiry Year");
					Select s3= new Select(driver.findElement(By.id("menulist:checkoutContainer:checkoutForm:creditCard:swipe:paymentReason")));
					s3.selectByValue(MOPREASON);
					System.out.println("Entered the Reason for payment");
					//driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:creditCard:mopCCI']")).sendKeys("1234");
					driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:creditCard:authorization']")).sendKeys("OK/1234");
					//driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:rateCode']")).clear();
					//driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:rateCode']")).sendKeys("GB/C");
					driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:mvaOrParkingSpace']")).sendKeys(COMVA);
					System.out.println("Entered the MVA number");
					driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:mileage']")).clear();
					driver.findElement(By.xpath("//input[@id='menulist:checkoutContainer:checkoutForm:mileage']")).sendKeys(COMILEAGE);
					System.out.println("Entered the Mileage");
					driver.findElement(By.xpath("//input[@id='footerForm:continueVehicleButton']")).click();
					Thread.sleep(5000);
					System.out.println(driver.findElement(By.xpath("//textarea[@id='checkoutRepromptDialog:repromptForm:repromptOut']")).getText());
					driver.findElement(By.xpath("//button[@id='checkoutRepromptDialog:repromptForm:repromptSubmitButton']")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//input[@id='footerForm:completeCheckoutButton']")).click();
					System.out.println(driver.findElement(By.xpath("//textarea[@id='checkoutRepromptDialog:repromptForm:repromptOut']")).getText());
					if(COCCDC.equals("American Express"))
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
                    
					   String strCOLNFNGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteName")).getText();
		               Thread.sleep(7000);
		               rwe.setCellData("AVIS_GUI_Rentals", k, 63, strCOLNFNGetText);
		               System.out.println(" Last Name First Name value is " + strCOLNFNGetText);
		               String strCOVehicleModelGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteVehicle")).getText();
		               Thread.sleep(7000);
		               rwe.setCellData("AVIS_GUI_Rentals", k, 64, strCOVehicleModelGetText);
		               System.out.println(" Vehicle Model value is " + strCOVehicleModelGetText);
		               String strCOResNoGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteResNum")).getText();
		               Thread.sleep(7000);
		               rwe.setCellData("AVIS_GUI_Rentals", k, 65, strCOResNoGetText);
		               System.out.println(" Reservation No value is " + strCOResNoGetText);
		               String strCOMVAGetText = driver.findElement(By.id("checkoutDialog:checkoutCompleteForm:checkoutCompleteMVA")).getText();
		               Thread.sleep(7000);
		               rwe.setCellData("AVIS_GUI_Rentals", k, 66, strCOResNoGetText);
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

					
					
					String ScreenShotPath = "C:\\Selenium\\Screenshots\\Avis\\Avis_CreateRentals\\";
					functions.ScreenCapture(ScreenShotPath , testcasename);
					System.out.println("The Screenshot is taken");
					
					
					
				
                       
                       functions.logout();
   					   Thread.sleep(2000);
   					   functions.closeWindows();
				
			}
		}
		
		
		
}
}

	
	