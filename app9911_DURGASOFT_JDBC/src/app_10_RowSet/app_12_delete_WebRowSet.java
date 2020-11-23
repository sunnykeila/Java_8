package app_10_RowSet;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class app_12_delete_WebRowSet {

	public static void main(String[] args)throws Exception {

		
         RowSetFactory rsf = RowSetProvider.newFactory();
		
		WebRowSet wrs = rsf.createWebRowSet();
		wrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		wrs.setUsername("Bunny");
		wrs.setPassword("123");
		wrs.setCommand("select eno,ename,esal,eaddr from employee");
		wrs.execute(); 
		
		FileReader fr = new FileReader("D:\\Extra_Space_For_FOS_2\\webRowSet_xml\\abc.xml");
		wrs.readXml(fr);
		
		
		wrs.acceptChanges();
		
		System.out.println("employee data inserted succesfully");
		
		fr.close();
		wrs.close();
	}

}