package com.erictrudell.burgerTracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.erictrudell.burgerTracker.models.BurgerModel;
import com.erictrudell.burgerTracker.services.BurgerService;

@Controller
public class HomeController {
	
	@Autowired
	private BurgerService burgerServ;
	
//	loading landing page works
//	have @modelAttribute for form and use Model model for the display
	@GetMapping("/")
	public String index(@ModelAttribute("burgers") BurgerModel burger) {
		return"index.jsp";
	}
//	@GetMapping("/home")
//	public String home(@ModelAttribute("burgers") BurgerModel burger) {
//		
//		
//		model.addAttribute("allBurgers", allBurgers);
//		return "index.jsp";
//	}
	@GetMapping("/home")
	public String home(Model model) {
		List<BurgerModel> allBurgers = burgerServ.getAllBurgers();
		
		model.addAttribute("burgers", new BurgerModel());
		model.addAttribute("allBurgers", allBurgers);
		return "index.jsp";
	}
	
//	@GetMapping("/create")
//	public String create(@ModelAttribute("burgers") BurgerModel burger) {
//		return "index.jsp";
//	}
}
