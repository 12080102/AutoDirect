package crunch.kevin.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import crunch.kevin.springmvc.dao.ProductDao;

public class Test {

	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"SpringConfig.xml");
	static ProductDao pd = (ProductDao) context.getBean("ProductDao");

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void getURL() {
		for (int i = 0; 1 < 37; i++)
			pd.addURl("Classic Cars", i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test.getURL();
	}

}
