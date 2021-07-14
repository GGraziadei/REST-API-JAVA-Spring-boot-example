package it.goodgamegroup.product.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.goodgamegroup.product.rest.entities.Product;
import it.goodgamegroup.product.rest.repositories.ProductRepository;

@RestController
public class ProductRestController {
	
	@Autowired
	ProductRepository repository;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return this.repository.findAll();
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {
		if(this.repository.findById(id).isEmpty() == false)
			return this.repository.findById(id).get();
		Product p = new Product();
		p.setId(-1);
		return p;
	}
	
	@RequestMapping(value = "/products/", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return this.repository.save(product);
	}
	
	@RequestMapping(value = "/products/", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return this.repository.save(product);
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		this.repository.deleteById(id);
	}

}
