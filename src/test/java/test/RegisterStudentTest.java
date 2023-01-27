package test;
/*
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class PassdataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\Jayakishore.V\\eclipse-workspace\\DataSheet.xls");
		FileInputStream fis = new FileInputStream(file);
		//Horrible Spreadsheet format for .xls format for .xlsx format file we will use xssf
		HSSFWorkbook wb =  new HSSFWorkbook(fis);
		
		HSSFSheet sh = wb.getSheetAt(0);
				
		//evaluating cell type
		
		FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();
		
		for(Row row: sh) //iteration over row using for each loop
		
		{
		
		for(Cell cell: row) //iteration over cell using for each loop
		
		{
		
		switch(formulaEvaluator.evaluateInCell(cell).getCellType())
		
		{
		
		case NUMERIC: //field that represents numeric cell type
		
		//getting the value of the cell as a number
			double retVal = cell.getNumericCellValue();
            System.out.println(retVal);
            NumberFormat nf = DecimalFormat.getInstance();
            nf.setMaximumFractionDigits(0);
            String str = nf.format(retVal);
            System.out.println(str);
            str=str.replace(",", "");
            System.out.println(str);
		//System.out.print(cell.getNumericCellValue()+ "\t\t");
		
		break;
		
		case STRING: //field that represents string cell type
		
		//getting the value of the cell as a string
		
		System.out.print(cell.getStringCellValue()+ "\t\t");
		
		break;
		
		default:
		
		break;
		
		}
		
		}
		
		System.out.println();
		
		}
		
			}
		
		}
*/
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver; 

import test.ExcelUtils;

import java.io.IOException;

import java.util.concurrent.TimeUnit;
public class RegisterStudentTest {​​​​​

    //creating object of ExcelUtils class
 
     static ExcelUtils excelUtils = new ExcelUtils();

    //using the Constants class values for excel file path 

    //static String excelFilePath =Constants.Path_TestData+Constants.File_TestData;     public static  void main(String args[]) throws IOException {​​​​​

        //set the Chrome Driver path

        System.setProperty("webdriver.chrome.driver","E:\\drivers\\NewDrivers\\chromedriver.exe");

        //Creating an object of ChromeDriver

        WebDriver driver = new ChromeDriver();

        //launching the specified URL

        driver.get("https://demoqa.com/automation-practice-form");

        //Identify the WebElements for the student registration form

        WebElement firstName=driver.findElement(By.id("firstName"));

        WebElement lastName=driver.findElement(By.id("lastName"));

        WebElement email=driver.findElement(By.id("userEmail"));

        WebElement genderMale= driver.findElement(By.id("gender-radio-1"));

        WebElement mobile=driver.findElement(By.id("userNumber"));

        WebElement address=driver.findElement(By.id("currentAddress"));

        WebElement submitBtn=driver.findElement(By.id("submit"));

        //calling the ExcelUtils class method to initialise the workbook and sheet

        excelUtils.setExcelFile("F:\\Selenium Material\\TestData.xls","Sheet1");         //iterate over all the row to print the data present in each cell.

        for(int i=1;i<=excelUtils.getRowCountInSheet();i++)

        {q
            //Enter the values read from Excel in firstname,lastname,mobile,email,address

            firstName.sendKeys(excelUtils.getCellData(i,0));

            lastName.sendKeys(excelUtils.getCellData(i,1));

            email.sendKeys(excelUtils.getCellData(i,2));

            mobile.sendKeys(excelUtils.getCellData(i,3));

            address.sendKeys(excelUtils.getCellData(i,4));

            //Click on the gender radio button using javascript

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].click();", genderMale);

            //Click on submit button

            submitBtn.click();

            //Verify the confirmation message

            WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));

            //check if confirmation message is displayed

            if (confirmationMessage.isDisplayed()) {​​​​​

                // if the message is displayed , write PASS in the excel sheet using the method of ExcelUtils

                excelUtils.setCellValue(i,6,"PASS","F:\\Selenium Material\\TestData.xls");

            }​​​​​ else {​​​​​

                //if the message is not displayed , write FAIL in the excel sheet using the method of ExcelUtils

                excelUtils.setCellValue(i,6,"FAIL","F:\\Selenium Material\\TestData.xls");

            }​​​​​             //close the confirmation popup

            WebElement closebtn=driver.findElement(By.id("closeLargeModal"));

            closebtn.click();

            //wait for page to come back to registration page after close button is clicked

            driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

        }​​​​​

        //closing the driver

        driver.quit();

    }​​​​​

}​​​​​


​​​​​



