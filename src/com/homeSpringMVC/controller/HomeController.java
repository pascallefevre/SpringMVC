package com.homeSpringMVC.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.homeSpringMVC.dao.ProductDao;
import com.homeSpringMVC.domain.Product;



@Controller
public class HomeController 
{
	
	@RequestMapping (value = "/home", method=RequestMethod.GET)
	public  String homePagePathGet()
	{
		
		return "home";//"home.jsp"
	}
	

	@RequestMapping (value = "/login", method=RequestMethod.GET)
	public  String loginPagePathGet()
	{
		
		return "login";//".jsp"
	}
	
	@RequestMapping (value = "/login", method=RequestMethod.POST)
	public  String loginPagePathPost(Model model, 
			HttpServletRequest request,
			@RequestParam(value="inlogin", required=false, defaultValue="") String log,
			@RequestParam(value="inpw", required=false, defaultValue="") 	String pwd)
	{
		
		if (log.equals("root") && pwd.equals("root"))
		{
			HttpSession session = request.getSession();
			List<Product> cart = new ArrayList<Product>();
			session.setAttribute("cart", cart);
			session.setAttribute("name", log);
		
			
			
			return "redirect: shop";//".jsp"
		}
		else 
			return "redirect: login";//".jsp"
		
	}
	
	@RequestMapping (value = "/shop", method=RequestMethod.GET)
	public  String shopPagePathGet(Model model, 
			HttpServletRequest httpSession)
	{
		
		
		if ( httpSession.getSession().getAttribute("cart") != null ) {
			ProductDao pdao  = new ProductDao();
			
			model.addAttribute("inventaire", pdao.findAll());
			return "shop";//".jsp"
		}
		
		
		return "redirect: login";
	}
	
	@RequestMapping (value = "/cart/add/{p.id}", method=RequestMethod.GET)
	public  String cartPagePathAddGet(Model model, 
			HttpServletRequest request, @PathVariable(name="p.id") int pid)
	{
		ProductDao pdao = new ProductDao();
		HttpSession session = request.getSession();
		Product p =pdao.findOne(pid);
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		cart.add(p);
		session.setAttribute("cart", cart);
		model.addAttribute("inventaire", pdao.findAll());
			return "shop";//".jsp"
		
	}
	
	@RequestMapping (value = "/cart/rm/{p.id}", method=RequestMethod.GET)
	public  String cartPagePathRmGet(Model model, 
			HttpServletRequest request ,@PathVariable(name="p.id") int pid)
	{
		ProductDao pdao = new ProductDao();
		
		if (pdao.findOne(pid)!= null) {
		Product p =pdao.findOne(pid);
		HttpSession session = request.getSession();
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		cart.remove(p);
		session.setAttribute("cart", cart);
		}
			
		model.addAttribute("inventaire", pdao.findAll());
		return "shop";//".jsp"
	
	}
	
	@RequestMapping (value = "/cart/show", method=RequestMethod.GET)
	public  String cartPagePathShowGet(Model model, 
			HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		
		model.addAttribute("cart" , cart);
		return "cart";//".jsp"
	
	}
	
}
