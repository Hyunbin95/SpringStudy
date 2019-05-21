package hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hibernate.domain.Sample;

@Repository
public class SampleDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Sample> getAll() {
		List<Sample> list = (List<Sample>)
				sessionFactory.getCurrentSession().createSQLQuery("select * from sample").addEntity(Sample.class).list();
		return list;
	}
	
	
	@Transactional
	public void upsert(Sample sample) {
		Session session =
				sessionFactory.getCurrentSession();
		//없는 id 이면 삽입 있는 id이면 수정
		session.saveOrUpdate(sample);
	}
	
	@Transactional
	public void delete(int code) {
		Session session =
				sessionFactory.getCurrentSession();
		Sample sample = new Sample();
		sample.setNum(code);
		System.err.println(sample);
		session.delete(sample);
	}
	
	
}
