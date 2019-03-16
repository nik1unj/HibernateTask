package com.nikunj.Demohibernate;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException
	{	
		FileInputStream fi = new FileInputStream(new File("Demo.xls"));
		HSSFWorkbook wb = new HSSFWorkbook(fi);
		HSSFSheet sheet = wb.getSheetAt(0);
	
		String str[] = new String[3];
		Task a = new Task();
		Session session = null;
		for (Row row : sheet)
		{
					int i = 0;
			for (Cell cell : row)
			{
					switch (cell.getCellType()) 
				{
					case Cell.CELL_TYPE_NUMERIC:
					Double in = cell.getNumericCellValue();
					str[i] = in.toString();
					break;
				
					case Cell.CELL_TYPE_STRING:
					String s = cell.getStringCellValue();
					str[i] = s;
					break;
				}
					i++;

			}
				a.setName(str[0]);
				a.setFname(str[1]);
				a.setLname(str[2]);
				
				Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Task.class);
				SessionFactory sf = con.buildSessionFactory();
			    session = sf.openSession();
			    Transaction tx = session.beginTransaction();
			    session.save(a);
			    tx.commit();
		}

			Query query = session.createQuery("from Task");
			List<Task> tasks = query.list();
			for (Task x : tasks) 
			{
				System.out.println(x);
			}		
	}
}
