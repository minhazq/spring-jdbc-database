package org.spring.database.spring_database;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tacos.data.DatabaseConfig;
import tacos.data.IngredientRepository;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DatabaseConfig.class) // you must decleare it in your Test Class
public class AppTest {
    
	@Autowired
	private IngredientRepository repository;
	
	@org.junit.Test
	public void test1() {
		repository.findAll();
		
	}
}
