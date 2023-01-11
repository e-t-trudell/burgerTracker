package com.erictrudell.burgerTracker.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erictrudell.burgerTracker.models.BurgerModel;
import com.erictrudell.burgerTracker.services.BurgerService;

@Controller
@RequestMapping("/burger")
public class BurgerController {
	
	@Autowired
	private BurgerService burgerServ;

//	submitting form throws errorbecause path is not readable for burgerName
	@PostMapping("/create")
//	bind results catches all results of using the validators here against the binded model attribute
	public String create(@Valid @ModelAttribute("burgers") BurgerModel burger, BindingResult result) {
		if(result.hasErrors()) {
			return"index.jsp";
		}else {
			burgerServ.createBurger(burger);
			return "redirect:/home";
		}
	
	
	}
}
