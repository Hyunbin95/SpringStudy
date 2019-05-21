import org.springframework.context.support.GenericXmlApplicationContext;

import mybatis.dao.TransactionDAO;

public class Main {

	public static void main(String[] args) {
		//SpringBeanConfiguration 파일을 이용하는 경우의 Context
		
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext(
						"classpath:applicationContext.xml");
		
		//SingerDAO dao = context.getBean(SingerDAO.class);
		
		
		
		//어노테이션으로 만들어진 설정 파일 불러오기
		/*
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(RootConfig.class);
		*/
		//Singer singer = new Singer();
		//singer.setName("이지연");
		//singer.setMajorsong("난 사랑을 아직 몰라");
		//dao.insertSinger(singer);
		
		TransactionDAO dao = context.getBean(TransactionDAO.class);
		dao.insert();
		
		context.close();
	}
}
