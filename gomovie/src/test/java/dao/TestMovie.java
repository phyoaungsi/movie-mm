package dao;




import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.mmdrama.dao.MovieDao;
import com.mmdrama.dao.entity.Movie;

import junit.framework.TestCase;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 *
 * @author Steve Ebersole
 */
public class TestMovie extends TestCase {
	private EntityManagerFactory entityManagerFactory;

	@Override
	protected void setUp() throws Exception {
		// like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
		// 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
		entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	
	}

	@Override
	protected void tearDown() throws Exception {
		entityManagerFactory.close();
	}
@Test
	public void testBasicUsage() {
		//MovieDao m=new MovieDao();
		//m.createMovie();
	}
}

