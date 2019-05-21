package good.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import good.domain.Good;

//Repository 클래스의 인스턴스를 자동으로 생성 하기 위한 어노테이션
@Repository
public class GoodDAO {
	//동일한 자료형의 인스턴스를 자동으로 주입하기 위한 어노테이션
	@Autowired
	private SqlSession sqlSession;
	
	//Goods 테이블의 데이터 전체를 읽어오는 메소드
	public List<Good> allGood(){
		//good.allgood이라는 sql을 실행해서 결과를 List로 반환
		return sqlSession.selectList("good.allgood");
		
	}
}
