package statefarm;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestScript extends projectFunction{
	
	@Test(priority = 0)
	public static void fileAClaimAutoIndividual() throws IOException, InterruptedException{

		//create xls file provided the test data
		String policyRecord[][] = null;
		String claimDataTablePath1 = "C:/Users/htan/LinkPagesRepo/Statefarm/TestData/FileAClaimAutoIndividual.xls";
		policyRecord = projectFunction.readSheet(claimDataTablePath1, "Sheet1");
		
		String URL = policyRecord[1][1];
		String state = policyRecord[1][3];
		String individual = policyRecord[1][5];

		/*Launch Statefarm application*/
		driver = new FirefoxDriver();
		driver.get(URL);

		//Implicit global time out applicable for every find element command
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Update_Report("Pass", "Launch application "," Application has been launched : " + URL);
		driver.manage().window().maximize();

		//claims tab
		clickObject("//*[@id='claims-menuitem']/span", "Claims");

		//Auto radio button
		clickObject("//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div[1]/fieldset/label[1]/input", "Auto");

		//Select - State list 
		Select dropDownList1 = new Select(driver.findElement(By.xpath("//*[@id='sState']")));
		dropDownList1.selectByVisibleText(state);
		
		//submit "Go" button
		clickObject("//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div[2]/input", "Go");

		// policy number text field
		String policyData[][] = null;
		String DataTablePath1 = "C:/Users/htan/LinkPagesRepo/Statefarm/TestData/PolicyNumber.xls";
		policyData = projectFunction.readSheet(DataTablePath1, "Sheet1");
		String policy1 = policyData[1][1];
		String policy2 = policyData[2][1];
		String policy3 = policyData[3][1];
		String policy4 = policyData[4][1];
		enterText("//*[@id='login.policyNumberPart1-sfxid_1']", policy1 , " policy1" );
		enterText("//*[@id='login.policyNumberPart2-sfxid_2']", policy2 , " policy2" );
		enterText("//*[@id='login.policyNumberPart3-sfxid_3']", policy3 , " policy3" );
		enterText("//*[@id='login.policyNumberPart4-sfxid_4']", policy4 , " policy4" );
		
		//submit individual radio button
		clickObject("//*[@id='login.nameType0']", individual);

		//text fields: first name, last name, risk location, address, city, zip code, year , make and model   
		String firstName = policyRecord[1][6];
		String lastName = policyRecord[1][7];	
		String riskLocation = policyRecord[1][8];
		String address = policyRecord[1][9];
		String city = policyRecord[1][10];
		String zipCode = policyRecord[1][12];
		String year = policyRecord[1][13];
		String make = policyRecord[1][14];
		String model = policyRecord[1][15];
		enterText("//*[@id='login_firstNameId-sfxid_6']",firstName ,  "Insured first Name ");
		enterText("//*[@id='login_lastNameId-sfxid_7']",lastName , "Insured Last Name ");
		enterText("//*[@id='login_address_streetId-sfxid_10']", address, "Mailing Address");
		enterText("//*[@id='login_address_cityId-sfxid_11']", city , "City");

		Select dropDownList2 = new Select(driver.findElement(By.xpath("//*[@id='login_address_stateId-sfxid_12']")));
		dropDownList2.selectByVisibleText(riskLocation);

		enterText("//*[@id='login_address_zipId-sfxid_13']", zipCode, "Zip code");
		enterText("//*[@id='login_vehicleYearId-sfxid_14']", year , "Year");
		enterText("//*[@id='login_vehicleMakeId-sfxid_15']", make  , "Make");
		enterText("//*[@id='login_vehicleModelId-sfxid_16']",model   , "Model");
		clickObject("//*[@id='buttonContinueId']/span", " Continue");

		//close the current opening window with driver.
		driver.close();

	}

	public static void fileAClaimAutoBusiness() throws IOException, InterruptedException{
		//test script xls file with URL, state, business, service
		String policyRecord[][] = null;
		String claimDataTablePath1 = "C:/Users/htan/Desktop/statefarm/TestData/FileAClaimAutoBusiness.xls";
		policyRecord = projectFunction.readSheet(claimDataTablePath1, "Sheet1");
		String URL = policyRecord[1][1];
		String state = policyRecord[1][3];
		String business = policyRecord[1][4];
		String service = policyRecord[1][6];

		/*Launch Statefarm application*/
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Update_Report("Pass", "Launch application "," Application has been launched : " + URL);
		driver.manage().window().maximize();

		//claims tab
		clickObject("//*[@id='claims-menuitem']/span", "Claims");

		//auto radio button
		clickObject("//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div[1]/fieldset/label[1]/input", " Auto");

		//state list to select
		Select dropDownList1 = new Select(driver.findElement(By.xpath("//*[@id='sState']")));
		dropDownList1.selectByVisibleText(state);

		//go button
		clickObject("//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div[2]/input", " Go");

		//policy number
		String policyData[][] = null;
		String DataTablePath1 = "C:/Users/htan/Desktop/statefarm/TestData/PolicyNumber.xls";
		policyData = projectFunction.readSheet(DataTablePath1, "Sheet1");
		String policy1 = policyData[1][1];
		String policy2 = policyData[2][1];
		String policy3 = policyData[3][1];
		String policy4 = policyData[4][1];

		//text fileds - policy1, policy 2, policy 3, policy 4
		enterText("//*[@id='login.policyNumberPart1-sfxid_1']", policy1 , " policy1" );
		enterText("//*[@id='login.policyNumberPart2-sfxid_2']", policy2 , " policy2" );
		enterText("//*[@id='login.policyNumberPart3-sfxid_3']", policy3 , " policy3" );
		enterText("//*[@id='login.policyNumberPart4-sfxid_4']", policy4 , " policy4" );

		//business radio button
		clickObject("//*[@id='login.nameType1']", business);
		enterText("//*[@id='login_businessNameId-sfxid_9']", service , "Insured business name ");

		//xls file
		String claimDataTablePath = "C:/Users/htan/Desktop/statefarm/TestData/FileAClaimAutoBusiness.xls";
		policyRecord = projectFunction.readSheet(claimDataTablePath, "Sheet1");
		String address = policyRecord[1][7];
		String city = policyRecord[1][8];
		String zipCode = policyRecord[1][10];
		String year = policyRecord[1][11];
		String make  = policyRecord[1][12];
		String model  = policyRecord[1][13];

		//text fileds - mailing address, city, 
		enterText("//*[@id='login_address_streetId-sfxid_10']",address, "Policy mailing address "  );
		enterText("//*[@id='login_address_cityId-sfxid_11']", city , "City ");

		//select state from list
		Select dropDownList2 = new Select(driver.findElement(By.xpath("//*[@id='login_address_stateId-sfxid_12']")));
		dropDownList2.selectByVisibleText(state);

		//text fields - zip code, year, make, model
		enterText("//*[@id='login_address_zipId-sfxid_13']", zipCode, "ZIP/Postal code"); 
		enterText("//*[@id='login_vehicleYearId-sfxid_14']", year , "Year (yyyy) " );
		enterText("//*[@id='login_vehicleMakeId-sfxid_15']", make , "Make ");
		enterText("//*[@id='login_vehicleModelId-sfxid_16']", model , "Model");

		//continue button
		clickObject("//*[@id='buttonContinueId']/span", " Continue");
		driver.close();

	}

	public static void findRepairFacility() throws IOException, InterruptedException{
		//Create xl file URL , zip code, radius, language1 and language2
		String fileRecord[][] = null;
		String claimDataTablePath1 = "C:/Users/htan/Desktop/statefarm/TestData/findRepairFacility.xls";
		fileRecord = projectFunction.readSheet(claimDataTablePath1, "Sheet1");
		String URL = fileRecord[1][1];
		String zipCode = fileRecord[1][2];
		String radius = fileRecord[1][3];
		String lang1 = fileRecord[1][4];
		String lang2 = fileRecord[1][5];

		/*Launch State farm application*/
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Update_Report("Pass", "Launch application "," Application has been launched : " + URL );
		driver.manage().window().maximize();

		//claims tab
		clickObject("//*[@id='claims-menuitem']/span", "Claims");

		//Find an auto repair facility link
		clickObject("//*[@id='content']/div[2]/div[3]/div/div/ul/li[2]/a","Find an auto repair facility" );

		//zip code text field
		enterText("//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div/input[1]",  zipCode, " Zip Code" );

		//go button
		clickObject("//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div/input[2]", "Go ");

		//By Zip Code tab
		//select radius list
		Select dropDownList2 = new Select(driver.findElement(By.xpath("//*[@id='SearchBean_radiusId-sfxid_11']")));
		dropDownList2.selectByVisibleText(radius);

		//select languages list
		Select dropDownList3 = new Select(driver.findElement(By.xpath("//*[@id='SearchBean_languageId-sfxid_12']")));
		dropDownList3.selectByVisibleText(lang1);
		//find button
		clickObject("//*[@id='find']/span", "Find");
		//next button
		clickObject("//*[@id='next1']", "Next");
		//next button
		clickObject("//*[@id='next1']", "Next");
		//next button
		clickObject("//*[@id='next1']", "Next");	
		//previous button
		clickObject("//*[@id='previous1']", " Previous");

		//By Address Tab				
		String policyRecord[][] = null;
		String claimDataTablePath11 = "C:/Users/htan/Desktop/statefarm/TestData/FileAClaimAutoIndividual.xls";
		policyRecord = projectFunction.readSheet(claimDataTablePath11, "Sheet1");
		String state = policyRecord[1][3];
		String address = policyRecord[1][9];
		String city = policyRecord[1][10];
		String zipCode1 = policyRecord[1][12];
		// by address tab
		clickObject( "//*[@id='addressTab']", "By Address");
		//text field -- street address
		enterText("//*[@id='SearchBean_addressId-sfxid_7']", address,  "Enter a Street Address");
		//zip code text field
		enterText("//*[@id='SearchBean_addressZipCodeId-sfxid_8']", zipCode1 ,  "Enter a Zip Code");

		//select radius list 
		Select dropDownList4 = new Select(driver.findElement(By.xpath("//*[@id='SearchBean_radiusId-sfxid_11']")));
		dropDownList4.selectByVisibleText(radius);

		//select langs
		Select dropDownList5 = new Select(driver.findElement(By.xpath("//*[@id='SearchBean_languageId-sfxid_12']")));
		dropDownList5.selectByVisibleText(lang1);

		//find button
		clickObject("//*[@id='find']/span", "Find");

		//By City tab
		clickObject("//*[@id='cityTab']", "By City");

		//city text field
		enterText("//*[@id='SearchBean_cityId-sfxid_5']", city,  "Enter a City");

		//select city state id
		Select dropDownState = new Select(driver.findElement(By.xpath("//*[@id='SearchBean_cityStateId-sfxid_6']")));
		dropDownState.selectByVisibleText(state);

		//select raius 
		Select dropDownRadius = new Select(driver.findElement(By.xpath("//*[@id='SearchBean_radiusId-sfxid_11']")));
		dropDownRadius.selectByVisibleText(radius);

		//select language
		Select dropDownLang = new Select(driver.findElement(By.xpath("//*[@id='SearchBean_languageId-sfxid_12']")));
		dropDownLang.selectByVisibleText(lang1);

		//find button
		clickObject("//*[@id='find']/span", "Find");

		//next button
		clickObject("//*[@id='next1']", "Next");

		//next button
		clickObject("//*[@id='next1']", "Next");
		//next button
		clickObject("//*[@id='next1']", "Next");

		//previous button
		clickObject("//*[@id='previous1']", " Previous");
		driver.close();


	}


	public static void claimsPropertyBusiness() throws IOException, InterruptedException{
		String policyRecord[][] = null;
		String claimDataTablePath1 = "C:/Users/htan/Desktop/statefarm/TestData/claimsPropertyBusiness.xls";
		policyRecord = projectFunction.readSheet(claimDataTablePath1, "Sheet1");
		String URL = policyRecord[1][1];
		String property = policyRecord[1][2];
		String business = policyRecord[1][4];
		String state = policyRecord[1][8];

		/*Launch Statefarm application*/
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Update_Report("Pass", "Launch application "," Application has been launched :" +URL );
		driver.manage().window().maximize();

		//claims tab
		clickObject("//*[@id='claims-menuitem']/span", "Claims");

		//property radio button
		clickObject("//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div[1]/fieldset/label[2]/input", property);

		//select state list
		Select dropDownList1 = new Select(driver.findElement(By.xpath("//*[@id='sState']")));//State
		dropDownList1.selectByVisibleText(state);

		//go button
		clickObject("//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div[2]/input", "Go");

		//Property report a claim
		String policyData[][] = null;
		String DataTablePath1 = "C:/Users/htan/Desktop/statefarm/TestData/PolicyNumber.xls";
		policyData = projectFunction.readSheet(DataTablePath1, "Sheet1");
		String policy1 = policyData[1][1];
		String policy2 = policyData[2][1];
		String policy3 = policyData[3][1];
		String policy4 = policyData[4][1];

		//text fields of policy1, policy2, policy 3 , policy 4 
		enterText("//*[@id='loginInfo.policyNumberPart1-sfxid_1']", policy1 , " policy1" );
		enterText("//*[@id='loginInfo.policyNumberPart2-sfxid_2']", policy2 , " policy2" );
		enterText("//*[@id='loginInfo.policyNumberPart3-sfxid_3']", policy3 , " policy3" );
		enterText("//*[@id='loginInfo.policyNumberPart4-sfxid_4']", policy4 , " policy4" );

		//business radio button
		clickObject("//*[@id='loginInfo.nameType1']", business);

		String businessName = policyRecord[1][7];
		String address = policyRecord[1][9];
		String city = policyRecord[1][10];
		String zipCode = policyRecord[1][12];

		//business text field
		enterText("//*[@id='loginInfo_businessNameId-sfxid_9']", businessName ,  "Business name");


		//select Risk Location list
		Select dropDownList2 = new Select(driver.findElement(By.xpath("//*[@id='loginInfo_riskLocationId-sfxid_10']")));
		dropDownList2.selectByVisibleText(state);

		//policy mailing address filed
		enterText("//*[@id='loginInfo_address_streetId-sfxid_11']", address, "Policy Mailing Address");

		//city field
		enterText("//*[@id='loginInfo_address_cityId-sfxid_12']", city , "City");

		//select state list
		Select dropDownList3 = new Select(driver.findElement(By.xpath("//*[@id='loginInfo_address_stateId-sfxid_13']")));
		dropDownList3.selectByVisibleText(state);

		//zip code field
		enterText("//*[@id='loginInfo_address_zipId-sfxid_14']", zipCode, "Zip code");

		//continue button
		clickObject("//*[@id='buttonContinueId']/span", "Continue");
		driver.close();
	}

	public static void claimsPropertyIndividual()throws IOException, InterruptedException{
		String policyRecord[][] = null;
		String claimDataTablePath1 = "C:/Users/htan/Desktop/statefarm/TestData/claimsPropertyIndividual.xls";
		policyRecord = projectFunction.readSheet(claimDataTablePath1, "Sheet1");
		String URL = policyRecord[1][1];
		String property = policyRecord[1][2];
		String individual = policyRecord[1][4];
		String state = policyRecord[1][8];

		/*Launch State farm application*/
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Update_Report("Pass", "Launch application "," Application has been launched :" +URL );
		driver.manage().window().maximize();
		
		//claims tab
		clickObject("//*[@id='claims-menuitem']/span", "Claims");

		//property radio button
		clickObject("//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div[1]/fieldset/label[2]/input", property);

		//select state list
		Select dropDownList1 = new Select(driver.findElement(By.xpath("//*[@id='sState']")));
		dropDownList1.selectByVisibleText(state);

		//go button
		clickObject("//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div[2]/input", "Go");

		//Property report a claim
		String policyData[][] = null;
		String DataTablePath1 = "C:/Users/htan/Desktop/statefarm/TestData/PolicyNumber.xls";
		policyData = projectFunction.readSheet(DataTablePath1, "Sheet1");
		String policy1 = policyData[1][1];
		String policy2 = policyData[2][1];
		String policy3 = policyData[3][1];
		String policy4 = policyData[4][1];

		//text fields of policy1, policy2, policy 3 , policy 4 
		enterText("//*[@id='loginInfo.policyNumberPart1-sfxid_1']", policy1 , " policy1" );
		enterText("//*[@id='loginInfo.policyNumberPart2-sfxid_2']", policy2 , " policy2" );
		enterText("//*[@id='loginInfo.policyNumberPart3-sfxid_3']", policy3 , " policy3" );
		enterText("//*[@id='loginInfo.policyNumberPart4-sfxid_4']", policy4 , " policy4" );

		//individual radio button
		clickObject("//*[@id='loginInfo.nameType0']",individual );

		//Individual data - first name, last name ,  address, city, zip code
		String firstName = policyRecord[1][5];
		String lastName = policyRecord[1][6];

		//String businessName = policyRecord[1][7];
		String address = policyRecord[1][9];
		String city = policyRecord[1][10];
		String zipCode = policyRecord[1][12];

		//individual fields
		enterText("//*[@id='loginInfo_firstNameId-sfxid_6']", firstName ,  "Insured first Name ");
		enterText("//*[@id='loginInfo_lastNameId-sfxid_7']", lastName , "Insured Last Name ");

		//select Risk Location list
		Select dropDownList2 = new Select(driver.findElement(By.xpath("//*[@id='loginInfo_riskLocationId-sfxid_10']")));
		dropDownList2.selectByVisibleText(state);

		//policy mailing address filed
		enterText("//*[@id='loginInfo_address_streetId-sfxid_11']", address, "Policy Mailing Address");

		//city field
		enterText("//*[@id='loginInfo_address_cityId-sfxid_12']", city , "City");

		//select state list
		Select dropDownList3 = new Select(driver.findElement(By.xpath("//*[@id='loginInfo_address_stateId-sfxid_13']")));
		dropDownList3.selectByVisibleText(state);

		//zip code field
		enterText("//*[@id='loginInfo_address_zipId-sfxid_14']", zipCode, "Zip code");

		//continue button
		clickObject("//*[@id='buttonContinueId']/span", "Continue");
		driver.close();
	}


	public static void estatePlanning() throws IOException, InterruptedException{
		String policyRecocrd[][] = null;
		String TablePath1 = "C:/Users/htan/Desktop/statefarm/TestData/estatePlanningSheet.xls";
		policyRecocrd = projectFunction.readSheet(TablePath1, "Sheet1");
		String URL = policyRecocrd[1][1];
		String state = policyRecocrd[1][3];
		String address = policyRecocrd[1][7];
		String city = policyRecocrd[1][8];
		String zipCode = policyRecocrd[1][10];
		String radius = policyRecocrd[1][11];
		String agentName = policyRecocrd[1][12];

		/*Launch State farm application*/
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Update_Report("Pass", "Launch application "," Application has been launched : "+ URL);
		driver.manage().window().maximize();

		//Finances tab
		clickObject("//*[@id='finances-menuitem']/span", "Finances");

		//Find an agent. 
		//zip code field 
		enterText("//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div/input[1]",zipCode,  "zip code field");

		//go button
		clickObject( "//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div/input[2]", "Go");

		//By Zip Code tab
		clickObject("//*[@id='zipTab']", "zip tab");

		//zip code field
		enterText("//*[@id='SearchBean_zipCodeId-sfxid_2']", zipCode, "Zip Code text box");

		//find button
		clickObject("//*[@id='find']/span", "Find");

		//next button
		clickObject("//*[@id='next1']", "Next");

		//next button
		clickObject("//*[@id='next1']", "Next");

		//previous button
		clickObject("//*[@id='previous1']", "Previous");


		//By Address tab
		clickObject("//*[@id='addressTab']", "By Address");

		// street address field
		enterText("//*[@id='SearchBean_addressId-sfxid_3']", address , "Enter a Street Address");

		//zip code field
		enterText("//*[@id='SearchBean_addressZipCodeId-sfxid_4']", zipCode, "Enter a Zip Code");

		//select radius 
		Select MilesdropDownList = new Select(driver.findElement(By.xpath("//*[@id='SearchBean.addressRadius-sfxid_5']")));
		MilesdropDownList.selectByVisibleText(radius);						
		//find button
		clickObject("//*[@id='find']/span", " Find");
		//next button
		clickObject("//*[@id='next1']", "Next");
		//previous button
		clickObject("//*[@id='previous1']", " Previous");

		//By City tab
		clickObject("//*[@id='cityTab']", " By City");
		//by city field
		enterText("//*[@id='SearchBean_cityId-sfxid_6']", city, "Enter a City");

		//select city 
		Select StatedropDownList = new Select(driver.findElement(By.xpath("//*[@id='SearchBean_cityStateId-sfxid_7']")));
		StatedropDownList.selectByVisibleText(state);						
		//find button
		clickObject("//*[@id='find']/span", "Find");
		//next button
		clickObject("//*[@id='next1']", "Next");
		//previous button
		clickObject("//*[@id='previous1']", " Previous");

		//By Name tab
		clickObject("//*[@id='nameTab']", "By Name ");

		//By name field
		enterText("//*[@id='SearchBean_nameId-sfxid_8']", agentName , "Enter an Agent's Last Name");

		//select state
		Select cityStatedropDownList = new Select(driver.findElement(By.xpath("//*[@id='SearchBean_nameStateId-sfxid_9']")));
		cityStatedropDownList.selectByVisibleText(state);

		//find button
		clickObject("//*[@id='find']/span", "Find");
		driver.close();

	}

	public static void lifeInsurance() throws IOException, InterruptedException{
		String policyRecord[][] = null;
		String TablePath1 = "C:/Users/htan/Desktop/statefarm/TestData/lifeInsurance.xls";
		policyRecord = projectFunction.readSheet(TablePath1, "Sheet1");
		String URL = policyRecord[1][1];
		String state = policyRecord[1][2];
		String sex = policyRecord[1][3];//male
		String mm = policyRecord[1][4];
		String dd = policyRecord[1][5];
		String yyyy = policyRecord[1][6];
		String heightFt = policyRecord[1][7];
		String heightInch = policyRecord[1][8];
		String weight = policyRecord[1][9];
		String coverage = policyRecord[1][12];

		/*Launch State farm application*/
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Update_Report("Pass", "Launch application "," Application has been launched : "+ URL);
		driver.manage().window().maximize();

		//Finances tab
		clickObject("//*[@id='finances-menuitem']/span", "Finances");

		//Life insurance 
		clickObject("//*[@id='finances']/div[1]/ul/li[8]/a", " Life Insurance");

		//select state
		Select StatedropDownList = new Select(driver.findElement(By.xpath("//*[@id='sState']")));
		StatedropDownList.selectByVisibleText(state);

		//go button
		clickObject("//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div/input","Go ");

		//sex radio button. male
		clickObject("//*[@id='gender10']", sex);

		//text fileds month, day, year
		enterText("//*[@id='age1Id']/div[1]/input", mm, "MM");
		enterText( "//*[@id='age1Id']/div[3]/input", dd , "DD");
		enterText("//*[@id='age1Id']/div[5]/input", yyyy , "YYYY");

		//text fields- height ft, inch, weight in pounds
		enterText("//*[@id='ft1-sfxid_2']", heightFt, "Height ft");
		enterText("//*[@id='in1-sfxid_3']", heightInch, "inch");
		enterText("//*[@id='lbs1-sfxid_4']", weight, "Weight lbs");

		//use of tobacco in three years. no
		clickObject("//*[@id='tobaccoNicotine11']", "tobacco or other nicotine products?");

		//rate health status. excellent
		clickObject("//*[@id='cust1RateYourHealth0']", "RateYourHealth");

		//select coverage list
		Select coverageDropDownList = new Select(driver.findElement(By.xpath("//*[@id='coverageList1Id-sfxid_9']")));
		coverageDropDownList.selectByVisibleText(coverage);

		//current statefarm customer
		clickObject("//*[@id='custAlreadyWithSF11']", "a current State Farm customer?");

		//get quote button
		clickObject("//*[@id='getQuoteBtnID']/span", "Get Quote");

		//continue
		clickObject("//*[@id='R01_0_selectContinue']/span", "Select & Continue Whole Life");

		//summary
		clickObject("//*[@id='ViewSummaryBtnId']/span", "View Summary");

		driver.close();

	}



}