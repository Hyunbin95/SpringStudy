import org.springframework.context.support.GenericXmlApplicationContext;

import hibernate.dao.GoodDAO;
import hibernate.domain.Good;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext(
						"classpath:applicationContext.xml");
		
		GoodDAO dao = context.getBean(GoodDAO.class);
		
		Good good = new Good();
		
		//System.out.println(dao.listGood());
		
		
		//1개를 가져올 때는 데이터가 없을  null을 리턴
		System.out.println(dao.get(1));
		System.out.println(dao.get(10001));
		
		System.err.println("데이터 가져오기:" + dao.get(2));
		System.err.println(dao.listGood());
		context.close();

	}

}