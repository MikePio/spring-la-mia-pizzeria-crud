package org.java.app.db.serv;

import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// * STEP 5 PizzaService è una classe di servizio che offre metodi per eseguire operazioni CRUD sulle entità Pizza
// * PizzaService utilizza un'istanza di PizzaRepo per eseguire delle operazioni CRUD con la sorgente dati (ad esempio, un database)
@Service
public class PizzaService {

	@Autowired
	private PizzaRepo pizzaRepo;
	
	public void save(Pizza pizza) {
		pizzaRepo.save(pizza);
	}
	
	public List<Pizza> findAll() {
		return pizzaRepo.findAll();
	}
	
	public Pizza findById(int id) {
		return pizzaRepo.findById(id).get();
	}
}
