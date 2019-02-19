package fr.pizzeria.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;

import fr.pizzeria.model.Pizza;

public class PizzaDatabase implements IPizzaDao {
	
	private String url;
	private String username;
	private String password;
	
	public PizzaDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("pizzeria/pizzeria-master/src/jdbc.properties");
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.url = prop.getProperty("db.url");
		this.username = prop.getProperty("db.username");
		this.password = prop.getProperty("db.password");
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		try{	
			Connection myConnection = DriverManager
					.getConnection(url, username, password);
			Statement statement = myConnection.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT* FROM pizzas");
			ArrayList<Pizza> resultatPizza = new ArrayList<Pizza>();
			
			while (resultat.next()){
			 int id = resultat.getInt("id");
			 String code = resultat.getString("code");
			 String libellee = resultat.getString("libellee");
			 double prix = resultat.getDouble("prix");
			 Pizza pizza = new Pizza(id, code, libellee, prix);
			 resultatPizza.add(pizza);
			}
			myConnection.close();
			return resultatPizza;
			
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}	

	@Override
	public void saveNewPizza(Pizza pizza) {
		try{	
			// connection to the database 
			Connection myConnection = DriverManager
				.getConnection(url, username, password);
			
			// the query
			String query = "INSERT INTO pizzas(code, libellee, prix) VALUES (?,?,?)";
			// preparing the query
			PreparedStatement preparedstatement = (PreparedStatement) myConnection.prepareStatement(query);
			preparedstatement.executeUpdate(query);
		
		// close connection
	    myConnection.close();
		
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
