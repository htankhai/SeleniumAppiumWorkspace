package org.pom.pageobjects;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;

	@FindBy(name="q")
	public WebElement searchField;

	@FindBy(name="btnG")
	public WebElement searchButton;

	public SearchPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);		
	}

	public void searchFor(String text) throws AWTException {
		searchField.sendKeys(text);
		searchButton.submit();
	}
} 