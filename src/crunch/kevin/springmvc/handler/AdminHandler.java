package crunch.kevin.springmvc.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import crunch.kevin.springmvc.dao.CustomerDao;
import crunch.kevin.springmvc.dao.OrdersDao;
import crunch.kevin.springmvc.dao.ProductDao;
import crunch.kevin.springmvc.dao.ProductlineDao;
import crunch.kevin.springmvc.javabean.Customer;
import crunch.kevin.springmvc.javabean.CustomerInfo;
import crunch.kevin.springmvc.javabean.Orders;
import crunch.kevin.springmvc.javabean.Product;
import crunch.kevin.springmvc.javabean.ProductLine;

@Controller
@RequestMapping("admin")
public class AdminHandler {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"SpringConfig.xml");
	CustomerDao cd = (CustomerDao)context.getBean("CustomerDao");
	ProductDao pd = (ProductDao)context.getBean("ProductDao");
	ProductlineDao pld = (ProductlineDao)context.getBean("ProductlineDao");
	OrdersDao od = (OrdersDao)context.getBean("OrdersDao");
	
	public AdminHandler() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("user")
	public ModelAndView User(){
		ModelAndView mv = new ModelAndView("/admin/user");
		List<CustomerInfo> lc = new ArrayList<>();
		lc=cd.getAllCustomerInfo();
		mv.addObject("lc", lc);
		return mv;
	}

	@RequestMapping("product")
	public ModelAndView Products(){
		ModelAndView mv = new ModelAndView("/admin/product");
		List<Product> lc = new ArrayList<>();
		lc=pd.getAllProducts();
		mv.addObject("lc", lc);
		return mv;
	}

	@RequestMapping("productline")
	public ModelAndView Productline(){
		ModelAndView mv = new ModelAndView("/admin/productline");
		List<ProductLine> lc = new ArrayList<>();
		lc=pld.getAllProductLine();
		mv.addObject("lc", lc);
		return mv;
	}

	@RequestMapping("order")
	public ModelAndView Order(){
		ModelAndView mv = new ModelAndView("/admin/order");
		List<Orders> lc = new ArrayList<>();
		lc=od.getAllOrder();
		mv.addObject("lc", lc);
		return mv;
	}
}
