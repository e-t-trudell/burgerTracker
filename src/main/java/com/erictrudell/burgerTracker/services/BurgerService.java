package com.erictrudell.burgerTracker.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.erictrudell.burgerTracker.models.BurgerModel;
import com.erictrudell.burgerTracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	
	@Autowired
	private BurgerRepository burgerRepo;
	
	public List<BurgerModel> getAllBurgers() {
        return burgerRepo.findAll();
    }
    // creates a book
    public BurgerModel createBurger(BurgerModel b) {
        return burgerRepo.save(b);
    }
}
