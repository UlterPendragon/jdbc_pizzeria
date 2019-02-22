package fr.pizzeria.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.dao.*;
import fr.pizzeria.model.*;


public class PizzaMemDaoTest {
	PizzaMemDao pizzaMemDao;

	@Test
	public void testfindAllPizza() {
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		List<Pizza> listepizza = pizzaMemDao.findAllPizzas();

		Assert.assertTrue(listepizza != null);
	}

	@Test
	public void testsaveNewPizza() {
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		Pizza maPizza = new Pizza(100, "ALAB", "Alabama", 15.2);
		pizzaMemDao.saveNewPizza(maPizza);
		Assert.assertTrue(pizzaMemDao.pizzaExists("ALAB"));

	}


	@Test
	public void testupdatePizza() {

	}

	@Test
	public void testdeletePizza() {

	}

	@Test
	public void testfindPizzaByCode() {

	}
	@Test
	public void testpizzaExists() {

	}

}
