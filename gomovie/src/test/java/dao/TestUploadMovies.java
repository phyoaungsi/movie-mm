package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;

import org.junit.Test;

import com.mmdrama.dao.MovieDao;
import com.mmdrama.dao.entity.DownloadFeed;

public class TestUploadMovies extends TestCase{
	
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
		DownloadFeed df=new DownloadFeed();
		//df.download();
	}

}
