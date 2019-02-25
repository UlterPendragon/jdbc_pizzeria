package fr.pizzeria.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.dao.*;
import fr.pizzeria.model.*;


public class PizzaMemDaoTest {
	
	PizzaMemDao pizzaMemDao = new PizzaMemDao();
	Pizza maPizza = new Pizza(100, "ALAB", "Alabama", 15.2);
	
	@Test
	public void testfindAllPizza() {
		List<Pizza> listepizza = pizzaMemDao.findAllPizzas();
		Assert.assertTrue(listepizza != null);
	}

	@Test
	public void testsaveNewPizza() {
		pizzaMemDao.saveNewPizza(maPizza);
		Assert.assertTrue(pizzaMemDao.pizzaExists("ALAB"));
	}


	@Test
	public void testupdatePizza() {
		Pizza newPizza = new Pizza(200, "ITA", "Italienne", 13.05);
		pizzaMemDao.updatePizza("IND", newPizza);
		Assert.assertTrue(pizzaMemDao.findPizzaByCode("ITA").getLibelle().equals("Italienne"));
	}

	@Test
	public void testdeletePizza() {
		Assert.assertTrue(pizzaMemDao.pizzaExists("PEP"));
		pizzaMemDao.deletePizza("PEP");
		Assert.assertFalse(pizzaMemDao.pizzaExists("PEP"));

	}

	@Test
	public void testfindPizzaByCode() {
		
	}
	@Test
	public void testpizzaExists() {

	}

}
