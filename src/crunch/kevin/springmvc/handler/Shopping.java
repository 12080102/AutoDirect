package crunch.kevin.springmvc.handler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import crunch.kevin.springmvc.dao.ProductDao;
import crunch.kevin.springmvc.javabean.Customer;
import crunch.kevin.springmvc.javabean.Product;
import crunch.kevin.springmvc.javabean.ProductList;

@Controller
@RequestMapping(value = "/shopping")
public class Shopping {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"SpringConfig.xml");
	ProductDao pd = (ProductDao) context.getBean("ProductDao");

	@RequestMapping(value = "/getall")
	public ModelAndView renderTable(@ModelAttribute("user") Customer user) {
		ModelAndView mv = new ModelAndView("/shopping");
		ProductList lp = new ProductList();
		lp.setListProduct(pd.getAllProducts());
//		lp.setListProduct(pd.getPagedProducts(start,totle));
		mv.addObject("lp", lp.getListProduct());
		return mv;
	}

	@RequestMapping(value = "/gettype")
	public ModelAndView getType(@ModelAttribute("user") Customer user,
			@ModelAttribute("type") String type) {
		ModelAndView mv = new ModelAndView("/shopping");
		ProductList lp = new ProductList();
		System.out.println("type: "+type);
		lp.setListProduct(pd.searchProductsbyTypes(type));
		mv.addObject("lp", lp.getListProduct());
		return mv;
	}

	@RequestMapping(value = "/getdetail")
	public ModelAndView getDetail(@ModelAttribute("user") Customer user,
			@ModelAttribute("code") String code) {
		ModelAndView mv = new ModelAndView("/Shopdetail");
		Product lp = new Product();
		System.out.println("code: "+code + ","+user.getName());
		lp=pd.getProductbyCode(code);
		mv.addObject("lp", lp);
		return mv;
	}
	
	@RequestMapping(value = "/getallpaged")
	public ModelAndView renderPagedTable(@ModelAttribute("user") Customer user,@ModelAttribute("start") int start,@ModelAttribute("totle") int totle) {
		ModelAndView mv = new ModelAndView("/shoppingPaged");
		int all = pd.getProductsCount("all");
		int pages = all/totle;
		ProductList lp = new ProductList();
//		lp.setListProduct(pd.getAllProducts());
		lp.setListProduct(pd.getPagedProducts(start,totle));
		mv.addObject("lp", lp.getListProduct());
		return mv;
	}

}
