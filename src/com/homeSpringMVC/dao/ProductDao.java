package com.homeSpringMVC.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.homeSpringMVC.domain.Product;

public class ProductDao {
	
	private List<Product> products = new ArrayList<Product>(Arrays.asList(
			new Product(1, "Farine de blé complète (T110)", 10.30, 5),
			new Product(2, "Caramelolait BIO, pot 300g", 2.65, 2),
			new Product(3, "Le Bleu de Briola BIO, portion 250g", 5.50, 1),
			new Product(4, "La Faisselle BIO, pot 225g", 1.70, 6),
			new Product(5, "Pâtes CAMPANELLE 500g (petit épeautre)", 8.00, 8),
			new Product(6, "Pâtes MAFALDINE 500g (sarrasin)", 8.00, 10)));
	
	
	public List<Product> findAll() {
		return this.products;
	}
	
	public Product findOne(int id) {
		return this.products.stream().filter(p -> p.getId() == id).findFirst().get();
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
