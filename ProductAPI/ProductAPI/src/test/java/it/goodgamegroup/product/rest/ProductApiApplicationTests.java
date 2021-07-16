package it.goodgamegroup.product.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import it.goodgamegroup.product.rest.entities.Product;

@SpringBootTest
class ProductApiApplicationTests {

	@Value("${productserviceapi.services.url}")
	private String baseURL;
	
	@Test
	void testGetProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product p = restTemplate.getForObject(baseURL+"/2", Product.class);
		assertNotNull(p);
		assertEquals("iPhoneXX", p.getName());
	}

	@Test
	void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product p = new Product();
		p.setName("Nome");
		p.setDescription("DescrizioneTest");
		p.setPrice(0);
		Product p1 = restTemplate.postForObject(baseURL,p,Product.class);
		assertNotNull(p1);
		assertEquals("Nome", p1.getName());
	}
	
	@Test
	void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product p = restTemplate.getForObject(baseURL+"/2",Product.class);
		p.setPrice(1);
		restTemplate.put(baseURL, p);
	}
}
