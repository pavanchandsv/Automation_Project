package LoginData;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Get_data {

	
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	
	public Get_data(String fileloc) throws Exception {
	
		workbook =new XSSFWorkbook(fileloc);
		 sheet =workbook.getSheet("Sheet1");
		 DataFormatter formatter = new DataFormatter();
		 
		
	}
	
	public int getrows(XSSFSheet sheetname) {
		return sheetname.getPhysicalNumberOfRows();
		
	}
	
	public int getcols(XSSFSheet sheetname) {
		return sheetname.getRow(0).getLastCellNum();
		
	}
	
	
	
	
	public Object[][] getArray (String filename) throws Exception
	{
		
	
		
		
		
		 DataFormatter formatter = new DataFormatter();
		 
		 int row = getrows(sheet);
			int col =getcols(sheet);
			
			
			
			Object data[][] = new Object[row-1][col];
			
			for(int i=1;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					
					Object value =formatter.formatCellValue(sheet.getRow(i).getCell(j));
					data[i-1][j]=value;
				}
			}
			
			return data;
		
	
	
}


public static void main(String[] args) throws Exception {
	String NAME="./src/main/resources/Book.xlsx";
	Get_data dr =new Get_data(NAME);
	Object[][] be=dr.getArray(NAME);


	int row = dr.getrows(sheet);
	int col =dr.getcols(sheet);
	
	
	
	for(int i=0;i<row-1;i++)
	{
		for(int j=0;j<col;j++)
		{
			System.out.print(be[i][j]+"            ");
		}
		System.out.println();
	}
	
	
	}

}
	
	