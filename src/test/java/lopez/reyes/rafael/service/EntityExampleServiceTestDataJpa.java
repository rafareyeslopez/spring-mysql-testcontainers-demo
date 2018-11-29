/**
 *
 */
package lopez.reyes.rafael.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;

import lopez.reyes.rafael.model.EntityExample;
import lopez.reyes.rafael.repository.EntityExampleRepository;

/**
 * @author Rafael Reyes Lopez
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("junit")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ContextConfiguration(initializers = { EntityExampleServiceTestDataJpa.Initializer.class })
//@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class })
public class EntityExampleServiceTestDataJpa {

	private static MySQLContainer mysql;
	private static DataSource dataSource;

	@Autowired
	private EntityExampleRepository repository;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mysql = (MySQLContainer) new MySQLContainer().withInitScript("init_mysql.sql").withDatabaseName("rafa")
				.withUsername("rafa").withPassword("rafa");
		mysql.start();
		dataSource = DataSourceBuilder.create().url(mysql.getJdbcUrl()).username(mysql.getUsername())
				.password(mysql.getPassword()).driverClassName("com.mysql.cj.jdbc.Driver").build();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		mysql.stop();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link lopez.reyes.rafael.service.EntityExampleService#exampleMethod(java.lang.String)}.
	 */
	@Test
	public final void testExampleMethod() {

		final EntityExample entityExample = new EntityExample(1l, "Test", 0);

		final EntityExample savedEntityExample = repository.save(entityExample);

		final Optional<EntityExample> findByIdEntityExample = repository.findById(savedEntityExample.getId());

		assertEquals(savedEntityExample, findByIdEntityExample.get());

	}

	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		@Override
		public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
			TestPropertyValues
					.of("spring.datasource.url=" + mysql.getJdbcUrl(),
							"spring.datasource.username=" + mysql.getUsername(),
							"spring.datasource.password=" + mysql.getPassword())
					.applyTo(configurableApplicationContext.getEnvironment());
		}

	}

}
