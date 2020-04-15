package demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Drawing {

	public static void main(String args[]) {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("Spring.xml");
		Triangle triangle =(Triangle)ac.getBean("triangle");
		triangle.draw();
	}
}
