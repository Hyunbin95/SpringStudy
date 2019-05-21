package kr.co.pk;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.pk.domain.Item;

@RunWith(SpringJUnit4ClassRunner.class)

//locations 에 설정된 Spring File을 실행
//Spring Directory에 있는 모든 XML File의 내용을 실행
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MyBatisTesting {

	// 이곳에서 Test가 가능하도록 하기 위해
	// Service Class의 매개변수를 HttpSerletRequest를 사용하지 않으려 합니다.

	@Autowired
	private SqlSession sqlSession;

	@Test
	public void testing() {
		//System.out.println(sqlSession);
		Item item = sqlSession.selectOne(
				"itemMapper.getItem", 2);
		System.out.println(item);
	}

}
