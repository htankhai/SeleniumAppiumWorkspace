package dataProvider1;
/*  @DataProvider work-
1) The number of columns become the number of arguments of the @Test method with their respective order as they have been added while storing in Object array.
2) Once the @Test annotation found with 'dataProvider' keyword, it will call the @DataProvider method.
3) This @DataProvider method will start iterating till the time @Test method has not been executed for all the rows of excel sheet.
4) In simple word, one could say, @DataProvider call the @Test method for each iteration.


Here the @Test method will execute the number of times rows are there in the sheet. For example here is the scenario of login in Yahoo.
Step1- Open the browser and open yahoo.com
Step2- Get the 1st row data from sheet and pass that as input (userName, pass, and expTitle) and click on login button.
Step3- Get the title of the page after login and verify with expTitle.
Step4- close the browser wether testcase passed or failed.
Step4. Then again go back to step2 and get the 2nd row data likewise it will execute the test case for all the rows.
 */
public class DataProvider_ {
	   @Test(dataProvider="DataInput")
	    public void login(String userName, String pass, String expTitle) throws InterruptedException{
	        //open browser and Yahoo
	        WebDriver driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("https://in.yahoo.com/");
	        Actions act = new Actions(driver);
	        //login
	        act.moveToElement(driver.findElement(By.xpath("//em[text()='Sign In']"))).perform();
	        driver.findElement(By.xpath("//span//a[@class='login-svc ylogin login-btn-purple rapid-noclick-resp login-btn-small']")).click();
	        driver.findElement(By.id("username")).sendKeys(userName);
	        driver.findElement(By.id("passwd")).sendKeys(pass);
	        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
	        
	        Thread.sleep(2000);
	        String actTitle = driver.getTitle();
	        try{
	            Assert.assertEquals(actTitle, expTitle);
	            driver.close();
	        }catch(Exception e){
	            driver.close();
	        }
	        
	    }
	   
	   @DataProvider_(name="DataInput")
	    public static Iterator fetchData() throws InvalidFormatException, IOException{
	        ArrayList myData = new ArrayList();
	        FileInputStream fis = new FileInputStream("./InputData.xlsx");
	        Workbook wb = WorkbookFactory.create(fis);
	        Sheet sh = wb.getSheet("Sheet4");
	        int numOfRows = sh.getLastRowNum();
	        String userName, pass, expTitle;
	        for(int i=0; i<numOfRows; i++){
	            userName = sh.getRow(i).getCell(0).getStringCellValue();
	            pass = sh.getRow(i).getCell(1).getStringCellValue();
	            expTitle = sh.getRow(i).getCell(2).getStringCellValue();
	            myData.add(new Object[]{userName,pass,expTitle});
	        }
	        return myData.iterator();
	    }
}
