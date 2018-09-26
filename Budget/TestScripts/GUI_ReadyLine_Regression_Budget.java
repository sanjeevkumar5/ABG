/**
'#############################################################################################################################
'## SCRIPT NAME:                           GUI_ReadyLine_Regression_Budget
'## BRAND:                                 Budget
'## DESCRIPTION:                           Regress the Readyline screen.
'## FUNCTIONAL AREA :                      Readyline
'## PRECONDITION:                          All the required Test Data should be available in Test Data Sheet.
'## OUTPUT:                                Readyline reports should be retrieved successfully.
'#############################################################################################################################
 **/

package methods;
import java.io.*;
import java.util.ArrayList;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pomClasses.ReadWriteExcel;

public class GUI_ReadyLine_Regression_Budget
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
	  
	  //ReadWriteExcel rwe1 = new ReadWriteExcel("C:\\GUI_Automation\\TestData\\AVIS_GUITestData_ReadyLine_Regression.xlsx");
	  ReadWriteExcel rwe  = new ReadWriteExcel("C:\\GUI_Automation\\TestData\\Budget_GUITestData_ReadyLine_Regression.xlsx");
      
	  int intRowCount = rwe.intRowCount;
	  
	  System.out.println(" total row count in ReadyLine test data sheet is : " + intRowCount);
	  
	  for (int k=1;k<=intRowCount;k++)
	  //for (int k=1; k<=32; k++)
	  {

         String Execute = rwe.getCellData("INPUT_DATA",k,2);
         
		 if (Execute.equals("Y"))
         {
			
			String outSTA    = rwe.getCellData("INPUT_DATA", k, 10);
			
			System.out.println(" Line No. 70. Oustation value is : " + outSTA);
			System.out.println(" Line No. 71. Temp Location value is : " + Temp);
			
			if (!Temp.equalsIgnoreCase(outSTA))
	        {
				System.out.println(" Line No. 75. Inside if : Temp Outstation value is : " + Temp);
				System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Selenium\\WebDrivers\\ChromeDrivers\\chromedriver.exe");
			    driver = new ChromeDriver();
			    driver.manage().window().maximize();
			    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     		    System.out.println(" Current iteration : " + k);
			    String tokenURL = rwe.getCellData("INPUT_DATA", k, 6);
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
			    Thread.sleep(500);			
				String clientURL = rwe.getCellData("INPUT_DATA", k, 7);
				
			    try
			    {
			       String thinClient = clientURL+outSTA;
			       driver.get(thinClient);
			       Assert.assertTrue(driver.getTitle().equals("Login")); // check whether page with title Login is loaded
			    }
			    catch(Exception e)
			    {
			       System.out.println("Login page not found");
			    }
                
			    //Login to GUI using token and thinclient URL.
			    
			    String uName = rwe.getCellData("INPUT_DATA", k, 8);
			    String pswd  = rwe.getCellData("INPUT_DATA", k, 9);
			    driver.findElement(By.name("username")).sendKeys(uName);
			    driver.findElement(By.name("PASSWORD")).sendKeys(pswd);
			    driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr/td[2]/form/table/tbody/tr[3]/td/input[2]")).click();
                
	    	    //click ReadyLine tab.
			    
			    driver.findElement(By.xpath("//*[@id='menubar']/ul/li[3]/a")).click();
			    Thread.sleep(500);
	        } //Location compare condition !Temp.equalsIgnoreCase(outSTA) Ends.
			
			Temp = outSTA;
			
		    //Reading values from Excel.
			
     	    String strOption      = rwe.getCellData("INPUT_DATA", k, 11);
     	    
     	    //if (rwe.cell.getCellTypeEnum() == CellType.STRING)
     	    //{
     	    	//return 
     	    //}
     	    
     	    String strMVA1        = rwe.getCellData("INPUT_DATA", k, 12);
		    
		    if (strMVA1 != null)
		    {  
		       //Inlcude script for Add cars to readyline.
		       
		       System.out.println(" strMVA1 is not empty. ");
		       
		       String strMVA2        = rwe.getCellData("INPUT_DATA", k, 13);
		       String strMVA3        = rwe.getCellData("INPUT_DATA", k, 14);
		       String strMVA4        = rwe.getCellData("INPUT_DATA", k, 15);
		       String strMVA5        = rwe.getCellData("INPUT_DATA", k, 16);
		       String strMVA6        = rwe.getCellData("INPUT_DATA", k, 17);
		       String strMVA7        = rwe.getCellData("INPUT_DATA", k, 18);
		       String strMVA8        = rwe.getCellData("INPUT_DATA", k, 19);
		       String strMVA9        = rwe.getCellData("INPUT_DATA", k, 20);
		       String strMVA10       = rwe.getCellData("INPUT_DATA", k, 21);
		       String strMileage1    = rwe.getCellData("INPUT_DATA", k, 22);
		       String strMileage2    = rwe.getCellData("INPUT_DATA", k, 23);
		       String strMileage3    = rwe.getCellData("INPUT_DATA", k, 24);
		       String strMileage4    = rwe.getCellData("INPUT_DATA", k, 25);
		       String strMileage5    = rwe.getCellData("INPUT_DATA", k, 26);
		       String strMileage6    = rwe.getCellData("INPUT_DATA", k, 27);
		       String strMileage7    = rwe.getCellData("INPUT_DATA", k, 28);
		       String strMileage8    = rwe.getCellData("INPUT_DATA", k, 29);
		       String strMileage9    = rwe.getCellData("INPUT_DATA", k, 30);
		       String strMileage10   = rwe.getCellData("INPUT_DATA", k, 31);
		       String strSpace1      = rwe.getCellData("INPUT_DATA", k, 32);
		       String strSpace2      = rwe.getCellData("INPUT_DATA", k, 33);
		       String strSpace3      = rwe.getCellData("INPUT_DATA", k, 34);
		       String strSpace4      = rwe.getCellData("INPUT_DATA", k, 35);
		       String strSpace5      = rwe.getCellData("INPUT_DATA", k, 36);
		       String strSpace6      = rwe.getCellData("INPUT_DATA", k, 37);
		       String strSpace7      = rwe.getCellData("INPUT_DATA", k, 38);
		       String strSpace8      = rwe.getCellData("INPUT_DATA", k, 39);
		       String strSpace9      = rwe.getCellData("INPUT_DATA", k, 40);
		       String strSpace10     = rwe.getCellData("INPUT_DATA", k, 41);
		       String strFuel1       = rwe.getCellData("INPUT_DATA", k, 42);
		       String strFuel2       = rwe.getCellData("INPUT_DATA", k, 43);
		       String strFuel3       = rwe.getCellData("INPUT_DATA", k, 44);
		       String strFuel4       = rwe.getCellData("INPUT_DATA", k, 45);
		       String strFuel5       = rwe.getCellData("INPUT_DATA", k, 46);
		       String strFuel6       = rwe.getCellData("INPUT_DATA", k, 47);
		       String strFuel7       = rwe.getCellData("INPUT_DATA", k, 48);
		       String strFuel8       = rwe.getCellData("INPUT_DATA", k, 49);
		       String strFuel9       = rwe.getCellData("INPUT_DATA", k, 50);
		       String strFuel10      = rwe.getCellData("INPUT_DATA", k, 51);
		       String strReadyLine1  = rwe.getCellData("INPUT_DATA", k, 52);
		       String strReadyLine2  = rwe.getCellData("INPUT_DATA", k, 53);
		       String strReadyLine3  = rwe.getCellData("INPUT_DATA", k, 54);
		       String strReadyLine4  = rwe.getCellData("INPUT_DATA", k, 55);
		       String strReadyLine5  = rwe.getCellData("INPUT_DATA", k, 56);
		       String strReadyLine6  = rwe.getCellData("INPUT_DATA", k, 57);
		       String strReadyLine7  = rwe.getCellData("INPUT_DATA", k, 58);
		       String strReadyLine8  = rwe.getCellData("INPUT_DATA", k, 59);
		       String strReadyLine9  = rwe.getCellData("INPUT_DATA", k, 60);
		       String strReadyLine10 = rwe.getCellData("INPUT_DATA", k, 61);
		         
		    }
		    else
		    {
		    	System.out.println(" strMVA1 is empty. ");
		    }
		    
		    String strVTMVA = rwe.getCellData("INPUT_DATA", k, 62);
		    
		    if (strVTMVA != null)
		    {
			    //Inlcude script for Vehicle Trace.
		    	 
			    System.out.println(" strVTMVA is not empty. ");
		    	
		        String strVTFromDate = rwe.getCellData("INPUT_DATA", k, 63);
		    }
		    else
		    {
		    	System.out.println(" strVTMVA is empty. ");
		    }
            
			Thread.sleep(500);
			
            //Select ReadyLine Type.
            
			System.out.println(" Ready Line Type value is : " + strOption);
			driver.findElement(By.xpath("//*[@id=\'menulist:readyLineSubMenu\']/div/div/div/div[1]/div/button")).click();
			//driver.findElement(By.partialLinkText(strOption)).click();
			driver.findElement(By.linkText(strOption)).click();
			Thread.sleep(7000);
			
		    WebElement RLitemCount = driver.findElement(By.className("ui-grid-pager-count-container"));
		    
		    Thread.sleep(5000);
		    
		    if(RLitemCount.findElement(By.xpath("//*[@id=\'ll_showReadylineGrid\']/div/div[2]/div[2]/div/span")).isDisplayed())
		    {
                String strRLCountVal = RLitemCount.findElement(By.xpath("//*[@id=\'ll_showReadylineGrid\']/div/div[2]/div[2]/div/span")).getText();
                System.out.println("Ready Line Count is : " +strRLCountVal);
                String[] splitVal = strRLCountVal.split("of");
                System.out.println(splitVal[1]+ " found. ");
                rwe.setCellData("INPUT_DATA", k, 74, splitVal[1]+ " found. ");
		    }
            else
            {
                System.out.println(" 0 items found. ");
                rwe.setCellData("INPUT_DATA", k, 74, " 0 items found. ");
		    }
		    
/*		    if (Execute.equals("Y"))
		    {
		    	//k=k+1;
		        //System.out.println(" Line No. 244. Input Data Sheet Exec Condition is : " + Execute);
				//String outSTA1    = rwe.getCellData("INPUT_DATA", k+1, 10);
		        Temp = outSTA;
			    //System.out.println(" Line No. 263. Temp location. " + outSTA1);
		        
			    if (!Temp.equalsIgnoreCase(outSTA))
			    {
                
			       System.out.println(" Line No : 251. inside else : Logout for different location. ");
				   System.out.println(" Line No : 252. Outstation is different for iteration : " + k + " outSTA2 value is : " + Temp);
				   
		           //Log out and close tabs.
			       
	               GUI_ReadyLine_Regression_AVIS avis = new GUI_ReadyLine_Regression_AVIS();
	               
	               avis.clickLogout(driver);
	               Thread.sleep(1000);
	               driver.close();
	               driver.quit();
			    }
		    }*/
	     } //End of Execute Condition: Execute.equals("Y").
		 //else
		 //{
			//System.out.println("Execution status is N for iteration " + k + "...");
		 //}
		 
		 //k=k+1;
		 //System.out.println( " Line No. 252. next row is " + k);
	     
	     if (Execute.equals("Y"))
	     {
			System.out.println( " Line No. 256. next row is " + k);
			
	        System.out.println(" Line No. 258. Input Data Sheet Exec Condition is : " + Execute);

		    String outSTA = rwe.getCellData("INPUT_DATA", k+1, 10);
		    System.out.println(" Line No. 261. outSTA " + outSTA);
		    System.out.println(" Line No. 263. Temp location. " + Temp);
	        
			if (!Temp.equalsIgnoreCase(outSTA))
		    {

		       System.out.println(" Line No : 268. inside if : Logout for different location. ");
			   System.out.println(" Line No : 269. Outstation is different for iteration : " + k + " Temp value is : " + Temp);
			   
	           //Log out and close tabs.
		       
               GUI_ReadyLine_Regression_Budget Budget = new GUI_ReadyLine_Regression_Budget();
               
               Budget.clickLogout(driver);
               Thread.sleep(1000);
               driver.close();
               driver.quit();
		    }
	     }
      } //End of For loop.
	  
      //Log out and close tabs.
      
      GUI_ReadyLine_Regression_Budget Budget = new GUI_ReadyLine_Regression_Budget();
      
      Budget.clickLogout(driver);
      Thread.sleep(1000);
      driver.close();
      driver.quit();
	  
   } // End of public static void main.
   
} // End of GUI_ReadyLine_Regression_AVIS Class.