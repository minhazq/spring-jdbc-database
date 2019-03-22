package tacos.data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

//In Spring Repository means DAO class.
//@Repository annotation will tell spring to load and initialize this class for DAO
@Repository
public class IngredientRepositoryImpl implements IngredientRepository{

	//JdbcOperations is an interface and the implementation of that interface
	// is JdbcTemplate. This is useful option to enhance testability, as it can easily be mocked or stubbed.
	private JdbcOperations jdbcTemplate;
	
	//This Autowired means that Spring will create this object using constructor injection.
	//Spring will inject the DataSource object in constructor.
	//You have to define the DataSource bean in context.xml or @configuration appConfig class
	@Autowired
	public IngredientRepositoryImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Iterable<Ingredient> findAll() {
		jdbcTemplate.query("select * from ingredient", new RowMapper<Coffee>() {

			//When the cursor will come to a new row it will be executed. So you will get a brand new Coffee object
			//with new row data. Thats how you map the sql query to your object
			public Coffee mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Coffee(rs.getString("coffeetype"),rs.getString("milktype"),rs.getInt("sugerquantity"));
			}
		});
		return null; // if nothing found then null will be returned
	}

	public Ingredient findOne(String id) {
		jdbcTemplate.query("select * from ingredient where coffeetype=?",new Object[] { id }, new ResultSetExtractor<Coffee>() {

			public Coffee extractData(ResultSet rs) throws SQLException, DataAccessException {
				// You will get all the result and now you sort them out.
				return null;
			}
		});
		return null;
	}

	public Ingredient save(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Integer findIdByUserName(String userName) {
		return jdbcTemplate.queryForObject("select * from ingredient where coffeetype=?", new Object[] {userName},Integer.class);
	}
	
	
	//You have to inject NamedParameterJdbcOperations instead of JdbcOperations
	// NamedParaterJdbcOperations is an interface and implementation  class is NamedParameterJdbc
	//JdbcOperations is an interface and implementation class is JdbcTemplate
	private NamedParameterJdbcOperations namedParameterJdbcTemplate;
	
	public Coffee findById(Long id) {
		
		String sql = "select * from ingredient where id= :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return namedParameterJdbcTemplate.queryForObject(sql, params,new RowMapper<Coffee>() {

			public Coffee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}

}
