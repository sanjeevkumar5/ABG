/**
 * 
 */
package Payless.TestScripts;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.gui.report.Extentmanager;
import AVIS.CommonFunctions.GUIFunctions;
import AVIS.CommonFunctions.ReadWriteExcel;

/**
 * '#############################################################################################################################
 * '## SCRIPT NAME      : Payless_GUI_Create_Reservation 
 * '## BRAND            : Payless
 * '## DESCRIPTION      : Create Reservation for different LOR. 
 * '## FUNCTIONAL AREA  : Reservation Rates Screen 
 * '## PRECONDITION     : All the required Test Data should be available in Test Data Sheet. 
 * '## OUTPUT           : Reservation should be created successfully.
 * HISTORY 
 * 05-SEP-2018 - GUIFunctions class created for GUI Common functionalities and CR functionality / RS error handled
 * 13-NOV-2018 - Modified script for Coupons scenario and added Driver details field
 * 23NOV - Incorporated all new changes
 * 
 * '#############################################################################################################################
 **/

public class Payless_GUI_Create_Reservation
{
	public void clickRateshopSearchBtn(ChromeDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver; 
		String clickSearchJS = "document.getElementById('searchCommandLinkResRateCode').click()";
		jse.executeScript(clickSearchJS);
	}

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
		try
		{
			ReadWriteExcel rwe = new ReadWriteExcel("C:\\Users\\vkhoday\\git\\ABG\\src\\Payless\\TestData\\Payless_GUITestData_CreateReservation.xlsx");
			int intRowCount    = rwe.intRowCount;
			
			System.out.println("total row count in test data sheet " + intRowCount);
			
			// Read input from excel
			for (int k = 1; k <=intRowCount; k++)
			{
				Payless_GUI_Create_Reservation payless = new Payless_GUI_Create_Reservation();
				String Execute = rwe.getCellData("Payless_CR", k, 2);

				if (Execute.equals("Y"))
				{
					System.setProperty("webdriver.chrome.driver","C:\\Python36\\chromedriver_235.exe");
					ChromeDriver driver = new ChromeDriver();
					GUIFunctions functions = new GUIFunctions(driver);
					int a = 37;
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					System.out.println(" iteration " + k);
					String TCName = rwe.getCellData("Payless_CR", k, 4);
					String clientURL = rwe.getCellData("Payless_CR", k, 6);
					String outSTA = rwe.getCellData("Payless_CR", k, 7);
					String thinClient = clientURL + outSTA;
					String uName = rwe.getCellData("Payless_CR", k, 8);
					String pswd = rwe.getCellData("Payless_CR", k, 9);
					String lstname = rwe.getCellData("Payless_CR", k, 10);
					String fstname = rwe.getCellData("Payless_CR", k, 11);
					String drCountry = rwe.getCellData("Payless_CR", k, 12);
					String drState = rwe.getCellData("Payless_CR", k, 13);
					String drLicNo = rwe.getCellData("Payless_CR", k, 14);
					String drDOB = rwe.getCellData("Payless_CR", k, 15);
					String drCompany = rwe.getCellData("Payless_CR", k, 16);
					String addr1 = rwe.getCellData("Payless_CR", k, 17);
					String addr2 = rwe.getCellData("Payless_CR", k, 18);
					String addr3 = rwe.getCellData("Payless_CR", k, 19);
					String contact = rwe.getCellData("Payless_CR", k, 20);
					String FTN = rwe.getCellData("Payless_CR", k, 21);
					String codte = rwe.getCellData("Payless_CR", k, 22);
					String cotme = rwe.getCellData("Payless_CR", k, 23);
					String insta = rwe.getCellData("Payless_CR", k, 24);
					String cidte = rwe.getCellData("Payless_CR", k, 25);
					String citme = rwe.getCellData("Payless_CR", k, 26);
					String carGrp = rwe.getCellData("Payless_CR", k, 27);
					String awd = rwe.getCellData("Payless_CR", k, 28);
					String coupon = rwe.getCellData("Payless_CR", k, 29);
					String cardname = rwe.getCellData("Payless_CR", k, 30);
					String cardNo = rwe.getCellData("Payless_CR", k, 31);
					String expireMonth = rwe.getCellData("Payless_CR", k, 32);
					String expireYear = rwe.getCellData("Payless_CR", k, 33);
					String reason = rwe.getCellData("Payless_CR", k, 34);
					//screenshot function
		            String absPath = functions.get_Abs_Path();
	                absPath = absPath + "\\src\\AVIS\\ScreenShot";
	                functions.create_folder_path(absPath);;
					
					/* Open GUI URL's */
					functions.openURL(thinClient);
					/* Login */
					functions.login(uName, pswd);
					functions.navigateToTab("ReservationRates");
					Thread.sleep(500);
					functions.enterCustomerName(lstname, fstname);
					functions.expandToggleBtn();
					functions.enterDriverDetail(drCountry, drState, drLicNo, drDOB, drCompany, addr1, addr2, addr3, contact);
					/* Enter Customer Informations */
					/* Enter FTN */
					if(!FTN.isEmpty())
					{
						Thread.sleep(2000);
						functions.enterFTN(FTN);
					}
					functions.enterCustomerInformation(codte, cotme, insta, cidte, citme);
					/* Enter AWD */
					if (!awd.isEmpty())
					{
						functions.enterAWD(awd);
					}
                    if(!coupon.isEmpty())
                    {
                    	functions.enterCoupon(coupon);
                    }
					/* Select car group */
					//functions.selectCarGroupByVT(carGrp);
					functions.selectCarGroupByValue(carGrp);
					Thread.sleep(2000);

					/* RATE SHOP */
					ArrayList<WebElement> radio;
					payless.clickRateshopSearchBtn(driver);
					try
					{
					      radio = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[@name='radioRate'and @type='radio']"));
					}
					catch (Exception e) 
					{
                         functions.ScreenCapture(absPath, TCName);
                         functions.closeWindows();
                         continue;
                    }
                    if (radio.isEmpty()) 
                    {
                        functions.ScreenCapture(absPath, TCName);
                        functions.closeWindows();
                        continue;
                    }


					for (int i = 0; i < radio.size(); i++)
					{
						if ((radio.get(i).isDisplayed()) && (radio.get(i).isEnabled()))
						{
							radio.get(i).click();
							if (radio.get(i).isSelected())
							{
								functions.clickSelectRateBtn();
								/* Enter MOP details */
								functions.expandPaymentInfoSection();
								functions.enterPaymentInformations(cardname, cardNo, expireMonth, expireYear, reason);
								Thread.sleep(2000);
								functions.clickAgeField();

								/* Add Insurances */
								Thread.sleep(5000);
								functions.expandProtectionCoverageSection();
								if (!rwe.getCellData("Payless_CR", k, 35).isEmpty())
								{
									String[] insVal = rwe.getCellData("Payless_CR", k, 35).split("-");
									for (String e : insVal)
									{
										WebDriverWait wait1 = new WebDriverWait(driver, 10);
										if (e.equalsIgnoreCase("LDW"))
										{
											WebElement insurance1 = driver.findElement(By.id("menulist:rateshopContainer:resForm:coverageLdwYesNo"));
											Select insLDW = new Select(insurance1);
											wait1.until(ExpectedConditions.visibilityOf(insurance1));
											if (insurance1.isDisplayed())
											{
												insLDW.selectByVisibleText("Yes");
											}
											else
											{
												break;
											}
										}
										else if (e.equalsIgnoreCase("PAI"))
										{
											WebElement insurance2 = driver.findElement(By.id("menulist:rateshopContainer:resForm:coveragePaiYesNo"));
											Select insPAI = new Select(insurance2);
											wait1.until(ExpectedConditions.visibilityOf(insurance2));
											if (insurance2.isDisplayed())
											{
												insPAI.selectByVisibleText("Yes");
											}
											else
											{
												break;
											}
										}
										else if (e.equalsIgnoreCase("ESP"))
										{
											WebElement insurance3 = driver.findElement(By.id("menulist:rateshopContainer:resForm:coveragePepYesNo"));
											Select insPEP = new Select(insurance3);
											wait1.until(ExpectedConditions.visibilityOf(insurance3));
											if (insurance3.isDisplayed())
											{
												insPEP.selectByVisibleText("Yes");
											}
											else
											{
												break;
											}
										}
										else if (e.equalsIgnoreCase("ALI"))
										{
											WebElement insurance4 = driver.findElement(By.id("menulist:rateshopContainer:resForm:coverageAliYesNo"));
											Select insALI = new Select(insurance4);
											wait1.until(ExpectedConditions.visibilityOf(insurance4));
											if (insurance4.isDisplayed())
											{
												insALI.selectByVisibleText("Yes");
											}
											else
											{
												break;
											}
										}
										else if (e.equalsIgnoreCase("FSO"))
										{
											WebElement insurance5 = driver.findElement(By.id("menulist:rateshopContainer:resForm:fuelServiceOption"));
											Select insFSO = new Select(insurance5);
											wait1.until(ExpectedConditions.visibilityOf(insurance5));
											if (insurance5.isDisplayed())
											{
												insFSO.selectByVisibleText("Yes");
											}
											else
											{
												break;
											}
										}
										else
										{
											break;
										}
									}
								}

								/*
								 * Add CounterProducts
								 */
								if (rwe.getCellData("Payless_CR", k, 36).isEmpty())
								{
									String[] cpVal = rwe.getCellData("Payless_CR", k, 36).split("-");
									
									for (String e : cpVal)
									{
										WebDriverWait wait = new WebDriverWait(driver, 10);
										
										try 
										{
                                          if (e.equalsIgnoreCase("ADR")) 
                                          {
                                             WebElement cp1 = driver.findElement(By.id("productQuantity40"));
                                             Select cpADR = new Select(cp1);
                                             wait.until(ExpectedConditions.visibilityOf(cp1));
                                             if (cp1.isDisplayed())
                                             {
                                                cpADR.selectByVisibleText("1");
                                             } 
                                             else 
                                             {
                                                break;
                                             }
                                           } 
                                          else if (e.equalsIgnoreCase("CBS")) 
                                          {
                                             WebElement cp2 = driver.findElement(By.id("productQuantity32"));
                                             Select cpCBS = new Select(cp2);
                                             wait.until(ExpectedConditions.visibilityOf(cp2));
                                             if (cp2.isDisplayed())
                                             {
                                                  cpCBS.selectByVisibleText("1");
                                             } 
                                             else 
                                             {
                                                  break;
                                              }
                                            } 
                                          else if (e.equalsIgnoreCase("CSS"))
                                          {
                                             String t_counterpro = "Child Safety Seat";
                                             String tbl_cpn = functions.cpn_Pro_element_no(t_counterpro);
                                             String productqty = "productQuantityYesNo" + tbl_cpn;
//                                           WebElement cp3 = driver.findElement(By.id("productQuantity34"));
                                             WebElement cp3 = driver.findElement(By.id(productqty));
                                             Select cpCSS = new Select(cp3);
                                             wait.until(ExpectedConditions.visibilityOf(cp3));
                                             if (cp3.isDisplayed()) 
                                             {
                                                cpCSS.selectByVisibleText("1");
                                             } 
                                             else 
                                             {
                                                break;
                                             }
                                           } 
                                  		else if (e.equalsIgnoreCase("RSP"))
										{
											WebElement cp2   = driver.findElement(By.id("productQuantityYesNo1"));
											Select     cpCBS = new Select(cp2);
											wait.until(ExpectedConditions.visibilityOf(cp2));
											if (cp2.isDisplayed())
											{
												cpCBS.selectByVisibleText("Y");
											}
											else
											{
												break;
											}
										}
                                           else if (e.equalsIgnoreCase("GPS"))
                                           {
                                              String t_counterpro = "Gps Unit";
                                              String tbl_cpn = functions.cpn_Pro_element_no(t_counterpro);
                                              String productqty = "productQuantityYesNo" + tbl_cpn;
//                                            WebElement cp4 = driver.findElement(By.id("productQuantityYesNo6"));
                                              WebElement cp4 = driver.findElement(By.id(productqty));
                                              Select cpGPS = new Select(cp4);
                                              wait.until(ExpectedConditions.visibilityOf(cp4));
                                              if (cp4.isDisplayed()) 
                                              {
                                                  cpGPS.selectByVisibleText("Y");
                                              } 
                                              else
                                              {
                                                  break;
                                              }
                                            } 
                                            else if (e.equalsIgnoreCase("RSN"))
                                            {
                                               String t_counterpro = "Roadside Safety Net";
                                               String tbl_cpn = functions.cpn_Pro_element_no(t_counterpro);
                                               String productqty = "productQuantityYesNo" + tbl_cpn;
//                                             WebElement cp5 = driver.findElement(By.id("productQuantityYesNo11"));
                                               WebElement cp5 = driver.findElement(By.id(productqty));
                                               Select cpRSN = new Select(cp5);
                                               wait.until(ExpectedConditions.visibilityOf(cp5));
                                               if (cp5.isDisplayed())
                                               {
                                                  cpRSN.selectByVisibleText("Y");
                                               } 
                                               else 
                                               {
                                                  break;
                                               }
                                             } 
                                            else if (e.equalsIgnoreCase("TAB"))
                                            {
                                                WebElement cp6 = driver.findElement(By.id("productQuantityYesNo6"));
                                                Select cpTAB = new Select(cp6);
                                                wait.until(ExpectedConditions.visibilityOf(cp6));
                                                if (cp6.isDisplayed()) 
                                                {
                                                    cpTAB.selectByVisibleText("Y");
                                                } 
                                                else 
                                                {
                                                    break;
                                                }
                                              } 
                                              else if (e.equalsIgnoreCase("ESP")) 
                                              {
                                                 String t_counterpro = "Emergency Sickness Protection";
                                                 String tbl_cpn = functions.cpn_Pro_element_no(t_counterpro);
                                                 String productqty = "productQuantityYesNo" + tbl_cpn;
//                                               WebElement cp7 = driver.findElement(By.id("productQuantityYesNo6"));
                                                 WebElement cp7 = driver.findElement(By.id(productqty));
                                                 Select cpESP = new Select(cp7);
                                                 wait.until(ExpectedConditions.visibilityOf(cp7));
                                                 if (cp7.isDisplayed())
                                                 {
                                                    cpESP.selectByVisibleText("Y");
                                                 }
                                                 else 
                                                 {
                                                    break;
                                                 }
                                               } 
                                              else if (e.equalsIgnoreCase("SNB"))
                                              {
                                                 WebElement cp8 = driver.findElement(By.id("productQuantityYesNo11"));
                                                 Select cpSNB = new Select(cp8);
                                                 if (cp8.isDisplayed())
                                                 {
                                                    wait.until(ExpectedConditions.visibilityOf(cp8));
                                                    cpSNB.selectByVisibleText("Y");
                                                 } 
                                                 else 
                                                 {
                                                    break;
                                                 }
                                               } 
                                              else if (e.equalsIgnoreCase("XMR"))
                                              {
                                                 String t_counterpro = "Sirius XM Radio";
                                                 String tbl_cpn = functions.cpn_Pro_element_no(t_counterpro);
                                                 String productqty = "productQuantityYesNo" + tbl_cpn;
//                                               WebElement cp7 = driver.findElement(By.id("productQuantityYesNo6"));
                                                 WebElement cp9 = driver.findElement(By.id(productqty));
                                                 Select cpESP = new Select(cp9);
                                                 wait.until(ExpectedConditions.visibilityOf(cp9));
                                                 if (cp9.isDisplayed()) 
                                                 {
                                                    cpESP.selectByVisibleText("Y");
                                                 } 
                                                 else
                                                 {
                                                    break;
                                                 }
                                              }
                                           } 
										catch (Exception e1) 
										{
                                           e1.printStackTrace();
//                                         functions.logout();
                                           functions.closeWindows();
                                           continue;
                                        }
                                      } 
									}


								/*
								 * Create reservation
								 */
								functions.clickCreateReservationBtn();
								Thread.sleep(1000);
								String Resmsg = driver.findElement(By.xpath("//*[@id='templateInfoForm:templateInfoMsg']")).getText();
								rwe.setCellData("Payless_CR", k, 50, Resmsg); 
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@id='templateInfoForm:templateInfoButton']")).click(); // clicks OK button in Res popup
								Thread.sleep(5000);
								functions.ScreenCapture(absPath,TCName);
								
                                try 
                                {
                                  driver.findElement(By.xpath("//*[@id=\'reservationSearch:searchResPopUpForm:cancelResSearchCmdBtn\']")).click();
                                  functions.closeWindows();
                                  continue;
                                } 
                                catch (Exception e2) 
                                {
                                  System.out.println("No pop up message displayed");
                                }


								/*
								 * to print QV data in Excel
								 */
								WebElement res = driver.findElement(By.cssSelector("#quickViewPanel > div.panel-body > table > tbody > tr:nth-child(8) > td > div:nth-child(2) > div > table > tbody > tr > td:nth-child(2) > a > span"));

								try 
								{
                                     if (res.getText().isEmpty()) 
                                     {
                                        WebDriverWait wait1 = new WebDriverWait(driver, 20);
                                        wait1.until(ExpectedConditions.visibilityOf(res));
                                     }
                                } 
								catch (Exception e2) 
								{
                                    e2.printStackTrace();
                                    functions.logout();
                                    functions.closeWindows();
                                    continue;
                                }

								WebElement table = driver.findElement(By.id("resQvForm"));
								ArrayList<WebElement> rows = (ArrayList<WebElement>) table.findElements(By.tagName("tr"));
								for (int i1 = 1; i1 < rows.size(); i1++)
								{
									ArrayList<WebElement> cells = (ArrayList<WebElement>) rows.get(i1).findElements(By.tagName("td"));
									for (int j = 0; j < cells.size(); j++)
									{
										String val = cells.get(j).getText();
										if (val.isEmpty())
										{
											break;
										}
										else
										{
											if (j == 2)
											{
												val = val.replaceAll("[*]", ""); // Remover * before rates
												rwe.setCellData("Payless_CR", k, a, val);
												a++;
											}
										}
									}
								}
								
								/*
								 * Log out and close tabs
								 */

								functions.logout();
								Thread.sleep(1000);
								functions.closeWindows();

								test = extent.createTest(TCName);

								if (rwe.getCellData("Payless_CR", k, 37).isEmpty())
								{
									rwe.setCellData("Payless_CR", k, 51, "FAIL");
									test.log(Status.FAIL, "Fail");
								}
								else
								{ 
									rwe.setCellData("Payless_CR", k, 2, "N");
									rwe.setCellData("Payless_CR", k, 51, "PASS");
									test.log(Status.PASS, "Pass");
								}
								//break;
							 } // end of inner if
						}  // end of if
						else // Select available base rate from Standard rate table
						{
							System.out.print(" No Base Rates are Available ");
							String RateShopErrorMsg = driver.findElement(By.xpath("//*[@id='resRateLookupDlg:rateLookupForm:counterRates_data']")).getText();
							String[] RateShopErrorMsg1 = RateShopErrorMsg.split("Base Rate");
							String RSerrmsg = RateShopErrorMsg1[1];
							System.out.println("Rate shop error msg:" + RSerrmsg);
							rwe.setCellData("Payless_CR", k, 50, RSerrmsg);
							driver.findElement(By.xpath("//input[@id='cancelButton']")).click();
							Thread.sleep(2000);
							functions.logout();
							functions.closeWindows();
						} // end of else
					} // end of for
				} // end of Iteration if
				else
				{
					System.out.println("Execution status is N for iteration " + k + "...");
				}
			}
		}
		finally
		{
			// TODO: handle finally clause
			extent.flush();
		}
	}
}