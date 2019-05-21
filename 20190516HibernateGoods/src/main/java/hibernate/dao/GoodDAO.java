package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hibernate.domain.Good;

@Repository
public class GoodDAO {
	//하이버네이트 연동 객체를 자동으로 주입
	@Autowired
	private SessionFactory sessionFactory;
	
	//데이터를 삽입하는 메소드
	@Transactional // 하이버네이트는 
	public void insertGood(Good good) {
		//Hibernate 작업을 위한 세션 가져오기
		Session session =
				sessionFactory.getCurrentSession();
		//데이터 삽입
		session.save(good);
	}
	
	//전체 데이터를 가져오는 메소드
	@Transactional
	public List<Good> listGood(){
		/*
		List<Good> list = (List<Good>)
				sessionFactory.getCurrentSession()
				.createCriteria(Good.class).list();
		*/
		//sql을 이용한 방법
		List<Good> list = (List<Good>)
				sessionFactory.getCurrentSession()
				.createSQLQuery("select * from goods")
				.addEntity(Good.class).list();

		return list;
	}
	
	@Transactional
	public Good get(int code) {
		Good good = sessionFactory.getCurrentSession().
				get(Good.class, code);
		return good;
	}


}
