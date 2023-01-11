package com.erictrudell.burgerTracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.erictrudell.burgerTracker.models.BurgerModel;

public interface BurgerRepository extends CrudRepository <BurgerModel, Long> {
//	create / update
	List<BurgerModel> save(String b);
//	read one or all
	List<BurgerModel> getOne(Long id);
	List<BurgerModel> findAll();
//	delete
//	List<BurgerModel> deleteByTitleStartingWith(String search);
//	List<Book> deleteById(Long id);
}

