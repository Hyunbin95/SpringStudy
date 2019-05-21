package good.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import good.dao.GoodDAO;
import good.domain.Good;

//Service 클래스의 인스턴스를 자동으로 생성해주는 어노테이션
@Service
public class GoodService {
	@Autowired
	private GoodDAO goodDAO;
	
	//전체보기를 수행할 메소드
	public void allGood() {
		List<Good> list = goodDAO.allGood();
		
		//데이터 출력
		for(Good good : list) {
			System.out.println(good);
		}
	}
	
}
