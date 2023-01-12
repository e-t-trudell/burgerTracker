package com.erictrudell.burgerTracker.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erictrudell.burgerTracker.models.BurgerModel;
import com.erictrudell.burgerTracker.services.BurgerService;

@Controller
@RequestMapping("/burger")
public class BurgerController {
	
	@Autowired
	private BurgerService burgerServ;


	@PostMapping("/create")
//	bind results catches all results of using the validation here against the binded model attribute
	public String create(@Valid @ModelAttribute("burgers") BurgerModel burger, BindingResult result) {
		if(result.hasErrors()) {
			return"index.jsp";
		}else {
			burgerServ.createBurger(burger);
			return "redirect:/home";
		}
	}
	@GetMapping ("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		BurgerModel burger = burgerServ.getOneBurger(id);;
		
		model.addAttribute("burger", burger);
		return "editburger.jsp";
	}
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("burger") BurgerModel burger,
			BindingResult result) {
		if(result.hasErrors()) {
			return"/editburger.jsp";
		}else {
			burgerServ.updateBurger(burger);
			
			return"redirect:/home";
		}
	}	
}
