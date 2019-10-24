package com.atmecs.automate_konakart.pages;

import java.text.ParseException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.automate_konakart.helper.SeleniumHelper;
import com.atmecs.automate_konakart.helper.ValidaterHelper;
import com.atmecs.automate_konakart.logreports.LogReporter;
/**
 * This class contains the validate hero page method 
 * this method automate and validate the hero image product using Selenium scripts and testng.
 * @author ajith.periyasamy
 *
 */
public class HeroPage {
	LogReporter log=new LogReporter();
	SeleniumHelper seleniumhelp=new SeleniumHelper();
	ValidaterHelper validate=new ValidaterHelper();
	/**
	 * this method  take the below parameters
	 * @param driver
	 * @param prop
	 * @param proddata
	 *  and automate the hero image product with review,product description,specification validation.
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public void validateHeropPage(WebDriver driver,Properties prop,String[] proddata) throws InterruptedException, ParseException{
			WebDriverWait wait2 = new WebDriverWait(driver, 20);
			wait2.until(ExpectedConditions.elementToBeClickable(seleniumhelp.matchElement(prop.getProperty("loc.img.hero"))));
			WebElement imgElement=driver.findElement(seleniumhelp.matchElement(prop.getProperty("loc.img.hero")));
		if(imgElement.getAttribute("srcset").equalsIgnoreCase(proddata[1])) 
		{
			seleniumhelp.clickElement(driver,prop.getProperty("loc.img.hero"));
			seleniumhelp.scrollPageMethod(driver,prop.getProperty("loc.tab.proddiscrip") );
			seleniumhelp.clickElement(driver,prop.getProperty("loc.tab.proddiscrip"));
			String proddiscrip=validate.textOfElement(driver, prop.getProperty("loc.tab.proddiscrip"));
			validate.assertValidater(proddiscrip,proddata[3]);
			validate.assertValidater(true, validate.containsValidater(driver, prop.getProperty("loc.proddiscrip.content") ,proddata[6]));
			seleniumhelp.clickElement(driver,prop.getProperty("loc.tab.specification"));
			String prodspecific=validate.textOfElement(driver, prop.getProperty("loc.tab.specification"));
			validate.assertValidater(prodspecific,proddata[4]);
			validate.assertValidater(true, validate.containsValidater(driver, prop.getProperty("loc.prodspecific.content"),proddata[7]));
			validate.cutomerReviewValidation(driver, prop, proddata);
	}
	
}
}
