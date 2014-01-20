package com.gmind7.bakery.config;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@TransactionConfiguration(defaultRollback = true)
@ActiveProfiles("loc")
public abstract class AbstractIntegrationTest {

	@Resource(name="defaultDatasource")
	public org.apache.tomcat.jdbc.pool.DataSource defaultDatasource;

//	@Before
//	public void 테스트데이터생성() throws SQLException {
//		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//		populator.addScript(new ClassPathResource("src/test/resources/init/data.sql"));
//		Connection connection = defaultDatasource.getConnection();
//		populator.populate(connection);
//	}
}
