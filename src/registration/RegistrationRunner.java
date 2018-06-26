package registration;

import java.io.File;
import java.lang.reflect.Method;
import jxl.Sheet;
import jxl.Workbook;

public class RegistrationRunner {

	public static void main(String[] args) throws Exception 
	{
		// connect to excel file
				File f=new File("gmailRegistration.xls");
				//open excel file to read
				Workbook rwb=Workbook.getWorkbook(f);
				Sheet sh1=rwb.getSheet(0); //For Sheet number 1
				int numOfRowsInSh1=sh1.getRows();
				
				RegistrationMethods rm=new RegistrationMethods();
				//collect total number of methods in RegistrationMethods class
				Method m[]=rm.getClass().getMethods();
				
				//for loop to repeat to check conditions in sheet 1
				for(int i=1; i<numOfRowsInSh1; i++)
				{
				  String l=sh1.getCell(2, i).getContents();
				  String d=sh1.getCell(3, i).getContents();
	              String keyword=sh1.getCell(1, i).getContents();
				for(int k=0; k<m.length; k++)
				{
				  if(m[k].getName().equals(keyword))
     				{
					  
					   m[k].invoke(rm, l, d);
										
					}
				}
				
	}
				// close excel file
				rwb.close();

}
}
