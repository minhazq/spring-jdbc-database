package tacos.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.mysql.cj.jdbc.Driver;

@Configuration
@ComponentScan
//With Spring, we use the @ComponentScan annotation along with @Configuration annotation to specify the packages that we want to be scanned. 
//@ComponentScan without arguments tells Spring to scan the current package and all of its sub-packages.
public class DatabaseConfig {

	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
		simpleDriverDataSource.setDriverClass(Driver.class); //om.mysql.cj.jdbc.Driver
		simpleDriverDataSource.setUrl("localhost:3306");
		simpleDriverDataSource.setUsername("root");
		simpleDriverDataSource.setPassword("passowrd");
		return simpleDriverDataSource;
	}
	
	/*@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:db/schema.sql")
			.addScript("classpath:db/test-data.sql").build();
	}*/
	
	public DataSourceInitializer dataSourceInitializer ( final DataSource dataSource) {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator());
		return initializer;
	}
	
	//import org.springframework.core.io.Resource;
	
	@Value("classpath:db/schema.sql")
	private Resource schemaScript;
	
	@Value("classpath:db/test-data.sql")
	private Resource dataScript;
	
	
	public DatabasePopulator databasePopulator() {
		final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(schemaScript);
		populator.addScript(dataScript);
		return populator;
	}
}
