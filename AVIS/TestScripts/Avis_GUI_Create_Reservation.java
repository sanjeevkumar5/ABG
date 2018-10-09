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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.avis.gui.report.Extentmanager;

import pomClasses.GUIFunctions;
import pomClasses.ReadWriteExcel;

/**
 * '#############################################################################################################################
 * '## SCRIPT NAME: GUI_CreateReservation_AVIS '## BRAND: AVIS '## DESCRIPTION:
 * Create Reservation for daily LOR with different insurance and counter
 * products. '## FUNCTIONAL AREA : Reservation Rates Screen '## PRECONDITION:
 * All the required Test Data should be available in Test Data Sheet. '##
 * OUTPUT: Reservation should be created successfully.
 * 
 * 
 * HISTORY 05-SEP-2018 - GUIFunctions class created for GUI Common
 * functionalities and CR functionality
 * 
 * RS error handled
 * '#############################################################################################################################
 **/

public class Avis_GUI_Create_Reservation {
	public void clickRateshopSearchBtn(ChromeDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String clickSearchJS = "document.getElementById('searchCommandLinkResRateCode').click()";
		jse.executeScript(clickSearchJS);
	}

	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void startReport() {
		extent = Extentmanager.GetExtent();
	}

	@Test
	public void test() throws Exception {

		try {

			// Read input from excel
			for (int k = 1; k <= 20; k++) {
				Avis_GUI_Create_Reservation avis = new Avis_GUI_Create_Reservation();
				ReadWriteExcel rwe = new ReadWriteExcel(
						"C:\\GUI_Automation\\Selenium\\GUI_TestDataSheets\\AVIS_GUITestData_CreateReservation.xlsx");
				String Execute = rwe.getCellData("Avis_GUI", k, 2);

				if (Execute.equals("Y")) {
					System.setProperty("webdriver.chrome.driver",
							"C:\\Users\\csurek\\Videos\\chromedriver_win32 (1)\\chromedriver.exe");
					ChromeDriver driver = new ChromeDriver();
					GUIFunctions functions = new GUIFunctions(driver);
					int a = 27;
					// ChromeDriver driver = new ChromeDriver();
					// GUIWebDriverFunctions wdfunctions = new
					// GUIWebDriverFunctions(driver);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					System.out.println(" iteration " + k);
					String TCName = rwe.getCellData("Avis_GUI", k, 4);
					String clientURL = rwe.getCellData("Avis_GUI", k, 6);
					String outSTA = rwe.getCellData("Avis_GUI", k, 7);
					String thinClient = clientURL + outSTA;
					String uName = rwe.getCellData("Avis_GUI", k, 8);
					String pswd = rwe.getCellData("Avis_GUI", k, 9);
					String lstname = rwe.getCellData("Avis_GUI", k, 10);
					String fstname = rwe.getCellData("Avis_GUI", k, 11);
					String codte = rwe.getCellData("Avis_GUI", k, 12);
					String cotme = rwe.getCellData("Avis_GUI", k, 13);
					String insta = rwe.getCellData("Avis_GUI", k, 14);
					String cidte = rwe.getCellData("Avis_GUI", k, 15);
					String citme = rwe.getCellData("Avis_GUI", k, 16);
					String carGrp = rwe.getCellData("Avis_GUI", k, 17);
					String awd = rwe.getCellData("Avis_GUI", k, 18);
					String FTN = rwe.getCellData("Avis_GUI", k, 19);
					String cardname = rwe.getCellData("Avis_GUI", k, 20);
					String cardNo = rwe.getCellData("Avis_GUI", k, 21);
					// System.out.print("excel card number in script :"
					// +cardNo);
					String expireMonth = rwe.getCellData("Avis_GUI", k, 22);
					String expireYear = rwe.getCellData("Avis_GUI", k, 23);
					String reason = rwe.getCellData("Avis_GUI", k, 24);

					/* Open GUI URL's */
					// System.out.println(" token URL value : " + tokenURL);

					functions.openURL(thinClient);
					/* Login */
					functions.login(uName, pswd);
					functions.navigateToTab("ReservationRates");
					Thread.sleep(500);
					/* Enter Customer Informations */
					/* Enter FTN */
					if (rwe.getCellData("Avis_GUI", k, 19).isEmpty()) {
						System.out.println("No FTN added");
					} else {
						functions.expandToggleBtn();
						Thread.sleep(2000);
						functions.enterFTN(FTN);
					}
					functions.enterCustomerInformation(lstname, fstname, codte, cotme, insta, cidte, citme);
					/* Enter AWD */
					if (awd.isEmpty()) {
						System.out.println("No Avis Discount Number Added");
					} else {
						functions.enterAWD(awd);
					}

					/* Select car group */
					functions.selectCarGroupByVT(carGrp);
					Thread.sleep(2000);

					/* RATE SHOP */
					avis.clickRateshopSearchBtn(driver);
					ArrayList<WebElement> radio = (ArrayList<WebElement>) driver
							.findElements(By.xpath("//input[@name='radioRate'and @type='radio']"));
					for (int i = 0; i < radio.size(); i++) {
						if ((radio.get(i).isDisplayed()) && (radio.get(i).isEnabled())) {
							radio.get(i).click();
							if (radio.get(i).isSelected()) {
								functions.clickSelectRateBtn();
								/* Enter MOP details */
								functions.expandPaymentInfoSection();
								functions.enterPaymentInformations(cardname, cardNo, expireMonth, expireYear, reason);

								/* Add Insurances */
								Thread.sleep(5000);
								functions.expandProtectionCoverageSection();
								if (rwe.getCellData("Avis_GUI", k, 25).isEmpty()) {
									System.out.print("No Insurance selected");
								} else {
									String[] insVal = rwe.getCellData("Avis_GUI", k, 25).split("-");
									for (String e : insVal) {
										WebDriverWait wait1 = new WebDriverWait(driver, 10);
										if (e.equalsIgnoreCase("LDW")) {
											WebElement insurace1 = driver.findElement(
													By.id("menulist:rateshopContainer:resForm:coverageLdwYesNo"));
											Select insLDW = new Select(insurace1);
											wait1.until(ExpectedConditions.visibilityOf(insurace1));
											if (insurace1.isDisplayed()) {
												insLDW.selectByVisibleText("Yes");
											} else {
												break;
											}
										} else if (e.equalsIgnoreCase("PAI")) {
											WebElement insurace2 = driver.findElement(
													By.id("menulist:rateshopContainer:resForm:coveragePaiYesNo"));
											Select insPAI = new Select(insurace2);
											wait1.until(ExpectedConditions.visibilityOf(insurace2));
											if (insurace2.isDisplayed()) {
												insPAI.selectByVisibleText("Yes");
											} else {
												break;
											}
										} else if (e.equalsIgnoreCase("PEP")) {
											WebElement insurace3 = driver.findElement(
													By.id("menulist:rateshopContainer:resForm:coveragePepYesNo"));
											Select insPEP = new Select(insurace3);
											wait1.until(ExpectedConditions.visibilityOf(insurace3));
											if (insurace3.isDisplayed()) {
												insPEP.selectByVisibleText("Yes");
											} else {
												break;
											}
										} else if (e.equalsIgnoreCase("ALI")) {
											WebElement insurace4 = driver.findElement(
													By.id("menulist:rateshopContainer:resForm:coverageAliYesNo"));
											Select insALI = new Select(insurace4);
											wait1.until(ExpectedConditions.visibilityOf(insurace4));
											if (insurace4.isDisplayed()) {
												insALI.selectByVisibleText("Yes");
											} else {
												break;
											}
										} else if (e.equalsIgnoreCase("FSO")) {
											WebElement insurace5 = driver.findElement(
													By.id("menulist:rateshopContainer:resForm:fuelServiceOption"));
											Select insFSO = new Select(insurace5);
											wait1.until(ExpectedConditions.visibilityOf(insurace5));
											if (insurace5.isDisplayed()) {
												insFSO.selectByVisibleText("Yes");
											} else {
												break;
											}
										} else {
											break;
										}
									}
								}

								/*
								 * Add CounterProducts
								 */
								if (rwe.getCellData("Avis_GUI", k, 26).isEmpty()) {
									System.out.print("No CounterProduct selected");
								} else {
									String[] cpVal = rwe.getCellData("Avis_GUI", k, 26).split("-");
									for (String e : cpVal) {
										WebDriverWait wait = new WebDriverWait(driver, 10);
										try {
											if (e.equalsIgnoreCase("ADR")) {
												WebElement cp1 = driver.findElement(By.id("productQuantity40"));
												Select cpADR = new Select(cp1);
												wait.until(ExpectedConditions.visibilityOf(cp1));
												if (cp1.isDisplayed()) {
													cpADR.selectByVisibleText("1");
												} else {
													break;
												}
											} else if (e.equalsIgnoreCase("CBS")) {
												WebElement cp2 = driver.findElement(By.id("productQuantity32"));
												Select cpCBS = new Select(cp2);
												wait.until(ExpectedConditions.visibilityOf(cp2));
												if (cp2.isDisplayed()) {
													cpCBS.selectByVisibleText("1");
												} else {
													break;
												}
											} else if (e.equalsIgnoreCase("CSS")) {
												WebElement cp3 = driver.findElement(By.id("productQuantity34"));
												Select cpCSS = new Select(cp3);
												wait.until(ExpectedConditions.visibilityOf(cp3));
												if (cp3.isDisplayed()) {
													cpCSS.selectByVisibleText("1");
												} else {
													break;
												}
											} else if (e.equalsIgnoreCase("GPS")) {
												WebElement cp4 = driver.findElement(By.id("productQuantityYesNo6"));
												Select cpGPS = new Select(cp4);
												wait.until(ExpectedConditions.visibilityOf(cp4));
												if (cp4.isDisplayed()) {
													cpGPS.selectByVisibleText("Y");
												} else {
													break;
												}
											} else if (e.equalsIgnoreCase("RSN")) {
												WebElement cp5 = driver.findElement(By.id("productQuantityYesNo11"));
												Select cpRSN = new Select(cp5);
												wait.until(ExpectedConditions.visibilityOf(cp5));
												if (cp5.isDisplayed()) {
													cpRSN.selectByVisibleText("Y");
												} else {
													break;
												}
											} else if (e.equalsIgnoreCase("TAB")) {
												WebElement cp6 = driver.findElement(By.id("productQuantityYesNo12"));
												Select cpTAB = new Select(cp6);
												wait.until(ExpectedConditions.visibilityOf(cp6));
												if (cp6.isDisplayed()) {
													cpTAB.selectByVisibleText("Y");
												} else {
													break;
												}
											} else if (e.equalsIgnoreCase("ESP")) {
												WebElement cp7 = driver.findElement(By.id("productQuantityYesNo6"));
												Select cpESP = new Select(cp7);
												wait.until(ExpectedConditions.visibilityOf(cp7));
												if (cp7.isDisplayed()) {
													cpESP.selectByVisibleText("Y");
												} else {
													break;
												}

											} else if (e.equalsIgnoreCase("SNB")) {
												WebElement cp8 = driver.findElement(By.id("productQuantityYesNo11"));
												Select cpSNB = new Select(cp8);
												if (cp8.isDisplayed()) {
													wait.until(ExpectedConditions.visibilityOf(cp8));
													cpSNB.selectByVisibleText("Y");
												} else {
													break;
												}
											}
										} catch (Exception e1) {
											e1.printStackTrace();
										}
									}

								}

								/*
								 * Create reservation
								 */
								functions.clickCreateReservationBtn();
								Thread.sleep(1000);
								String Resmsg = driver
										.findElement(By.xpath("//*[@id='templateInfoForm:templateInfoMsg']")).getText();
								rwe.setCellData("Avis_GUI", k, 40, Resmsg); // write
																			// respopup
																			// in
																			// excel
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@id='templateInfoForm:templateInfoButton']")).click(); // clicks OK button in Res popup
								Thread.sleep(5000);
								functions.ScreenCapture("C:\\GUI_Automation\\selenium\\GUI_Results\\Avis_CR\\", TCName);

								/*
								 * to print QV data in Excel
								 */
								WebElement res = driver.findElement(By.cssSelector(
										"#quickViewPanel > div.panel-body > table > tbody > tr:nth-child(8) > td > div:nth-child(2) > div > table > tbody > tr > td:nth-child(2) > a > span"));

								try {
									if (res.getText().isEmpty()) {
										WebDriverWait wait1 = new WebDriverWait(driver, 20);
										wait1.until(ExpectedConditions.visibilityOf(res));
									}
								} catch (Exception e2) {
									e2.printStackTrace();
								}
								WebElement table = driver.findElement(By.id("resQvForm"));
								ArrayList<WebElement> rows = (ArrayList<WebElement>) table
										.findElements(By.tagName("tr"));
								for (int i1 = 1; i1 < rows.size(); i1++) {
									ArrayList<WebElement> cells = (ArrayList<WebElement>) rows.get(i1)
											.findElements(By.tagName("td"));
									for (int j = 0; j < cells.size(); j++) {
										String val = cells.get(j).getText();
										if (val.isEmpty()) {
											break;
										} else {
											if (j == 2) {
												val = val.replaceAll("[*]", ""); // Remover * before rates
												rwe.setCellData("Avis_GUI", k, a, val);
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

								if (rwe.getCellData("Avis_GUI", k, 27).isEmpty()) {
									rwe.setCellData("Avis_GUI", k, 41, "FAIL");
									test.log(Status.FAIL, "Fail");
								} else {
									rwe.setCellData("Avis_GUI", k, 41, "PASS");
									test.log(Status.PASS, "Pass");
								}
							} // end of inner if
						}  // end of if
						else // Select available base rate from Standard rate
								// table
						{
							System.out.print(" No Base Rates are Available ");
							String RateShopErrorMsg = driver
									.findElement(
											By.xpath("//*[@id='resRateLookupDlg:rateLookupForm:counterRates_data']"))
									.getText();
							String[] RateShopErrorMsg1 = RateShopErrorMsg.split("Base Rate");
							String RSerrmsg = RateShopErrorMsg1[1];
							System.out.println("Rate shop error msg:" + RSerrmsg);
							rwe.setCellData("Avis_GUI", k, 40, RSerrmsg);
							driver.findElement(By.xpath("//input[@id='cancelButton']")).click();
							Thread.sleep(2000);
							functions.logout();
							functions.closeWindows();
						} // end of else
					} // end of for
				} // end of Iteration if

				else {
					System.out.println("Execution status is N for iteration " + k + "...");
				}

			}
		} finally {
			// TODO: handle finally clause
			extent.flush();
		}
	}
}