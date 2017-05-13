package crunch.kevin.springmvc.handler;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import crunch.kevin.springmvc.dao.CartDao;
import crunch.kevin.springmvc.dao.CustomerDao;
import crunch.kevin.springmvc.dao.OrdersDao;
import crunch.kevin.springmvc.dao.ProductDao;
import crunch.kevin.springmvc.javabean.Cart;
import crunch.kevin.springmvc.javabean.Customer;
import crunch.kevin.springmvc.javabean.CustomerInfo;
import crunch.kevin.springmvc.javabean.LoginUser;
import crunch.kevin.springmvc.javabean.Orders;
import crunch.kevin.springmvc.javabean.Product;
import crunch.kevin.springmvc.javabean.ProductCount;
import crunch.kevin.springmvc.utils.Util;

@Controller
public class Helloworld {
	private ProductCount pc = new ProductCount();
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"SpringConfig.xml");
	ProductDao pd = (ProductDao) context.getBean("ProductDao");
	CustomerDao cd = (CustomerDao) context.getBean("CustomerDao");
	CartDao cad = (CartDao) context.getBean("CartDao");
	OrdersDao od = (OrdersDao) context.getBean("OrdersDao");

	@RequestMapping("/helloworld")
	public ModelAndView hello(@ModelAttribute("user") LoginUser user) {
		System.out.println("hello world" + user.getName());
		int c = cd.checklogin(user);
		if (c==2){
			ModelAndView mv = new ModelAndView("/admin/index");
			List<Orders> lo = od.getOrdersbyStatus("Unpaid");
			mv.addObject("lo", lo);
			return mv;
		}
		else if(c==1){
			ModelAndView mv = new ModelAndView("/client/index");
			List<Product> lp = pd.getRandomProducts();
			mv.addObject("pc", pc);
			mv.addObject("lp", lp);

			List<Product> lp1 = pd.getProductsforIndex("Classic Cars");
			List<Product> lp2 = pd.getProductsforIndex("Motorcycles");
			List<Product> lp3 = pd.getProductsforIndex("Planes");
			List<Product> lp4 = pd.getProductsforIndex("Vintage Cars");
			mv.addObject("lp1", lp1);
			mv.addObject("lp2", lp2);
			mv.addObject("lp3", lp3);
			mv.addObject("lp4", lp4);
			
			int number = cd.getCustomerbyName(user.getName()).getCustomerNumber();
			Map<String, Double> map = cad.getItemPricebyCustomerNumber(number);

			int count = map.get("count").intValue();
			mv.addObject("cartitem", count);
			mv.addObject("cartprice", Util.DoubleFormat(map.get("price")));
			return mv;
		}else{
			ModelAndView mv = new ModelAndView("forward:index.jsp");
			return mv;
		}
	}
	
	@RequestMapping("/helloworld2")
	public ModelAndView hello2(@ModelAttribute("user") LoginUser u) {
		String user = u.getName();
		int c = cd.checkloginUser(user);
		System.out.println("c:"+c);
		if (c==2){
			ModelAndView mv = new ModelAndView("/admin/index");
			List<Orders> lo = od.getOrdersbyStatus("Unpaid");
			mv.addObject("lo", lo);
			return mv;
		}
		else if(c==1){
			ModelAndView mv = new ModelAndView("/client/index");
			List<Product> lp = pd.getRandomProducts();
			mv.addObject("pc", pc);
			mv.addObject("lp", lp);
			
			int number = cd.getCustomerbyName(user).getCustomerNumber();
			Map<String, Double> map = cad.getItemPricebyCustomerNumber(number);

			int count = map.get("count").intValue();
			mv.addObject("cartitem", count);
			mv.addObject("cartprice", Util.DoubleFormat(map.get("price")));
			return mv;
		}else{
			ModelAndView mv = new ModelAndView("forward:index.jsp");
			return mv;
		}
	}
}