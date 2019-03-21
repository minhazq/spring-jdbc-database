package tacos.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//In Spring Repository means DAO class.
//@Repository annotation will tell spring to load and initialize this class for DAO
@Repository
public class IngredientRepositoryImpl implements IngredientRepository{

	private JdbcTemplate jdbcTemplate;
	
	//This Autowire means that Spring will create this object using constructor injecetion.
	//Spring will inject the DataSource using the following constructor argument .
	//You have to define the DataSource in context.xml or @configuration appConfig class.
	@Autowired
	public IngredientRepositoryImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Iterable<Ingredient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Ingredient findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Ingredient save(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return null;
	}

}
