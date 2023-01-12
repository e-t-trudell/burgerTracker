package com.erictrudell.burgerTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erictrudell.burgerTracker.models.BurgerModel;
import com.erictrudell.burgerTracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	
	@Autowired
	private BurgerRepository burgerRepo;
	
	public List<BurgerModel> getAllBurgers() {
        return burgerRepo.findAll();
    }
	public BurgerModel getOneBurger(Long id) {
		Optional<BurgerModel> burger = burgerRepo.findById(id);
        if (burger.empty() != null) {
        	return burger.get();
        }else {
        	return null;
        }
		
    }
    // creates a book
    public BurgerModel createBurger(BurgerModel b) {
        return burgerRepo.save(b);
    }
    public BurgerModel updateBurger(BurgerModel b) {
        return burgerRepo.save(b);
    }
}
