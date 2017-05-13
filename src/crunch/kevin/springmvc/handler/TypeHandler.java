package crunch.kevin.springmvc.handler;

import java.util.ArrayList;
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
import crunch.kevin.springmvc.dao.ProductDao;
import crunch.kevin.springmvc.dao.ProductlineDao;
import crunch.kevin.springmvc.javabean.Customer;
import crunch.kevin.springmvc.javabean.Product;
import crunch.kevin.springmvc.javabean.ProductCount;
import crunch.kevin.springmvc.javabean.ProductLine;
import crunch.kevin.springmvc.utils.Util;

@Controller
@RequestMapping(value = "/type")
public class TypeHandler {
	
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"SpringConfig.xml");
	ProductDao pd = (ProductDao) context.getBean("ProductDao");
	ProductlineDao pld = (ProductlineDao) context.getBean("ProductlineDao");
	CustomerDao cd = (CustomerDao) context.getBean("CustomerDao");
	CartDao cad = (CartDao) context.getBean("CartDao");

	private ProductCount pc = new ProductCount();
	
	public TypeHandler() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/classiccars")
	public ModelAndView toClassicCar(@ModelAttribute("user") Customer user) {
		ModelAndView mv = new ModelAndView("/client/classicCars");
		List<Product> lp = new ArrayList<>();
		lp=pd.searchProductsbyTypes("Classic Cars");
		ProductLine line = new ProductLine();
		line=pld.getProductLinebyName("Classic Cars");
		
		int number = cd.getCustomerbyName(user.getName()).getCustomerNumber();
		Map<String, Double> map = cad.getItemPricebyCustomerNumber(number);
		int count = map.get("count").intValue();
		mv.addObject("cartitem", count);
		mv.addObject("cartprice", Util.DoubleFormat(map.get("price")));
		mv.addObject("pc",pc);
		mv.addObject("line",line);
		mv.addObject("lp", lp);
		return mv;
	}

	@RequestMapping(value = "/vintagecars")
	public ModelAndView toVintageCar(@ModelAttribute("user") Customer user) {
		ModelAndView mv = new ModelAndView("/client/vintagecars");
		List<Product> lp = new ArrayList<>();
		lp=pd.searchProductsbyTypes("Vintage Cars");
		ProductLine line = new ProductLine();
		line=pld.getProductLinebyName("Vintage Cars");
		
		int number = cd.getCustomerbyName(user.getName()).getCustomerNumber();
		Map<String, Double> map = cad.getItemPricebyCustomerNumber(number);
		int count = map.get("count").intValue();
		mv.addObject("cartitem", count);
		mv.addObject("cartprice", Util.DoubleFormat(map.get("price")));
		
		mv.addObject("pc",pc);
		mv.addObject("line",line);
		mv.addObject("lp", lp);
		return mv;
	}

	@RequestMapping(value = "/motorcycles")
	public ModelAndView toMotorcycles(@ModelAttribute("user") Customer user) {
		ModelAndView mv = new ModelAndView("/client/motorcycle");
		List<Product> lp = new ArrayList<>();
		lp=pd.searchProductsbyTypes("Motorcycles");
		ProductLine line = new ProductLine();
		line=pld.getProductLinebyName("Motorcycles");
		
		int number = cd.getCustomerbyName(user.getName()).getCustomerNumber();
		Map<String, Double> map = cad.getItemPricebyCustomerNumber(number);
		int count = map.get("count").intValue();
		mv.addObject("cartitem", count);
		mv.addObject("cartprice", Util.DoubleFormat(map.get("price")));
		mv.addObject("pc",pc);
		mv.addObject("line",line);
		mv.addObject("lp", lp);
		return mv;
	}

	@RequestMapping(value = "/ships")
	public ModelAndView toShips(@ModelAttribute("user") Customer user) {
		ModelAndView mv = new ModelAndView("/client/ships");
		List<Product> lp = new ArrayList<>();
		lp=pd.searchProductsbyTypes("Ships");
		ProductLine line = new ProductLine();
		line=pld.getProductLinebyName("Ships");
		
		int number = cd.getCustomerbyName(user.getName()).getCustomerNumber();
		Map<String, Double> map = cad.getItemPricebyCustomerNumber(number);
		int count = map.get("count").intValue();
		mv.addObject("cartitem", count);
		mv.addObject("cartprice", Util.DoubleFormat(map.get("price")));
		mv.addObject("pc",pc);
		mv.addObject("line",line);
		mv.addObject("lp", lp);
		return mv;
	}

	@RequestMapping(value = "/boats")
	public ModelAndView toBoats(@ModelAttribute("user") Customer user) {
		ModelAndView mv = new ModelAndView("/client/boats");
		List<Product> lp = new ArrayList<>();
		lp=pd.searchProductsbyTypes("Boats");
		ProductLine line = new ProductLine();
		line=pld.getProductLinebyName("Boats");
		
		int number = cd.getCustomerbyName(user.getName()).getCustomerNumber();
		Map<String, Double> map = cad.getItemPricebyCustomerNumber(number);
		int count = map.get("count").intValue();
		mv.addObject("cartitem", count);
		mv.addObject("cartprice", Util.DoubleFormat(map.get("price")));
		mv.addObject("pc",pc);
		mv.addObject("line",line);
		mv.addObject("lp", lp);
		return mv;
	}

	@RequestMapping(value = "/trains")
	public ModelAndView toTrains(@ModelAttribute("user") Customer user) {
		ModelAndView mv = new ModelAndView("/client/trains");
		List<Product> lp = new ArrayList<>();
		lp=pd.searchProductsbyTypes("Trains");
		ProductLine line = new ProductLine();
		line=pld.getProductLinebyName("Trains");
		
		int number = cd.getCustomerbyName(user.getName()).getCustomerNumber();
		Map<String, Double> map = cad.getItemPricebyCustomerNumber(number);
		int count = map.get("count").intValue();
		mv.addObject("cartitem", count);
		mv.addObject("cartprice", Util.DoubleFormat(map.get("price")));
		mv.addObject("pc",pc);
		mv.addObject("line",line);
		mv.addObject("lp", lp);
		return mv;
	}

	@RequestMapping(value = "/truckbus")
	public ModelAndView toTrucks(@ModelAttribute("user") Customer user) {
		ModelAndView mv = new ModelAndView("/client/trucksandbuses");
		List<Product> lp = new ArrayList<>();
		lp=pd.searchProductsbyTypes("Trucks and Buses");
		ProductLine line = new ProductLine();
		line=pld.getProductLinebyName("Trucks and Buses");
		
		int number = cd.getCustomerbyName(user.getName()).getCustomerNumber();
		Map<String, Double> map = cad.getItemPricebyCustomerNumber(number);
		int count = map.get("count").intValue();
		mv.addObject("cartitem", count);
		mv.addObject("cartprice", Util.DoubleFormat(map.get("price")));
		mv.addObject("pc",pc);
		mv.addObject("line",line);
		mv.addObject("lp", lp);
		return mv;
	}

	@RequestMapping(value = "/plains")
	public ModelAndView toPlains(@ModelAttribute("user") Customer user) {
		ModelAndView mv = new ModelAndView("/client/plains");
		List<Product> lp = new ArrayList<>();
		lp=pd.searchProductsbyTypes("Planes");
		ProductLine line = new ProductLine();
		line=pld.getProductLinebyName("Planes");
		
		int number = cd.getCustomerbyName(user.getName()).getCustomerNumber();
		Map<String, Double> map = cad.getItemPricebyCustomerNumber(number);
		int count = map.get("count").intValue();
		mv.addObject("cartitem", count);
		mv.addObject("cartprice", Util.DoubleFormat(map.get("price")));
		mv.addObject("pc",pc);
		mv.addObject("line",line);
		mv.addObject("lp", lp);
		return mv;
	}
}
