package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entites.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/orm-config.xml");
        StudentDao studentDao = context.getBean("studentDao" ,StudentDao.class);
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean go = true;
        while(go) {
        	
        	System.out.println("Press 1 : to Add student detail");
        	System.out.println("Press 2 : to get a student detail");
        	System.out.println("Press 3 : to get all student detail");
        	System.out.println("Press 4 : to update student detail");
        	System.out.println("Press 5 : to delete student detail");
        	System.out.println("Press 6 : to exit student detail");
        	
        	try {
        		int input = Integer.parseInt(br.readLine());
        		
        		switch (input) {
				case 1:
					Student student = new Student(44 , "Raju " , "Siwan");  
					int r = studentDao.insert(student); 
					System.out.println("done " + r); 
					break;
					
				case 2:
					Student student1 = studentDao.getStudent(44);
					System.out.println(student1);
					break;
					
				case 3:
					List<Student> getAll = studentDao.getAll();
					System.out.println(getAll);
					break;
					
				case 4:
					studentDao.updateStudent(null);
					break;
					
				case 5:
					Student deleteStudent = studentDao.deleteStudent(44);
					System.out.println(deleteStudent);
					break;

				case 6:
					go = false;
					break;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Invalide input u have enter : ");
			}
        	
        	
        	
        
        	
        }
        
        System.out.println("Thank you ! Your work is done !");
        
     
       
        
        
     
    }
}
