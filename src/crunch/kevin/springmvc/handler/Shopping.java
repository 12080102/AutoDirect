package crunch.kevin.springmvc.handler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import crunch.kevin.springmvc.dao.OrderDetailDao;
import crunch.kevin.springmvc.dao.OrdersDao;
import crunch.kevin.springmvc.dao.ProductDao;
import crunch.kevin.springmvc.javabean.Cart;
import crunch.kevin.springmvc.javabean.CartProduct;
import crunch.kevin.springmvc.javabean.Customer;
import crunch.kevin.springmvc.javabean.OrderDetails;
import crunch.kevin.springmvc.javabean.Orders;
import crunch.kevin.springmvc.javabean.Product;
import crunch.kevin.springmvc.javabean.ProductCount;
import crunch.kevin.springmvc.javabean.ProductList;
import crunch.kevin.springmvc.utils.Util;

@Controller
@RequestMapping(value = "/shopping")
public class Shopping {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"SpringConfig.xml");
	ProductDao pd = (ProductDao) context.getBean("ProductDao");
	CustomerDao cd = (CustomerDao) context.getBean("CustomerDao");
	CartDao cad = (CartDao) context.getBean("CartDao");
	OrdersDao od = (OrdersDao) context.getBean("OrdersDao");
	OrderDetailDao odd = (OrderDetailDao) context.getBean("OrderDetailDao");
	private ProductCount pc = new ProductCount();

	@RequestMapping(value = "/getall")
	public ModelAndView renderTable(@ModelAttribute("user") Customer user) {
		ModelAndView mv = new ModelAndView("/shopping");
		ProductList lp = new ProductList();
		lp.setListProduct(pd.getAllProducts());
		// lp.setListProduct(pd.getPagedProducts(start,totle));
		mv.addObject("lp", lp.getListProduct());
		return mv;
	}

	@RequestMapping(value = "/gettype")
	public ModelAndView getType(@ModelAttribute("user") Customer user,
			@ModelAttribute("type") String type) {
		ModelAndView mv = new ModelAndView("/shopping");
		ProductList lp = new ProductList();
		System.out.println("type: " + type);
		lp.setListProduct(pd.searchProductsbyTypes(type));
		mv.addObject("lp", lp.getListProduct());
		return mv;
	}

	@RequestMapping(value = "/getdetail")
	public ModelAndView getDetail(@ModelAttribute("user") Customer user,
			@ModelAttribute("code") String code) {
		ModelAndView mv = new ModelAndView("/client/product_details");
		Product lp = new Product();
		System.out.println("code: " + code + "," + user.getName());
		lp = pd.getProductbyCode(code);
		List<Product> lc = new ArrayList<>();
		switch (lp.getProductLine()) {
		case "Boats":
			lc = pd.searchProductsbyTypes("Boats");
			break;
		case "Classic Cars":
			lc = pd.searchProductsbyTypes("Classic Cars");
			break;
		case "Motorcycles":
			lc = pd.searchProductsbyTypes("Motorcycles");
			break;
		case "Planes":
			lc = pd.searchProductsbyTypes("Planes");
			break;
		case "Ships":
			lc = pd.searchProductsbyTypes("Ships");
			break;
		case "Trains":
			lc = pd.searchProductsbyTypes("Trains");
			break;
		case "Trucks and Buses":
			lc = pd.searchProductsbyTypes("Trucks and Buses");
			break;
		case "Vintage Cars":
			lc = pd.searchProductsbyTypes("Vintage Cars");
			break;
		default:
			lc = pd.getAllProducts();
			break;
		}
		int number = cd.getCustomerbyName(user.getName()).getCustomerNumber();
		Map<String, Double> map = cad.getItemPricebyCustomerNumber(number);
		int count = map.get("count").intValue();
		mv.addObject("cartitem", count);
		mv.addObject("cartprice", Util.DoubleFormat(map.get("price")));

		mv.addObject("pc", pc);
		mv.addObject("lc", lc);
		mv.addObject("lp", lp);
		return mv;
	}

	@RequestMapping(value = "/addcart")
	public ModelAndView addCart(@ModelAttribute("qty") int qty,
			@ModelAttribute("code") String code,
			@ModelAttribute("user") String user) {
		ModelAndView mv = new ModelAndView("forward:/shopping/checkcart?user="
				+ user);
		Cart c = new Cart();
		c.setProductNumberList(code);
		Product p = pd.getProductbyCode(code);
		c.setPrice(Double.parseDouble(p.getBuyPrice()));
		c.setProductCount(qty);
		Customer cuc = cd.getCustomerbyName(user);
		c.setCustomerNumber(cuc.getCustomerNumber());
		cad.newCart(c);
		return mv;
	}

	@RequestMapping(value = "/checkcart")
	public ModelAndView checkCart(@ModelAttribute("user") String user) {
		ModelAndView mv = new ModelAndView("/client/product_summary");

		int number = cd.getCustomerbyName(user).getCustomerNumber();
		List<Cart> lc = cad.getCartbyCustomerNumber(number);
System.out.println(user+number);
		Map<String, Double> map = cad.getItemPricebyCustomerNumber(number);

		List<CartProduct> lp = new ArrayList<>();
		for (Cart s : lc) {
			CartProduct cp = new CartProduct();
			Product p = pd.getProductbyCode(s.getProductNumberList());
			cp.setBuyPrice(s.getPrice());
			cp.setMSRP(Double.parseDouble(p.getMSRP()));
			cp.setPicurl(p.getPicurl());
			cp.setProductDescription(p.getProductDescription());
			cp.setProductName(p.getProductName());
			cp.setQuantity(s.getProductCount());
			cp.setCartCode(s.getCartCode());
			cp.setDiscount(Util.DoubleFormat(cp.getMSRP() - cp.getBuyPrice()));
			cp.setTotle(Util.DoubleFormat(cp.getBuyPrice() * cp.getQuantity()));
			lp.add(cp);
		}

		int count = map.get("count").intValue();
		mv.addObject("cartitem", count);
		mv.addObject("cartprice", Util.DoubleFormat(map.get("price")));

		mv.addObject("pc", pc);
		mv.addObject("lp", lp);
		System.out.println("/checkcart");
		return mv;
	}

	@RequestMapping(value = "/cartdelete")
	public ModelAndView cartDelete(@ModelAttribute("user") String user,
			@ModelAttribute("code") int code) {
		ModelAndView mv = new ModelAndView("forward:/shopping/checkcart?user="
				+ user);
		System.out.println("/cartdelete "+user);
		cad.delectCart(code);
		return mv;
	}

	@RequestMapping(value = "/checkout")
	public ModelAndView checkOut(@ModelAttribute("user") String user,@ModelAttribute("deliverdate") String requiredDate) {
		ModelAndView mv = new ModelAndView("forward:/helloworld2?name="+user);
		System.out.println(user+requiredDate);
		int number = cd.getCustomerbyName(user).getCustomerNumber();
		System.out.println(number);
		List<Cart> lc = cad.getCartbyCustomerNumber(number);
		for (Cart c : lc) {
			Orders o = new Orders();
			OrderDetails od = new OrderDetails();
			Product p = pd.getProductbyCode(c.getProductNumberList());
			Double oln = Math.random()*12;
			od.setOrderLineNumber(oln.intValue());
			od.setProductCode(p.getProductCode());
			od.setQuantityOrdered(c.getProductCount());
			od.setPriceEach(c.getPrice());
			o.setCustomerNumber(number);
			o.setOrderDate(new Date());
			o.setStatus("Unpaid");
			o.setRequiredDate(Util.stringToDate(requiredDate));
			od.setOrderNumber(this.od.newOrder(o));
			cad.delectCart(c.getCartCode());
			odd.newOrderDetail(od);
		}
		return mv;
	}

}
