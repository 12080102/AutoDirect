package crunch.kevin.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import crunch.kevin.springmvc.javabean.Customer;

@Controller
public class Helloworld {

	@RequestMapping("/helloworld")
	public String hello(@ModelAttribute("user") Customer user) {
		System.out.println("hello world" + user.getName());
		if ("admin".equals(user.getName()))
			return "admin/index";
		else
			return "client/index";
	}
}