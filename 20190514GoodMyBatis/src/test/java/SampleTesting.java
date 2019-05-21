import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import good.dao.GoodDAO;
import good.domain.Good;

//스프링의 테스트 클래스로 설정
@RunWith(SpringJUnit4ClassRunner.class)
//스프링 설정 파일을 실행하기 위한 어노테이션
@ContextConfiguration("classpath:applicationContext.xml")
public class SampleTesting {
	@Autowired
	private GoodDAO goodDAO;
	
	@Test
	public void daoTest() {
		//System.out.println(goodDAO.codeSearch(1));
		//System.out.println(goodDAO.codeSearch(7));
		Good good = new Good();
		good.setCode(7);
		good.setName("Pepper");
		good.setManufacture("India");
		good.setPrice(3000);
		//int r = (goodDAO.insertGood(good));
		int r = (goodDAO.deleteGood(7));
		//삽입 및 삭제 갱신은 반드시 결과만 확인하지 말고
		//데이터베이스도 확인
		System.out.println(r);
	}
}
