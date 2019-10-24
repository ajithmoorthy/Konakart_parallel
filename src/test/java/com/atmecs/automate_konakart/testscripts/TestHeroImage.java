package com.atmecs.automate_konakart.testscripts;

import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.automate_konakart.constants.FileConstants;
import com.atmecs.automate_konakart.helper.SeleniumHelper;
import com.atmecs.automate_konakart.logreports.LogReporter;
import com.atmecs.automate_konakart.pages.HeroPage;
import com.atmecs.automate_konakart.testbase.TestBase;
import com.atmecs.automate_konakrt.utils.ExcelReader;
import com.atmecs.automate_konakrt.utils.PropertiesReader;
public class TestHeroImage extends TestBase {
	LogReporter log=new LogReporter();
	SeleniumHelper help=new SeleniumHelper();
	ExcelReader excelread=new ExcelReader();
	HeroPage hero=new HeroPage();
	PropertiesReader propread=new PropertiesReader();
	/**
	 * this method is data provider for the validate HeroImage method .
	 * this method read the value from excel and pass it to the validate konakart method  
	 *  finally @return one dimensional array.
	 * @throws IOException
	 */
	@DataProvider(name = "productdata")
	public String[][] getValidationData() throws IOException {
		String Excelarray[][] = null;
		Excelarray = excelread.excelDataProviderArray(FileConstants.PROD_TEST_DATA);
		return Excelarray;
	}
	/**
	 * this method take the parameters from data provider
	 * @param proddata
	 * and validate the hero image product description, specification,reviews using the assertion and testNG
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(priority=2,dataProvider="productdata")
	public void validateHeroImage(String[] proddata) throws IOException, InterruptedException, ParseException {
		Properties prop=propread.KeyValueLoader(FileConstants.HERO_PATH);
		logger=extentObject.startTest("Validate hero img");
		hero.validateHeropPage(driver, prop,proddata);
	}

}
