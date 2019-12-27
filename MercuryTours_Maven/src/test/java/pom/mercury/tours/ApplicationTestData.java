package pom.mercury.tours;

import org.testng.annotations.DataProvider;

public class ApplicationTestData {

	@DataProvider(name="Login")
	public Object[][] getDataFromDataprovider(){
		
		return new Object[][] {
			
			{ "testing", "testing"},
			{ "dixit", "dixit"},
			{"testabhi", "testabhi"}
	};
}

	
	//This is to read Excel Data
	
@DataProvider(name="LoginDataXLS")
public Object[][] ExcelXLS() throws Exception{
	ReadXLSFile excel = new ReadXLSFile();
	Object[][] testObjArray = excel.getExcelData("C:\\Users\\user1\\Selenium_Training\\eclipse-workspace\\MercuryTours_Maven\\Login.xls", "Login");
	System.out.println(testObjArray);
	return testObjArray;
	
	}

//This is to read XLSX excel data

  @DataProvider(name = "LoginDataXLSX")
public Object[][] ExcelXLSX() throws Exception{
	  ReadXLSXFile  excel = new ReadXLSXFile();
	Object[][] testObjArray= excel.getExcelData("C:\\Users\\user1\\Selenium_Training\\eclipse-workspace\\MercuryTours_Maven\\Login.xls","Login");
	System.out.println(testObjArray);
	return testObjArray;
}
}

	/*@DataProvider(name="HDFC")
	public Object[][] getDataForHDFC(){
		
		return new Object[][] {
			
			
			
		};
	}*/
