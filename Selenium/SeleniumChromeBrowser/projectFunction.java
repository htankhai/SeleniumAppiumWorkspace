package SeleniumChromeBrowser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//import SeleniumProjectVersion3.BaseClass;


public class projectFunction {


	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 0;

	//static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;

	static WebDriver driver;

	static String  reportFlag ="";
	public static BufferedWriter bw = null;
	/* Name of the method: enterText
	 * Method Description: Enter the value in text box field
	 * Arguments: objXpath --> Xpath of object, enterValue --> value to be entered, objectName --> Name of the textbox
	 * Created by: BSS systems
	 * Creation Date: Feb 25 2014
	 * Last modified: Feb 25 2014
	 * */
	public static void enterText(String objXpath, String enterValue, String objectName) throws IOException{

		if(driver.findElement(By.xpath(objXpath)).isDisplayed()){
			driver.findElement(By.xpath(objXpath)).clear();
			driver.findElement(By.xpath(objXpath)).sendKeys(enterValue);

			// ENTER TEXT
			//driver.findElement(By.xpath(objXpath)).sendKeys(Keys.chord(Keys.CONTROL,"a"), enterValue);

			Update_Report( "Pass", "enterText", objectName + " "+ enterValue + " is entered in " + objectName + " field");
		}else{
			Update_Report( "Fail", "enterText", objectName +  " field does not exist in the application");
		}
	}

	/* Name of the method: validateTextBoxContent
	 * Method Description: Enter the value in text box field
	 * Arguments: objXpath --> Xpath of object, expectedValue --> value to be validated, objectName --> Name of the textbox
	 * Created by: BSS systems
	 * Creation Date: Feb 26 2014
	 * Last modified: Feb 26 2014
	 * */

	public static void validateTextBoxContent(String objXpath, String expectedValue, String objectName) throws IOException{
		if(driver.findElement(By.xpath(objXpath)).isDisplayed()){
			String actualValue;
			actualValue = driver.findElement(By.xpath(objXpath)).getAttribute("value").trim();

			if(actualValue.equals(expectedValue)){
				Update_Report( "Pass", "validateTextBoxContent", "Actual and expected value in the test box " + objectName + " are same. Actual value is '"+ actualValue + "'.");


			}else{
				Update_Report( "Fail", "validateTextBoxContent",  "Actual value "+ actualValue+ " did not match with expected value "+ expectedValue+ " ,  in the text box "+ objectName);

			}

		}else{
			Update_Report( "Fail", "validateTextBoxContent",  objectName +  " field does not exist in the application");

		}
	}
	/* Name of the method: clickButton
	 * Method Description: Click the button
	 * Arguments: objXpath --> Xpath of object, objectName --> Name of the Button
	 * Created by: Praveena
	 * Creation Date: Feb 25 2014
	 * Last modified: Feb 25 2014
	 * */

	public static void clickObject(String objXPath, String objName) throws InterruptedException, IOException
	{
		if(driver.findElement(By.xpath(objXPath)).isDisplayed())
		{
			driver.findElement(By.xpath(objXPath)).click();
			Thread.sleep(1000);
			Update_Report( "Pass", "clickObject", objName+" is clicked");

		}
		else
		{
			Update_Report( "Fail", "clickObject", objName+"  does not exist, please check the application");

		}
	}

	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") {

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) {
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName + "/" + "Chrome/";
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp
				+ ".html";
		File f = new File(strResultPath);
		f.mkdirs();

		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "Chrome" + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#FFCC99 WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=##FF0000 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=##FF0000 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=##FF0000 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=##FF0000 WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detailed Report</B></FONT></TD></TR>");


	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j + 1)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

                                                                                + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
                                                                                + result + "</FONT></TD></TR>");

		}
	}

	/*Name of the Method: readSheet
	 * Brief Description: Reading Data from Xl sheet
	 * Arguments: dataTablePath--> XL Sheet path, SheetName --> Name of the sheet to access
	 * Creation Date: Feb 20 2014
	 * Last updated: Feb 20 2014
	 * Created By: BetsSoft systems 
	 * */


	public static String[][] readSheet(String dataTablePath, String sheetName) throws IOException{

		String xlData[][] = null;

		File xlFile = new File(dataTablePath);

		/*step2: Access the Xl File*/
		FileInputStream xlDoc = new FileInputStream(xlFile);

		/*Step3: Access the work book */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);


		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(sheetName);

		int iRowCount = sheet.getLastRowNum()+1;
		int iColumnCount = sheet.getRow(0).getLastCellNum();

		xlData = new String [iRowCount][iColumnCount];

		for(int i = 0; i <iRowCount; i++ ){
			for(int j = 0; j<iColumnCount; j++){
				HSSFCell cell = sheet.getRow(i).getCell(j);
				xlData[i][j] = cell.getStringCellValue();
			}
		}
		return xlData;
	}


	/*Name of the Method: checkCheckBox
	 * Brief Description: Reading Data from Xl sheet
	 * Arguments: dataTablePath--> XL Sheet path, SheetName --> Name of the sheet to access
	 * Creation Date: Feb 20 2014
	 * Last updated: Feb 20 2014
	 * Created By: BetsSoft systems 
	 * */
	public static void checkCheckBox(String objXPath, String objName) throws InterruptedException, IOException{
		if(driver.findElement(By.xpath(objXPath)).isDisplayed())

			if(!(driver.findElement(By.xpath(objXPath)).isSelected())){
				driver.findElement(By.xpath(objXPath)).click();
				Update_Report( "Pass", "Check box ", objName+" is checked ");
			}else{
				Update_Report( "Pass", "Check box  ", objName+" is already checked.");
			}
		else
		{
			Update_Report( "Fail", "checkCheckBox ", objName+"  does not exist, please check the application");

		}

	}

	/*Name of the Method: unCheckCheckBox
	 * Brief Description: Reading Data from Xl sheet
	 * Arguments: dataTablePath--> XL Sheet path, SheetName --> Name of the sheet to access
	 * Creation Date: Feb 20 2014
	 * Last updated: Feb 20 2014
	 * Created By: BetsSoft systems 
	 * */
	public static void unCheckCheckBox(String objXPath, String objName) throws InterruptedException, IOException{
		if(driver.findElement(By.xpath(objXPath)).isDisplayed())

			if((driver.findElement(By.xpath(objXPath)).isSelected())){
				driver.findElement(By.xpath(objXPath)).click();
				Update_Report( "Pass", "Check box ", objName+" is unchecked ");
			}else{
				Update_Report( "Pass", "Check box  ", objName+" is already unchecked.");
			}
		else
		{
			Update_Report( "Fail", "checkCheckBox ", objName+"  does not exist, please check the application");

		}

	}




	/* Name of the method: validateMessageDisplayed
	 * Method Description: Enter the value in text box field
	 * Arguments: objXpath --> Xpath of object, expectedValue --> value to be validated, objectName --> Name of the textbox
	 * Created by: BSS systems
	 * Creation Date: Mar 4 2014
	 * Last modified: Mar 4 2014
	 * */
	public static void validateMessageDisplayed(String objXpath, String expectedValue, String objectName) throws IOException{

		if(driver.findElement(By.xpath(objXpath)).isDisplayed()){
			String actualValue;
			actualValue = driver.findElement(By.xpath(objXpath)).getText().trim();

			if(actualValue.equals(expectedValue)){
				Update_Report( "Pass", "validateMessageDisplayed", "Actual value matches with expected value. Actual value is '"+ actualValue + "'.");


			}else{
				Update_Report( "Fail", "validateMessageDisplayed",  "Actual value '"+ actualValue+ "' did not match with expected value '"+ expectedValue+ "' for the object "+ objectName);

			}

		}else{
			Update_Report( "Fail", "validateMessageDisplayed",  objectName +  " field does not exist in the application");

		}

	}
	public static void writeSheet(String dataTablePath, String sheetName, int iRow, int iColumn, String xlData) throws IOException{
		/* Access The Path of Xl File*/
		File xlFile = new File(dataTablePath );
		/* Access the File */
		FileInputStream xlDoc = new FileInputStream(xlFile);  
		/* Access The Work Book */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);
		/* Access the Sheet */
		HSSFSheet sheet = wb.getSheet(sheetName);
		/*Access Row*/
		HSSFRow row = sheet.getRow(iRow);
		/*Access the column*/
		HSSFCell cell = row.getCell(iColumn);
		/* Set string Type */
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);


		/* Set Color */
		HSSFCellStyle titleStyle = wb.createCellStyle();
		if(xlData.equalsIgnoreCase("Pass")){
			titleStyle.setFillForegroundColor(new HSSFColor.GREEN().getIndex());

			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
		}else if(xlData.equalsIgnoreCase("")){
			xlData = "NA";
			titleStyle.setFillForegroundColor(new HSSFColor.LIGHT_ORANGE().getIndex());

			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
		}else {
			titleStyle.setFillForegroundColor(new HSSFColor.RED().getIndex());

			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
		}
		cell.setCellValue(xlData);

		/*CreationHelper createHelper = wb.getCreationHelper();
		Hyperlink link = createHelper.createHyperlink(Hyperlink.LINK_URL);
		String htmlname1 = "file:///" + htmlname;
		link.setAddress(htmlname1);
		cell.setHyperlink(link);*/

		FileOutputStream fout = new FileOutputStream(dataTablePath);
		wb.write(fout);
		fout.flush();
		fout.close();
	}

	public static void selectByVisibleValue( String objXPath,  String value, String objName ) throws IOException
	{ 
		if(driver.findElement(By.xpath(objXPath)).isDisplayed())
		{
			Select dropDownList = new Select(driver.findElement(By.xpath(objXPath)));
			dropDownList.selectByValue(value);
			Update_Report( "Pass", "value from drop box",   objName + " is selected. ");
		}
		else
		{	
			Update_Report( "Fail", "value from drop box",   objName + " does not exist. ");
		}
		reportFlag = "Pass";
	}

	public static void selectLabelInDropDown(By by, String optionLabel) { 
		Select select = new Select(driver.findElement(by)); 
		select.selectByVisibleText(optionLabel); 
	} 
	public static void selectValueInDropDown(String dropdownPath, String optionValue) { 
		Select select = new Select(driver.findElement(By.xpath(dropdownPath))); 
		select.selectByValue(optionValue); 
	}


	public static void selectByVisibleText(String objXPath, String TextName) throws InterruptedException, IOException{
		if(driver.findElement(By.xpath(objXPath)).isDisplayed()){
			WebElement selectElement = driver.findElement(By.xpath(objXPath)); 
			Select select = new Select(selectElement); 
			List <WebElement> options = select.getOptions(); 
			for (WebElement option: options) { 
				if(option.getText().equals(TextName)){
					option.click();
					Update_Report( "Pass", "Text box ", objName+" is selected ");
					reportFlag = " Pass";
					break;
				}
			}

			/*if(!(driver.findElement(By.xpath(objXPath)).isSelected())){

			//driver.findElement(By.xpath(objXPath)).click();
			Update_Report( "Pass", "Text box ", objName+" is selected ");
			//}else{
			Update_Report( "Pass", "Text box  ", objName+" is already selected.");*/
		}
		else
		{
			Update_Report( "Fail", "TextBox ", objName+"  does not exist, please check the application");
			reportFlag = " Fail";
		}

	}


	public static Boolean isTextExistInDropdownList(String dropdownPath, String dropdownName, String text) throws IOException{
		Boolean isPresent = false;
		Select dropDownList = new Select(driver.findElement(By.xpath(dropdownPath)));
		List<WebElement> list = dropDownList.getOptions();
		for(WebElement webElem : list){
			System.out.println(webElem.getText());
			if(webElem.getText().equalsIgnoreCase(text)){
				isPresent = true;
			}

		}

		if(isPresent){
			Update_Report("Pass", "isTextExistInDropdownList", text +  " exists." );
			reportFlag = "Pass";
		}

		else {
			Update_Report("Fail", "isTextExistInDropdownList" ,  text + " does  exists . " );
			reportFlag = "Fail";
		}

		return isPresent;      }


	public void getAllSelectedOptions() {
		WebElement selectElement = driver.findElement(By.xpath("//*[@id='City']")); 
		Select select = new Select(selectElement); 
		List <WebElement> options = select.getOptions(); 
		for (WebElement option: options) { 
			if(option.getText().equals("Delhi")){
				option.click();
				break;

			}
		}
	}


	public static void selectDropdownListByVisibleText(String dropdownPath,String dropdownName, String text) throws IOException {
		Boolean isAlreadySelected = false;
		if (driver.findElement(By.xpath(dropdownPath)).isDisplayed()) {

			Select dropDownList = new Select(driver.findElement(By.xpath(dropdownPath)));
			if (dropDownList.isMultiple()) {
				List<WebElement> selectedElems = dropDownList.getAllSelectedOptions();
				for (WebElement webElem : selectedElems) {
					if (webElem.getText().equalsIgnoreCase(text)) {
						isAlreadySelected = true;
					}
				}
			} 
			else  {

				if (dropDownList.getFirstSelectedOption().getText().equals(text)) {
					isAlreadySelected = true;
				}
			}
			if (!isAlreadySelected) {
				dropDownList.selectByVisibleText(text);
				Update_Report("Pass", "selectDropdownListByVisibleText","Text " + text + " in " + dropdownName+ " dropdown is selected");
				reportFlag = "Pass";
			} 

			else {
				Update_Report("Pass", "selectDropdownListByVisibleText","Text " + text + " in " + dropdownName+ " dropdown is already selected");
				reportFlag = "Pass";
			}

		} else {
			Update_Report("Fail", "selectDropdownListByVisibleText",dropdownName+ " dropdown is not displayed in the application");
			reportFlag = "Fail";
		}
	}

	public static void SelectRadioButton(String radioPath, String radioName) throws IOException{
		if(driver.findElement(By.xpath(radioPath)).isDisplayed()){
			if(driver.findElement(By.xpath(radioPath)).getText().trim().equals(radioName)){
				WebElement radioButton  = driver.findElement(By.xpath(radioPath));
				radioButton.findElement(By.tagName("input")).click();
				Update_Report("Pass", "SelectRadiobutton", radioName+ " is selected." );
				reportFlag = "Pass";
			}
			else {
				Update_Report("Fail", "SelectRadiobutton", radioName+ " is not matched." );
				reportFlag = "Fail";

				//Assert.assertEquals("message", radioName, driver.findElement(By.xpath(radioPath)).getText())}
			}	
		}
		else{ Update_Report("Fail", "SelectRadiobutton", radioName+ " is not displayed. " );
		reportFlag = "Fail";
		}

	}
	public static String SelectOptionsinDropDownList(By by, String optionToSelect, String text){
		Select dropDownList = new Select(driver.findElement(by));
		Assert.assertFalse(dropDownList.isMultiple());
		//WebElement selectElement = driver.findElement(dropdownPath); 
		//Then instantiate the Select class with that WebElement 
		Select select = new Select(driver.findElement(by)); 

		//Get a list of the options 
		List <WebElement> options = select.getOptions(); 
		// For each option in the list, verify if it's the one you want and then click it 
		for (WebElement option: options) { 
			if (option.getText().equals(optionToSelect)){ 
				option.click(); 
				break;
			} 
			//Update_Report("Pass", "selectDropdownListByVisibleText","Text " + text + " in " ++ " dropdown is selected");
			reportFlag = "Pass";
		}
		return select.getFirstSelectedOption().getText(); 
	}


	/*public static void selectDivOptions(String xpath,String text, String divName){
	if(driver.findElement(By.xpath(xpath)).isDisplayed()){
		List<WebElement> options = driver.findElements(By.xpath(xpath));
		for(WebElement elem : options){
			System.out.println(elem.getText());
		}
	}
	else{
		}
	}*/

	public static void windowHandler(String objXPath, String objName) throws InterruptedException, IOException{
		String a[]=new String[5];
		//		a[0]= "hm";
		int i=0;
		for(String winHandle:driver.getWindowHandles()){
			a[i]=winHandle.toString();
			i++;
		}
		driver.switchTo().window(a[1]);
		clickObject(objXPath,objName);
		//clickObject("//*[@id='tab-1179-btnEl']","close message box");
		
		driver.close();
		driver.switchTo().window(a[0]);

		//String winHandle = driver.getWindowHandle();
		//Set<String> winHan1 = driver.getWindowHandles();


		//Set<String> l1 = driver.getWindowHandles();
		//Object[] a = null;
		//a = l1.toArray();
	}

	
	//pop up
			/*Alert alert = driver.switchTo().alert();
			alert.accept();// click on ok
			
			alert.dismiss(); // click on cancel
			
			alert.sendKeys("Hhhhh"); // Enter some value in pop...*/	

}


