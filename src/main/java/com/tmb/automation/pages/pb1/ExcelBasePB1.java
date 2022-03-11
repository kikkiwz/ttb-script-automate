package com.tmb.automation.pages.pb1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelBasePB1 {

	public ArrayList<String> getData(String data, String sheetName, String FileName) throws IOException {
	ArrayList<String> a=new ArrayList<String>();

	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/"+FileName);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);

	int sheets=workbook.getNumberOfSheets();
	for(int i=0; i<sheets; i++)
	{
	if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))  { 
	XSSFSheet sheet=workbook.getSheetAt(i);

	Iterator<Row>  rows= sheet.iterator();
	Row firstrow= rows.next();
	Iterator<Cell> ce=firstrow.cellIterator();
	int k=0;
	int column=0;
	while(ce.hasNext())
	{
	Cell value=ce.next();
	
	if(value.getStringCellValue().equalsIgnoreCase("FirstHeader")) //First Column header title to get data
	{
	column=k;	}
	k++; 	}

	while(rows.hasNext())
	{
	Row r=rows.next();

	if(r.getCell(column).getStringCellValue().equalsIgnoreCase(data)) 	{
	//after grab testcase row = pull all the data of that row and feed into test
	Iterator<Cell>  cv=r.cellIterator();
	while(cv.hasNext())
	{
	Cell c= cv.next();
	if(c.getCellType()==CellType.STRING)	
	{

	a.add(c.getStringCellValue());
	}
	else{
	a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

  	     }
	    }
	   }
	  }
	 }
	}
	return a;
	}

}
