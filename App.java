package com.nikunj.Demohibernate;




import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import org.hibernate.Transaction;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	FileReader fr = new FileReader("Demo.csv");
    	BufferedReader br = new BufferedReader(fr);
    	Alien a = new Alien();
    	Session session = null;
    	String str=null;
    	while((str=br.readLine())!=null)
    	{
    		String[] str1= str.split(",");
    		   a.setName(str1[0]);
    	       a.setFname(str1[1]);
    	       a.setLname(str1[2]);
    	       Configuration  con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
    	        SessionFactory sf = con.buildSessionFactory();
    	        
    	       session  = sf.openSession();
    	        
    	       Transaction tx = session.beginTransaction();
    	       session.save(a);
    	       
    	       tx.commit();
    	                	
    	}
//        a = (Alien) session.get(Alien.class, "a1");  
//        System.out.println(a.getFname()+" "+a.getLname()+" " +a.getName());
Query query = session.createQuery("from Alien");

	List<Alien> aliens = query.list();
	for(Alien x:aliens)
	{
		System.out.println(x);
	}
//    	System.out.println(query);
    }
}
