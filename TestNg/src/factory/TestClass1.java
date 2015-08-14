package factory;

public class TestClass1 {
	protected static WebDriver wd;

    protected static String result;

    String url=”Define the url you are going to test.”;

   

@BeforeClass

public static void setup()  {

    wd = new FirefoxDriver();

    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

}



@Test(enabled = true, description = "Verify that all expected sections are displayed on homepage")

void Testcase1() {

    wd.get(url);

    if(!wd.findElement(By.xpath("//h2[text()='Featured Subjects']")).isDisplayed())

                Assert.fail("Featured Subjects section is not displayed");

    if(!wd.findElement(By.xpath("//h2[text()='Featured Books']")).isDisplayed())

                Assert.fail("Featured Books section is not displayed");

    if(!wd.findElement(By.xpath("//h2[text()='Most Popular']")).isDisplayed())

                Assert.fail("Most Popular section is not displayed");

   

}

   

@Test(enabled = true, description = "Verify quick search")

void Testcase2() {

    wd.get("url");

    if(!wd.findElement(By.xpath("//*[@id='edit-keywords']")).isDisplayed())

                Assert.fail("Quick Search text box is not displayed.");

    wd.findElement(By.xpath("//*[@id='edit-keywords']")).sendKeys("Japan");

    wd.findElement(By.xpath("//*[@id='edit-keywords']")).sendKeys(Keys.RETURN);

    if(wd.findElement(By.xpath("//*[@id='page-title']")).getText().contains("No results found"))

                Assert.fail("No Results were found for a valid search string.");

}



@Test(enabled = true, description = "Verify 'Browse by Titles' functionality.")

void Testcase3() {

    wd.get("url");

    wd.findElement(By.xpath("//*[@id='nice-menu-1']/li[1]/a/span")).click();

    if(wd.findElement(By.xpath("//*[@id='nice-menu-1']/li[1]/ul/li[1]/a")).isDisplayed()) {

                wd.findElement(By.xpath("//*[@id='nice-menu-1']/li[1]/ul/li[1]/a")).click();

                result = wd.getTitle();

                Assert.assertEquals(result, "Browse Titles | GeoWorld", "Browse by titles page is not  dispalyed on selecting the menu item.");

}

    else

                Assert.fail(“Menu Item 'Titles' was not displayed”);

}



@Test(enabled = true, description = "Verify 'Browse by Titles' functionality.")

void Testcase4() {

    wd.get("url");

    wd.findElement(By.xpath("//*[@id='nice-menu-1']/li[1]/a/span")).click();

    if(wd.findElement(By.xpath("//*[@id='nice-menu-1']/li[1]/ul/li[2]/a")).isDisplayed())  {

    wd.findElement(By.xpath("//*[@id='nice-menu-1']/li[1]/ul/li[2]/a")).click();

    result = wd.getTitle();

    Assert.assertEquals(result, "Browse Collections | GeoWorld", "Browse by Publishers page is not  dispalyed on selecting the menu item.");

    }

    else

    Assert.fail(“Menu Item 'Publishers' was not displayed”);

}



@AfterClass

public static void teardown()  {

    wd.close();

    wd.quit();

}
}
